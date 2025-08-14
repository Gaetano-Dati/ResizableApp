# ResizableApp

![Kotlin](https://img.shields.io/badge/Kotlin-FF5722?style=flat-square&logo=kotlin)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=flat-square&logo=android)
![Android](https://img.shields.io/badge/Android-3DDC84?style=flat-square&logo=android)

**ResizableApp** is a proof-of-concept Android app demonstrating **resizable UI patterns** for phones, tablets, and foldable devices using **Jetpack Compose**.

---

## 🎯 Features

- Adaptive layouts for multiple screen sizes
- **NavigationSuiteScaffold**: Unified BottomBar + NavigationRail
- Centralized navigation with `NavHost` & `AppDestinations`
- Mock cryptocurrency data for demonstration
- Clean modular Compose architecture

---

## 🖥 Screenshots / Demo

![ResizableApp Demo](https://user-images.githubusercontent.com/yourusername/demo.gif)  
*Example showing BottomBar on phone and NavigationRail on tablet*

---

## 📁 Project Structure

com.gd.resizableapp/
├─ core/ # Navigation & utilities
├─ featuredetail/ # Detail screen
├─ featurehome/ # Home screen & components
├─ featuresettings/ # Settings screen
├─ model/ # Data models
├─ ui/ # Theme & scaffold
└─ MainActivity.kt # Entry point


---

## 🚀 How to Run

```bash
git clone https://github.com/gaetano-dati/resizableapp.git

- Open in Android Studio
- Build & run on any device or emulator
- Resize window to see adaptive layouts in action