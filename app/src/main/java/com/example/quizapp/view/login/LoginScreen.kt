package com.example.quizapp.view

import android.util.Log
import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import com.example.quizapp.components.EmailInput
import com.example.quizapp.components.PasswordInput

@Composable
fun LoginScreen(navController: NavController){

    Surface(modifier = Modifier.fillMaxSize() ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement =Arrangement.Top ) {
            Text(text = "QuizApp", style = MaterialTheme.typography.h3, color = Color.Red.copy(alpha = 0.5f))
            UserForm(loading = false, isCreateAccount = false){
                    email,pasworrd->
                Log.d("wewqe","ewqewqewq")
            }
        }
    }

    
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun UserForm(loading:Boolean=false,
isCreateAccount:Boolean=false,
onDone:(String,String)-> Unit= {email,pwd ->}){
    val email= rememberSaveable {
        mutableStateOf("")
    }
    val password= rememberSaveable {
        mutableStateOf("")
    }
    val passwordVisibility= rememberSaveable {
        mutableStateOf(false)
    }
    val passwordFocusRequest=FocusRequester.Default
    val  keyboardController=LocalSoftwareKeyboardController.current
    val valid=remember(email.value,password.value){

        email.value.trim().isNotEmpty()&& password.value.trim().isNotEmpty()

    }

    val modifier= Modifier
        .height(250.dp)
        .background(MaterialTheme.colors.background)
        .verticalScroll(rememberScrollState())
    Column(
        modifier, horizontalAlignment = Alignment.CenterHorizontally
    ) {
    EmailInput(emailState = email, enabled = !loading, onAction = KeyboardActions {
        passwordFocusRequest.requestFocus()
    })
        PasswordInput(modifier=Modifier.focusRequester(passwordFocusRequest),
        passwordState=password,
        labelId="Password",
        enabled=!loading,
        passwordVisibility=passwordVisibility,
        onAction= KeyboardActions {
            if(!valid) return@KeyboardActions
            onDone(email.value.trim(),password.value.trim())
        })
        SubmitButton(
            textId=if(isCreateAccount)"Create a new account" else "Login",
        loading=loading,
            validinputs=valid
        ){
            onDone(email.value.trim(),password.value.trim())
        }
    }
}

@Composable
fun SubmitButton(textId: String, loading: Boolean, validinputs: Boolean,onClick:()->Unit) {
    
    Button(onClick = onClick,
    modifier = Modifier
        .padding(3.dp)
        .fillMaxWidth(),
    enabled = !loading&&validinputs,
    shape= CircleShape) {
        if(loading) CircularProgressIndicator(modifier = Modifier.size(25.dp))
        else Text(text = textId, modifier = Modifier.padding(5.dp))
    }
}


