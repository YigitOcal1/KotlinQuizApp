package com.example.quizapp.model

data class UserModel(var userId:String?=null,var email:String?=null,var password:String?=null,var username:String?=null) {
    fun toMap()= mapOf(
        "userId" to userId,
        "email" to email,
        "password" to password,
        "username" to username
    )
}