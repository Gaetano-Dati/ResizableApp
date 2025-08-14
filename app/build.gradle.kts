import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "com.gd.resizableapp"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.gd.myapplication"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    buildFeatures {
        compose = true
    }
}

// In this file, we declare all the dependencies for our Android application.
// A dependency is a library or module that our project needs to build and run.
dependencies {
    // Core Android libraries
    // ---------------------------------------------------------------------------------------------
    // Provides backward-compatible APIs for core Android features.
    implementation(libs.androidx.core.ktx)
    // Manages the lifecycle of an app's components, making it easier to handle data
    // and events based on the current lifecycle state (e.g., onCreate, onResume).
    implementation(libs.androidx.lifecycle.runtime.ktx)
    // Provides APIs for using Jetpack Compose in an Android Activity.
    implementation(libs.androidx.activity.compose)
    // Manages versions of Compose libraries to ensure compatibility across them.
    implementation(platform(libs.androidx.compose.bom))

    // Jetpack Compose Adaptive Libraries
    // ---------------------------------------------------------------------------------------------
    // Provides components to build responsive layouts that adapt to different screen sizes.
    implementation(libs.androidx.adaptive)
    // Offers a foundational layout for creating adaptive, multi-pane UIs.
    implementation(libs.androidx.adaptive.layout)
    // Provides components for creating navigation that adapts to different screen sizes and layouts.
    implementation(libs.androidx.adaptive.navigation)
    // A specialized navigation component for creating adaptive layouts with navigation suites.
    implementation(libs.androidx.adaptive.navigation.suite)

    // Jetpack Compose UI and Material Design
    // ---------------------------------------------------------------------------------------------
    // The core toolkit for building a UI with Jetpack Compose.
    implementation(libs.androidx.ui)
    // Provides graphics APIs for Jetpack Compose.
    implementation(libs.androidx.ui.graphics)
    // Enables UI previews of Composables within Android Studio.
    implementation(libs.androidx.ui.tooling.preview)
    // Provides Material 3 design system components for Jetpack Compose.
    implementation(libs.androidx.material3)

    // Image Loading
    // ---------------------------------------------------------------------------------------------
    // A fast and lightweight image loading library specifically for Jetpack Compose.
    implementation(libs.coil.compose)
    // Adds OkHttp integration for Coil, allowing it to handle network requests efficiently.
    implementation(libs.coil.network.okhttp)
    // Adds support for loading and displaying SVG images using Coil.
    implementation(libs.coil.svg)

    // Navigation
    // ---------------------------------------------------------------------------------------------
    // The core library for navigation in a Jetpack Compose application.
    implementation(libs.androidx.navigation.compose.android)

    // Testing
    // ---------------------------------------------------------------------------------------------
    // Standard JUnit 4 library for unit testing Java/Kotlin code.
    testImplementation(libs.junit)
    // Provides a JUnit 4 runner and rules for running Android-specific tests.
    androidTestImplementation(libs.androidx.junit)
    // Provides APIs for UI testing on Android, typically used for Espresso tests.
    androidTestImplementation(libs.androidx.espresso.core)
    // Manages versions of Compose libraries to ensure compatibility for testing.
    androidTestImplementation(platform(libs.androidx.compose.bom))
    // A dedicated testing library for Jetpack Compose UI components.
    androidTestImplementation(libs.androidx.ui.test.junit4)

    // Debugging
    // ---------------------------------------------------------------------------------------------
    // Provides tooling for debugging and inspecting Jetpack Compose UIs.
    debugImplementation(libs.androidx.ui.tooling)
    // Provides the necessary manifest entries for UI testing in debug builds.
    debugImplementation(libs.androidx.ui.test.manifest)
}