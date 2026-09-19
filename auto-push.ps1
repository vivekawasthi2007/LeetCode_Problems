# LeetCode Auto Push Script

$repoPath = Split-Path -Parent $MyInvocation.MyCommand.Path
Set-Location $repoPath

Write-Host "=== LeetCode Auto Git Push ===" -ForegroundColor Green
Write-Host "Repository: $repoPath"
Write-Host "Watching for file changes..."
Write-Host "Press Ctrl+C to stop."

# Push any existing changes once when the script starts
function Push-Changes {
    $status = git status --porcelain

    if ($status) {
        Write-Host "Changes detected. Pushing to GitHub..." -ForegroundColor Yellow

        git add .
        git commit -m "Update LeetCode solutions"

        if ($LASTEXITCODE -eq 0) {
            git pull --rebase origin main

            if ($LASTEXITCODE -eq 0) {
                git push origin main

                if ($LASTEXITCODE -eq 0) {
                    Write-Host "Successfully pushed to GitHub." -ForegroundColor Green
                }
                else {
                    Write-Host "Git push failed." -ForegroundColor Red
                }
            }
            else {
                Write-Host "Git pull --rebase failed." -ForegroundColor Red
            }
        }
    }
}

Push-Changes

# Monitor the repository for changes
$watcher = New-Object System.IO.FileSystemWatcher
$watcher.Path = $repoPath
$watcher.IncludeSubdirectories = $true
$watcher.EnableRaisingEvents = $true
$watcher.NotifyFilter = [System.IO.NotifyFilters]'FileName, LastWrite, Size, DirectoryName'

$action = {
    Start-Sleep -Seconds 2

    # Ignore Git's internal files and this script itself
    $changedPath = $Event.SourceEventArgs.FullPath

    if ($changedPath -notlike "$repoPath\.git\*" -and
        $changedPath -ne "$repoPath\auto-push.ps1") {
        Push-Changes
    }
}

Register-ObjectEvent $watcher Created -Action $action | Out-Null
Register-ObjectEvent $watcher Changed -Action $action | Out-Null
Register-ObjectEvent $watcher Deleted -Action $action | Out-Null
Register-ObjectEvent $watcher Renamed -Action $action | Out-Null

while ($true) {
    Wait-Event -Timeout 5 | Out-Null
}
