# Lecture MP3 Pro

A premium offline music player for Android with Material Design 3, featuring comprehensive music library management, advanced playback controls, and modern UI.

## Features

- **Offline Music Player** - Play audio files without internet
- **Multi-Format Support** - MP3, WAV, FLAC, AAC, OGG, M4A, OPUS
- **Comprehensive Library** - Songs, Albums, Artists, Genres, Folders, Playlists
- **Advanced Playback** - Queue, Shuffle, Repeat, Equalizer, Bass Boost, Virtualizer
- **Background Playback** - Notification and lock screen controls
- **Bluetooth & Headset Support** - Full wireless and wired device support
- **Sleep Timer & Playback Speed Control**
- **Lyrics Support** - View song lyrics while playing
- **Material Design 3** - Modern UI with dark/light modes and dynamic colors
- **Internationalization** - Arabic RTL and English support
- **AdMob Integration** - Banner, Native, Interstitial, Rewarded, and App Open ads
- **Firebase Analytics & Crashlytics** - Performance monitoring

## Tech Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Design System**: Material Design 3
- **Architecture**: MVVM + Clean Architecture
- **Dependency Injection**: Hilt
- **Local Database**: Room
- **Preferences**: DataStore
- **Media Playback**: Media3 (ExoPlayer)
- **Async**: Coroutines + Flow
- **Image Loading**: Coil
- **Navigation**: Navigation Compose
- **Logging**: Timber
- **Analytics**: Firebase
- **Ads**: Google AdMob with UMP

## Requirements

- Android 8.0 (API 26) or higher
- Latest Stable Android SDK
- Gradle 8.0+

## Project Structure

```
lecture-mp3/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── kotlin/com/lecturempo3pro/
│   │   │   │   ├── data/
│   │   │   │   ├── domain/
│   │   │   │   ├── presentation/
│   │   │   │   ├── di/
│   │   │   │   ├── navigation/
│   │   │   │   └── App.kt
│   │   │   ├── res/
│   │   │   └── AndroidManifest.xml
│   │   ├── test/
│   │   └── androidTest/
│   ├── build.gradle.kts
│   └── proguard-rules.pro
├── build.gradle.kts
└── gradle/
    └── libs.versions.toml
```

## License

Proprietary
