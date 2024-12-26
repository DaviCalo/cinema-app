<div align="center">
  <img alt="Logo" src="https://raw.githubusercontent.com/DaviCalo/cinema-app/main/app/src/main/ic_launcher-playstore.png" width="100" style="border-radius: 10px;"/>
</div>

# CinemaApp

CinemaApp is a mobile application developed with Kotlin that uses the TMDb (The Movie Database) API to provide detailed information about movies and series. With this app, users can explore popular movies and series, search for specific titles, and view trailers.

## Screenshots

<div>
  <img alt="home screen" src="https://raw.githubusercontent.com/DaviCalo/cinema-app/main/app/src/main/res/drawable/cine_app.png" width="200"/>
  <img alt="home screen" src="https://raw.githubusercontent.com/DaviCalo/cinema-app/main/app/src/main/res/drawable/filme_screenshot.png" width="200"/>
  <img alt="home screen" src="https://raw.githubusercontent.com/DaviCalo/cinema-app/main/app/src/main/res/drawable/favorite_screenshot.png" width="200"/>
</div>

## Features

- List popular movies
- Search for movies by title
- View detailed information about movies (synopsis, release date, ratings, etc.)
- Watch movie trailers
- User-friendly and responsive interface

## Technologies Used

- Kotlin
- Android Studio
- Retrofit (for HTTP requests)
- ViewModel (for state management)
- <a href="https://developer.themoviedb.org/reference/intro/getting-started">TMDB API </a>
- Youtube API

## Prerequisites

Before you begin, ensure you have the following installed:

- Android Studio
- Latest Android SDK
- Emulator or Android device for testing

## Installation

1. Clone the repository:

```sh
git clone https://github.com/DaviCalo/cinema-app
```
2. Open the project in Android Studio.
    
3.   Sync the project with Gradle to resolve all dependencies.
    
4.  Obtain an API key from TMDb here and add it to your `local.properties` file:
```sh
TMDB_API_KEY=YOUR_API_KEY
```
5.  Connect your Android device or set up an emulator.
    
6. Run the application.
