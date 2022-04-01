package com.example.quizapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quizapp.view.*
import com.example.quizapp.view.create.CreateQuestionScreen
import com.example.quizapp.view.home.HomeScreen
import com.example.quizapp.view.quiz.QuizScreen


@Composable
fun QuizNavigation() {

    val navController= rememberNavController()

    NavHost(navController = navController, startDestination = QuizScreens.HomeSplashScreen.name ){
        composable(QuizScreens.HomeSplashScreen.name){
            HomeSplashScreen(navController=navController)
        }
        composable(QuizScreens.HomeScreen.name){
            HomeScreen(navController=navController)
        }
        composable(QuizScreens.LoginScreen.name){
            LoginScreen(navController=navController)
        }
        composable(QuizScreens.RegisterScreen.name){
            RegisterScreen(navController=navController)
        }
        composable(QuizScreens.CreateQuestionScreen.name){
            CreateQuestionScreen(navController = navController)
        }
        composable(QuizScreens.QuizScreen.name){
            QuizScreen(navController=navController)
        }
    }

}