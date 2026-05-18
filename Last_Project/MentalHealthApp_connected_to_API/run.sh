echo "Compiling Mental Health Support App..."

mkdir -p out

find src -name "*.java" > sources.txt
javac -d out @sources.txt

if [ $? -ne 0 ]; then
    echo "Compilation failed. Make sure Java JDK 17+ is installed."
    exit 1
fi

echo "Compilation successful!"
echo "Running application..."
echo ""

java -cp out com.mentalhealth.Main
