
# ============================================================
# LeetCode Auto README + Git Push
# ============================================================
# Run this script from the ROOT of your LeetCode repository.
#
# Requirements:
#   - Git installed and remote configured
#   - PowerShell 5.1+ / PowerShell 7+
#   - OPENAI_API_KEY environment variable
#
# It will:
#   1. Detect LeetCode_Problem<number>.java files
#   2. Create docs/README_Problem<number>.md if missing
#   3. Generate the README using the OpenAI Responses API
#   4. git add / commit / push
#   5. Keep watching for new/changed Java files
# ============================================================

$ErrorActionPreference = "Stop"

$RepoRoot = (Get-Location).Path
$DocsDir = Join-Path $RepoRoot "docs"
$Model = "gpt-5.6-luna"

if (-not $env:OPENAI_API_KEY) {
    Write-Host ""
    Write-Host "ERROR: OPENAI_API_KEY is not set." -ForegroundColor Red
    Write-Host 'Set it in PowerShell with:' -ForegroundColor Yellow
    Write-Host '$env:OPENAI_API_KEY = "YOUR_API_KEY"' -ForegroundColor Cyan
    Write-Host ""
    exit 1
}

if (-not (Test-Path $DocsDir)) {
    New-Item -ItemType Directory -Path $DocsDir | Out-Null
}

function Get-ProblemNumber {
    param([string]$FileName)

    if ($FileName -match '^LeetCode[_ ]Problem(\d+)\.java$') {
        return [int]$Matches[1]
    }

    return $null
}

function Get-LeetCodeInfo {
    param([int]$ProblemNumber)

    $query = @'
query($id: String!) {
  questionData(questionFrontendId: $id) {
    questionId
    title
    titleSlug
    difficulty
    content
    topicTags {
      name
    }
  }
}
'@

    $body = @{
        query = $query
        variables = @{
            id = "$ProblemNumber"
        }
    } | ConvertTo-Json -Depth 10

    try {
        $result = Invoke-RestMethod `
            -Uri "https://leetcode.com/graphql/" `
            -Method Post `
            -ContentType "application/json" `
            -Body $body `
            -Headers @{
                "User-Agent" = "Mozilla/5.0"
                "Referer" = "https://leetcode.com/"
            }

        if ($result.data.questionData) {
            return $result.data.questionData
        }
    }
    catch {
        Write-Host "LeetCode metadata could not be fetched. AI will infer metadata." -ForegroundColor Yellow
    }

    return $null
}

function Get-OpenAIText {
    param(
        [string]$Prompt
    )

    $body = @{
        model = $Model
        input = $Prompt
        store = $false
    } | ConvertTo-Json -Depth 20

    $response = Invoke-RestMethod `
        -Uri "https://api.openai.com/v1/responses" `
        -Method Post `
        -ContentType "application/json" `
        -Headers @{
            Authorization = "Bearer $($env:OPENAI_API_KEY)"
        } `
        -Body $body

    # Responses API returns generated text inside output message content.
    $parts = @()

    foreach ($item in $response.output) {
        if ($item.type -eq "message") {
            foreach ($content in $item.content) {
                if ($content.type -eq "output_text" -and $content.text) {
                    $parts += $content.text
                }
            }
        }
    }

    $text = ($parts -join "`n").Trim()

    if (-not $text) {
        throw "OpenAI returned no text output."
    }

    return $text
}

function New-ProblemReadme {
    param([string]$JavaFile)

    $fileName = Split-Path $JavaFile -Leaf
    $problemNumber = Get-ProblemNumber $fileName

    if ($null -eq $problemNumber) {
        return $false
    }

    $readmePath = Join-Path $DocsDir "README_Problem$problemNumber.md"

    if (Test-Path $readmePath) {
        return $false
    }

    Write-Host ""
    Write-Host "Generating README for Problem $problemNumber..." -ForegroundColor Cyan

    $javaCode = Get-Content -Raw -LiteralPath $JavaFile
    $lc = Get-LeetCodeInfo -ProblemNumber $problemNumber

    $title = ""
    $difficulty = ""
    $topics = ""
    $statement = ""
    $slug = ""

    if ($lc) {
        $title = $lc.title
        $difficulty = $lc.difficulty
        $topics = (($lc.topicTags | ForEach-Object { $_.name }) -join ", ")
        $statement = $lc.content
        $slug = $lc.titleSlug
    }

    if (-not $title) {
        $title = "LeetCode Problem $problemNumber"
    }

    $leetcodeUrl = if ($slug) {
        "https://leetcode.com/problems/$slug/"
    }
    else {
        "https://leetcode.com/problemset/"
    }

    $prompt = @"
You are generating a professional README for a student's Java LeetCode repository.

IMPORTANT:
- Return ONLY Markdown. Do not wrap the answer in triple backticks.
- Do not invent details that are contradicted by the supplied problem statement or Java code.
- Explain the submitted Java code, not a different solution.
- Keep the explanation beginner-friendly but technically correct.
- Do not include a runnable Main method unless the submitted code actually contains one.
- Do not claim the code is accepted unless that information is explicitly provided.

Problem number: $problemNumber
Problem title: $title
Difficulty: $difficulty
Topics: $topics
LeetCode URL: $leetcodeUrl

LeetCode problem statement (HTML/text, if available):
$statement

Submitted Java file: $fileName

Java code:
```java
$javaCode
```

Create a README with exactly these sections:

# Problem ${problemNumber}: $title

- **LeetCode:** [Problem $problemNumber - $title]($leetcodeUrl)
- **Difficulty:** $difficulty
- **Topics:** $topics

## Problem Statement
Give a clear, concise explanation of what the problem asks.

## Example
Give one representative input/output example and explain it briefly.

## Approach
Explain the algorithm used by the submitted code.

## Step-by-Step Explanation
Explain the important logic in simple steps, including important variables/loops/conditions.

## Java Solution
Include the submitted Java code unchanged in a Java code block.

## Complexity
State:
- **Time Complexity**
- **Space Complexity**

## Key Learning
Give 2-4 short points about the DSA concept learned from this problem.
"@

    try {
        $markdown = Get-OpenAIText -Prompt $prompt

        # Remove accidental outer markdown fences if the model adds them.
        $markdown = $markdown.Trim()
        if ($markdown.StartsWith('```markdown')) {
            $markdown = $markdown.Substring(11).Trim()
        }
        if ($markdown.EndsWith('```')) {
            $markdown = $markdown.Substring(0, $markdown.Length - 3).Trim()
        }

        Set-Content -LiteralPath $readmePath -Value $markdown -Encoding UTF8

        Write-Host "Created: docs/README_Problem$problemNumber.md" -ForegroundColor Green
        return $true
    }
    catch {
        Write-Host "README generation failed: $($_.Exception.Message)" -ForegroundColor Red
        return $false
    }
}

function Push-Changes {
    param([string]$Reason)

    try {
        git add .

        $status = git status --porcelain

        if (-not $status) {
            Write-Host "No Git changes to push." -ForegroundColor DarkGray
            return
        }

        $message = "Add LeetCode solution and README - $Reason"
        git commit -m $message

        # Rebase first so the script does not overwrite remote work.
        git pull --rebase origin main

        git push -u origin main

        Write-Host "GitHub push completed successfully." -ForegroundColor Green
    }
    catch {
        Write-Host "Git push failed. Check the Git output above." -ForegroundColor Red
    }
}

function Process-JavaFile {
    param([string]$FullPath)

    if (-not (Test-Path $FullPath)) {
        return
    }

    $name = Split-Path $FullPath -Leaf
    $number = Get-ProblemNumber $name

    if ($null -eq $number) {
        return
    }

    # Small delay so VS Code finishes writing the file.
    Start-Sleep -Milliseconds 700

    $created = New-ProblemReadme -JavaFile $FullPath

    # Push if the Java file itself or its new README has changed.
    if ($created) {
        Push-Changes -Reason "Problem $number"
    }
    else {
        # If the Java file already has a README, only push actual changes.
        git add $FullPath
        $status = git status --porcelain

        if ($status) {
            Push-Changes -Reason "Update Problem $number"
        }
    }
}

# ------------------------------------------------------------
# Initial scan: create missing READMEs for existing Java files.
# ------------------------------------------------------------

Write-Host ""
Write-Host "=== LeetCode Auto README + Git Push ===" -ForegroundColor Cyan
Write-Host "Repository: $RepoRoot"
Write-Host "Watching: $RepoRoot"
Write-Host ""

Get-ChildItem -Path $RepoRoot -Filter "LeetCode_Problem*.java" -File |
    ForEach-Object {
        Process-JavaFile -FullPath $_.FullName
    }

# ------------------------------------------------------------
# Watch for new/changed Java solution files.
# ------------------------------------------------------------

$watcher = New-Object System.IO.FileSystemWatcher
$watcher.Path = $RepoRoot
$watcher.Filter = "LeetCode_Problem*.java"
$watcher.IncludeSubdirectories = $false
$watcher.EnableRaisingEvents = $true

$action = {
    $path = $Event.SourceEventArgs.FullPath
    Process-JavaFile -FullPath $path
}

Register-ObjectEvent -InputObject $watcher -EventName Created -Action $action | Out-Null
Register-ObjectEvent -InputObject $watcher -EventName Changed -Action $action | Out-Null

Write-Host ""
Write-Host "Watching for new/changed LeetCode Java files..." -ForegroundColor Green
Write-Host "Example: add LeetCode_Problem37.java and save it." -ForegroundColor Yellow
Write-Host "Press Ctrl+C to stop." -ForegroundColor Yellow
Write-Host ""

while ($true) {
    Wait-Event -Timeout 5 | Out-Null
}
