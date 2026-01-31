# BMI Calculator Android App

A simple Android application that calculates Body Mass Index (BMI) based on user input for weight and height.

## Features

- Input fields for weight (kg) and height (meters)
- Calculate BMI with the formula: weight / (height * height)
- Display BMI result and category:
  - BMI < 18.5: Underweight
  - BMI 18.5-24.9: Normal weight
  - BMI 25-29.9: Overweight
  - BMI ≥ 30: Obese
- Clean, user-friendly interface
- Input validation

## Build Requirements

- JDK 17
- Gradle 8.0+
- Android SDK:
  - Min SDK: 24
  - Target SDK: 34
  - Compile SDK: 34

## Building the App

### Using Gradle Wrapper (No Android Studio Required)

```bash
# Make gradlew executable (Unix/Linux/Mac)
chmod +x gradlew

# Build debug APK
./gradlew assembleDebug

# Build release APK
./gradlew assembleRelease
```

The APK will be generated in: `app/build/outputs/apk/debug/app-debug.apk`

### Using GitHub Actions

The project includes a GitHub Actions workflow that automatically builds the APK on:
- Push to main branch
- Pull requests
- Manual workflow dispatch

The built APK is available as an artifact named "bmi-calculator-debug" in the Actions tab.

## Project Structure

```
BMI/
├── .github/
│   └── workflows/
│       └── android-build.yml    # CI/CD workflow
├── app/
│   ├── build.gradle             # App-level Gradle config
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml
│           ├── java/com/example/bmicalculator/
│           │   └── MainActivity.kt
│           └── res/
│               ├── layout/
│               │   └── activity_main.xml
│               └── values/
│                   └── strings.xml
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── build.gradle                 # Project-level Gradle config
├── settings.gradle
├── gradle.properties
├── gradlew                      # Unix Gradle wrapper
└── gradlew.bat                  # Windows Gradle wrapper
```

## Development

This project can be developed using:
- GitHub Codespaces (browser-based VS Code)
- Local VS Code with Kotlin and Android extensions
- Android Studio

No local Android Studio installation is required for building - the project can be built entirely through command line or GitHub Actions.

## Dependencies

- androidx.core:core-ktx:1.12.0
- androidx.appcompat:appcompat:1.6.1
- com.google.android.material:material:1.11.0
- androidx.constraintlayout:constraintlayout:2.1.4

## License

This project is created as a demonstration of Android app development with GitHub Actions integration.
