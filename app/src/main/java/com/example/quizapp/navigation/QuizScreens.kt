package com.example.quizapp.navigation

enum class QuizScreens {

    HomeSplashScreen,
    LoginScreen,
    RegisterScreen,
    HomeScreen,
    CreateQuestionScreen,
    QuizScreen;
    companion object {
        fun fromRoute(route:String?):QuizScreens
        =when(route?.substringBefore(delimiter = "/")){
            HomeSplashScreen.name->HomeSplashScreen
            LoginScreen.name->LoginScreen
            RegisterScreen.name->RegisterScreen
            HomeScreen.name->HomeScreen
            CreateQuestionScreen.name->CreateQuestionScreen
            QuizScreen.name->QuizScreen
            null->HomeScreen
            else ->throw IllegalAccessException("WRONG ROUTE")
        }
    }
}