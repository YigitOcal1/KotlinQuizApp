package com.example.quizapp.view.create

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.quizapp.components.InputField
import com.example.quizapp.view.SubmitButton

@Composable
fun CreateQuestionScreen(navController: NavController){
    val showQuestionForm= rememberSaveable {
        mutableStateOf(value = true)
    }
Surface(modifier = Modifier.fillMaxSize()) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "QuizApp", style = MaterialTheme.typography.h3, color = Color.Red.copy(alpha = 0.5f))
        QuestionForm(loading = false, isQuestionCreate = false){
            //firebase soruyu kaydet
                question,ans1,ans2,ans3,ans4->
        }

        }
    }

}


    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    fun QuestionForm(loading:Boolean=false,
                 isQuestionCreate:Boolean=false,
                 onDone:(String,String,String,String,String)-> Unit= {question,ans1,ans2,ans3,ans4 ->}){
        val question= rememberSaveable {
            mutableStateOf("")
        }
        val answer1= rememberSaveable {
            mutableStateOf("")
        }
        val answer2= rememberSaveable {
            mutableStateOf("")
        }
        val answer3= rememberSaveable {
            mutableStateOf("")
        }
        val answer4= rememberSaveable {
            mutableStateOf("")
        }

        //val passwordFocusRequest= FocusRequester.Default
        val  keyboardController= LocalSoftwareKeyboardController.current
        val valid= remember(question.value,answer1.value,answer2.value,answer3.value,answer4.value){

            question.value.trim().isNotEmpty()&& answer1.value.trim().isNotEmpty()

        }
        val modifier= Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .verticalScroll(rememberScrollState())
        Column(
            modifier, horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if(isQuestionCreate) Text(text = "Please enter a valid question", modifier = Modifier.padding(3.dp))else Text(text = "")
            InputField(valueState = question, enabled = !loading, labelId = "Question", onAction = KeyboardActions {
                FocusRequester.Default.requestFocus()
            })
            InputField(valueState = answer1, enabled = !loading, labelId = "Answer1", onAction = KeyboardActions {
                FocusRequester.Default.requestFocus()
            })
            InputField(valueState = answer2, enabled = !loading, labelId = "Answer2", onAction = KeyboardActions {
                FocusRequester.Default.requestFocus()
            })
            InputField(valueState = answer3, enabled = !loading, labelId = "answer3", onAction = KeyboardActions {
                FocusRequester.Default.requestFocus()
            })
            InputField(valueState = answer4, enabled = !loading, labelId = "answer4", onAction = KeyboardActions {
                FocusRequester.Default.requestFocus()
            })
            InputField(valueState = answer4, enabled = !loading, labelId = "answer4", onAction = KeyboardActions {
                FocusRequester.Default.requestFocus()
            })
            SubmitButton(
                textId= "Create a new question for the app",
                loading=loading,
                validinputs=valid
            ){
                onDone(question.value.trim(),answer1.value.trim(),answer2.value.trim(),answer3.value.trim(),answer4.value.trim())
                keyboardController?.hide()
            }
        }
    }
