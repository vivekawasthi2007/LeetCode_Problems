$folder = Get-Location

$watcher = New-Object System.IO.FileSystemWatcher
$watcher.Path = $folder
$watcher.IncludeSubdirectories = $true
$watcher.EnableRaisingEvents = $true

$action = {
    Start-Sleep -Seconds 3

    git add .

    $changes = git status --porcelain

    if ($changes) {
        git commit -m "initial update"
        git push
        Write-Host "Changes pushed to GitHub."
    }
}

Register-ObjectEvent $watcher Created -Action $action
Register-ObjectEvent $watcher Changed -Action $action

Write-Host "Auto GitHub Push is running..."
Write-Host "Press Ctrl+C to stop."

while ($true) {
    Start-Sleep -Seconds 5
}