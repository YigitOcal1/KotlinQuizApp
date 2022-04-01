package com.example.quizapp.view

import android.view.animation.OvershootInterpolator
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import com.example.quizapp.navigation.QuizScreens
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay


@Composable
fun HomeSplashScreen(navController: NavController){

    val scale= remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true){
    scale.animateTo(targetValue = 0.9f, animationSpec = tween(760, easing = {
        OvershootInterpolator(8f).getInterpolation(it)
    }))
        delay(2500L)

        //if user logged in stay in the session
       if(FirebaseAuth.getInstance().currentUser?.email.isNullOrEmpty()){
            navController.navigate(QuizScreens.LoginScreen.name)
        }
        else{
            navController.navigate(QuizScreens.HomeScreen.name)
        }
        //navController.navigate(QuizScreens.LoginScreen.name)
    }

    Surface(modifier = Modifier
        .padding(16.dp)
        .size(350.dp),
        shape = CircleShape,
        color = Color.White,
        border = BorderStroke(width = 2.dp,
        color = Color.LightGray)

        ) {
        Column(modifier = Modifier.padding(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

            Text(text = "QuizApp", style = MaterialTheme.typography.h3, color = Color.Red.copy(alpha = 0.5f))
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = "\"qwe.qweq qweq.\"",
            style = MaterialTheme.typography.h5,
                color=Color.DarkGray
            )
        }

    }
}