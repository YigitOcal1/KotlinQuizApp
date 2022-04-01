package com.example.quizapp.view.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.quizapp.navigation.QuizScreens

@Composable
fun HomeScreen(navController: NavController){

  Surface(modifier = Modifier.fillMaxSize()) {
      Text(text = "QuizApp", style = MaterialTheme.typography.h3, color = Color.Red.copy(alpha = 0.5f))
      Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

          Button(onClick = { navController.navigate(QuizScreens.QuizScreen.name) }, modifier = Modifier
              .padding(3.dp)
              .fillMaxWidth(),
              shape = RectangleShape) {
              Text(text = "Start a new short quiz")
          }
          Button(onClick = { navController.navigate(QuizScreens.CreateQuestionScreen.name) }, modifier = Modifier
              .padding(3.dp)
              .fillMaxWidth(),
          shape = RectangleShape) {
            Text(text = "Create a new question")
          }

         
      }
        
    }

}
