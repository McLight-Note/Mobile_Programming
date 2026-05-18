@echo off
REM ============================================================
REM Mental Health Support App — Build & Run (Windows)
REM ============================================================
REM Requirements: Java JDK 17+ installed and in PATH
REM Usage: Double-click run.bat OR run from Command Prompt

echo Compiling Mental Health Support App...

if not exist out mkdir out

REM Collect all .java files
dir /s /b src\*.java > sources.txt

javac -d out @sources.txt

if errorlevel 1 (
    echo.
    echo Compilation failed. Make sure Java JDK 17+ is installed.
    echo Download from: https://adoptium.net/
    pause
    exit /b 1
)

echo Compilation successful!
echo Running application...
echo.

java -cp out com.mentalhealth.Main

pause
