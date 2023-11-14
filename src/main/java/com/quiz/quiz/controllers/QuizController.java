package com.quiz.quiz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.quiz.models.Quiz;
import com.quiz.quiz.services.QuizServices;

@RestController
@RequestMapping("quiz")
public class QuizController {
    
    @Autowired
    private QuizServices quizServices;

    @PostMapping
    Quiz createQuiz(@RequestBody Quiz quiz){
        return quizServices.createQuiz(quiz);
    }
}
