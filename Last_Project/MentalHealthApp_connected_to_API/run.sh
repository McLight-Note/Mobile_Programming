#!/bin/bash
# ============================================================
# Mental Health Support App — Build & Run Script
# ============================================================
# Requirements: Java JDK 17+ installed
# Usage:
#   chmod +x run.sh
#   ./run.sh

echo "Compiling Mental Health Support App..."

mkdir -p out

# Find all .java files and compile them
find src -name "*.java" > sources.txt
javac -d out @sources.txt

if [ $? -ne 0 ]; then
    echo "Compilation failed. Make sure Java JDK 17+ is installed."
    exit 1
fi

echo "Compilation successful!"
echo "Running application..."
echo ""

# Run the main class
java -cp out com.mentalhealth.Main
