package com.quiz.quiz.utils;

public class AnswerPayload {
    private Object quiz;
    private Boolean isCorrect;

    public AnswerPayload(Object quiz, Boolean isCorrect){
        this.quiz = quiz;
        this.isCorrect = isCorrect;
    }

    public Object getData(){
        return this.quiz;
    }

    public Boolean getIsCorrect(){
        return this.isCorrect;
    }
}
