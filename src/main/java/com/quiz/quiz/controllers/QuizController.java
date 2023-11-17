package com.quiz.quiz.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.quiz.dtos.AnswerQuizInputDto;
import com.quiz.quiz.models.Quiz;
import com.quiz.quiz.response.ResponseHandler;
import com.quiz.quiz.services.QuizServices;
import com.quiz.quiz.utils.AnswerPayload;

@RestController
@RequestMapping("quiz")
public class QuizController {
    
    @Autowired
    private QuizServices quizServices;

    @GetMapping
    ResponseEntity<Object> getQuizzes(){
        return ResponseHandler.generateResponse(quizServices.getQuizzes(), HttpStatus.OK, "All quiz questions was fetched.", true);
    }

    @PostMapping
    Quiz createQuiz(@RequestBody Quiz quiz){
        return quizServices.createQuiz(quiz);
    }

    @PostMapping("/answer/{quizId}")
    ResponseEntity<Object> answerQuiz(@PathVariable UUID quizId, @RequestBody AnswerQuizInputDto answer){
        AnswerPayload data = quizServices.answerQuiz(answer, quizId);
        if(data.getData() == null){
            return ResponseHandler.generateResponse(null, HttpStatus.NOT_FOUND, "Question not found.", false);
        }

        if(data.getIsCorrect() == false){
            return ResponseHandler.generateResponse(data, HttpStatus.CREATED, "Wrong answer!", true);

        }
        return ResponseHandler.generateResponse(data, HttpStatus.CREATED, "Right answer!", true);
    }
}
