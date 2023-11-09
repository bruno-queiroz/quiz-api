package com.quiz.quiz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.quiz.models.Quiz;
import com.quiz.quiz.repositories.QuizRepository;

@Service
public class QuizServices {
    @Autowired
    private QuizRepository quizRepository;

    public Quiz createQuiz(Quiz quiz){
        return quizRepository.save(quiz);
    }
}
