# ResizableApp

![Kotlin](https://img.shields.io/badge/Kotlin-FF5722?style=flat-square&logo=kotlin)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=flat-square&logo=android)
![Android](https://img.shields.io/badge/Android-3DDC84?style=flat-square&logo=android)

**ResizableApp** is a proof-of-concept Android app demonstrating **resizable UI patterns** for phones, tablets, and foldable devices using **Jetpack Compose**.

---

## 🎯 Features

- Adaptive layouts for multiple screen sizes
- **NavigationSuiteScaffold**: Unified BottomBar + NavigationRail
- **ListDetailPaneScaffold** to have an auto-handled ListPane and DetailPane
- Centralized navigation with `NavHost` & `AppDestinations`
- Mock cryptocurrency data for demonstration
- Clean modular Compose architecture

---

## 🖥 Screenshots / Demo

<img src="media/sample.gif" width="500" />

<table>
  <thead>
    <tr>
      <th scope="col">Compact</th>
      <th scope="col">Large</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>
        <img src="media/compact-portrait.png" width="200" />
        <img src="media/compact-portrait-details.png" width="200" />
        <img src="media/compact-landscape.png" width="450" />
      </td>
      <td>
        <img src="media/large-portrait.png" width="250" />
        <img src="media/large-portrait-split-screen.png" width="250" />
        <img src="media/large-landscape-split-screen.png" width="500" />
      </td>
    </tr>
  </tbody>
</table>

---

## 📁 Project Structure

```bash
com.gd.resizableapp/
├─ core/ # Navigation & utilities
├─ featuredetail/ # Detail screen
├─ featurehome/ # Home screen & components
├─ featuresettings/ # Settings screen
├─ model/ # Data models
├─ ui/ # Theme & scaffold
└─ MainActivity.kt # Entry point
```

---

## 🚀 How to Run

```bash
git clone https://github.com/Gaetano-Dati/resizableapp.git
```

1. Open in Android Studio
2. Build & run on any device or emulator
3. Resize window to see adaptive layouts in action
4. Rotate the phone to study which data are shown everytime
