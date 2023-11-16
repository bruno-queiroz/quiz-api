package com.quiz.quiz.utils;

public class AnswerPayload {
    private Object data;
    private Boolean isCorrect;

    public AnswerPayload(Object data, Boolean isCorrect){
        this.data = data;
        this.isCorrect = isCorrect;
    }

    public Object getData(){
        return this.data;
    }

    public Boolean getIsCorrect(){
        return this.isCorrect;
    }
}
