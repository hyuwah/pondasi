# Pondasi
[![](https://jitpack.io/v/hyuwah/pondasi.svg)](https://jitpack.io/#hyuwah/pondasi)
[![Kotlin](https://img.shields.io/badge/Kotlin-1.5.31-blue.svg)](https://kotlinlang.org) [![Platform](https://img.shields.io/badge/Platform-Android-green.svg)](https://developer.android.com/guide/)
![API](https://img.shields.io/badge/Min%20API-21-green)
![API](https://img.shields.io/badge/Compiled%20API-31-green)

Opinionated scaffolding for developing android apps

## Setup

```gradle
// project build.gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
}
```

```gradle
// module build.gradle
dependencies {
	        implementation 'com.github.hyuwah:pondasi:version'
}
```

```gradle
// For compatibility, make sure to add / enable these
android {
    ...
    buildFeatures {
        viewBinding true
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_11
        targetCompatibility JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = '11'
    }
}
```

## Quick Start

```kotlin
// TODO included dependencies
// TODO extension list
```