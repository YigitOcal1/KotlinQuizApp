package com.example.quizapp.navigation

enum class QuizScreens {

    HomeSplashScreen,
    LoginScreen,
    RegisterScreen,
    HomeScreen;

    companion object {
        fun fromRoute(route:String?):QuizScreens
        =when(route?.substringBefore(delimiter = "/")){
            HomeSplashScreen.name->HomeSplashScreen
            LoginScreen.name->LoginScreen
            RegisterScreen.name->RegisterScreen
            HomeScreen.name->HomeScreen
            null->HomeScreen
            else ->throw IllegalAccessException("WRONG ROUTE")
        }
    }
}