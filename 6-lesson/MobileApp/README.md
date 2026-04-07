# Mobile App - Android Java Project

A simple Android app built with Java that demonstrates a basic counter application. This project is configured for continuous development with hot reload capabilities.

## Project Structure

```
MobileApp/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/mobileapp/
│   │   │   │   └── MainActivity.java        # Main app logic
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   └── activity_main.xml    # UI layout
│   │   │   │   └── values/
│   │   │   │       ├── strings.xml
│   │   │   │       └── themes.xml
│   │   │   └── AndroidManifest.xml
│   │   └── test/
│   ├── build.gradle
│   └── proguard-rules.pro
├── build.gradle
├── settings.gradle
└── README.md

```

## Setup Instructions

### Prerequisites
1. **Android Studio** - Download from [developer.android.com](https://developer.android.com/studio)
2. **Android SDK** - Install via Android Studio's SDK Manager (API Level 24+)
3. **Java 11+** - Required for building

### Installation Steps

1. **Open in Android Studio:**
   ```
   File → Open → Select the MobileApp folder
   ```

2. **Let Gradle Sync:**
   - Android Studio will automatically download dependencies
   - Wait for the sync to complete

3. **Connect Your Phone or Use Emulator:**
   - **Physical Device:** Enable USB Debugging (Settings → Developer Options → USB Debugging)
   - **Emulator:** Create a virtual device in Android Studio (Tools → Device Manager)

### Building & Running

#### Option 1: Using Android Studio (Recommended for First Run)
1. Click the green **Play** button (Run App)
2. Select your device/emulator
3. The app will install and launch

#### Option 2: Using Command Line
```bash
cd MobileApp
./gradlew installDebug      # Build and install on connected device
./gradlew assembleDebug     # Just build the APK
```

## Hot Reload Development

For rapid iteration while developing:

### Method 1: **Live Edit** (Best for UI Changes)
1. Run the app using the Play button
2. Edit your XML layout or drawable files
3. Android Studio detects changes automatically
4. Click "Apply Changes" that appears in the toolbar

### Method 2: **Debugger with Hot Reload**
1. Set breakpoints in your Java code
2. Click the **Debug** button (debugger icon) instead of Run
3. Make code changes while paused at breakpoints
4. Make minor changes while debugging for instant updates
5. Resume execution with F9 (Mac: Fn+F9)

### Method 3: **Continuous Gradle Watch** (For Frequent Builds)
```bash
./gradlew build --continuous
```
This rebuilds automatically when you save files.

## Current Features

- **Simple Counter App** - Click button to increment counter
- **Material Design** - Modern Android UI components
- **ViewBinding** - Type-safe view references
- **Responsive Layout** - Works on different screen sizes

## Next Steps for Development

1. **Add More Features:**
   - Edit [MainActivity.java](app/src/main/java/com/example/mobileapp/MainActivity.java) for logic
   - Edit [activity_main.xml](app/src/main/res/layout/activity_main.xml) for UI

2. **Edit Strings:**
   - Update [strings.xml](app/src/main/res/values/strings.xml) for text content

3. **Change Styling:**
   - Modify [themes.xml](app/src/main/res/values/themes.xml) for colors and styles

4. **Add Dependencies:**
   - Edit [build.gradle](app/build.gradle) in the app folder
   - Sync Gradle after adding dependencies

## Troubleshooting

| Issue | Solution |
|-------|----------|
| "No connected devices" | Enable USB Debugging on phone or create an emulator |
| Gradle sync fails | File → Invalidate Caches (with restart) |
| App crashes on launch | Check logcat output: View → Tool Windows → Logcat |
| Changes not applying | Rebuild: Build → Rebuild Project |

## Tips for Productive Development

✅ Use the **Logcat** window to see app logs and errors
✅ Press **Ctrl+F9** to rebuild and apply changes
✅ Use **Ctrl+K** to open device file explorer and pull app files
✅ Create multiple emulator instances for testing different Android versions

---

Happy coding! You can now continuously modify and test your app in real-time.
