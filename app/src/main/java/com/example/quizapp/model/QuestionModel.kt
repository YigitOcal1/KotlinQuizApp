package com.example.quizapp.model

data class QuestionModel(val question:String,val answer1:String,val answer2:String,val answer3:String,val answer4:String
,val correctAnswer:String) {
    fun toMap():MutableMap<String, Any>{
        return mutableMapOf(
            "question" to this.question,
            "answer1" to  this.answer1,
            "answer2" to  this.answer2,
            "answer3" to  this.answer3,
            "answer4" to  this.answer4,
            "correct_answer" to this.correctAnswer

        )
    }
}