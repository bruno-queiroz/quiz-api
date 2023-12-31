package com.quiz.quiz.services;

import java.util.Optional;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.quiz.dtos.AnswerQuizInputDto;
import com.quiz.quiz.models.Quiz;
import com.quiz.quiz.repositories.QuizRepository;
import com.quiz.quiz.utils.AnswerPayload;

@Service
public class QuizServices {
    @Autowired
    private QuizRepository quizRepository;

    public List<Quiz> getQuizzes(){
        return quizRepository.findAll();
    }

    public Quiz createQuiz(Quiz quiz){
        return quizRepository.save(quiz);
    }

    public AnswerPayload answerQuiz(AnswerQuizInputDto answer, UUID quizId){
        Optional<Quiz> quizOptional = quizRepository.findById(quizId);

        if(quizOptional.isPresent()){
            Quiz quiz = quizOptional.get();

            if(quiz.getAnswer() == answer.answer()){
                return new AnswerPayload(quiz, true);
            } else{
                return new AnswerPayload(quiz, false);
            }
        }

        return new AnswerPayload(null, false); 
    }

    public void deleteQuiz(UUID quizId){
        quizRepository.deleteById(quizId);
    }

    public Optional<Quiz> updateQuiz(UUID quizId, Quiz quiz){
        Optional<Quiz> optionalQuiz = quizRepository.findById(quizId);

        if(optionalQuiz.isPresent()){
            Quiz quizToUpdate = optionalQuiz.get();

            quizToUpdate.setQuestion(quiz.getQuestion());
            quizToUpdate.setAnswer(quiz.getAnswer());
            quizToUpdate.setA(quiz.getA());
            quizToUpdate.setB(quiz.getB());
            quizToUpdate.setC(quiz.getC());
            quizToUpdate.setD(quiz.getD());

            quizRepository.save(quizToUpdate);
            return Optional.of(quizToUpdate);
        } else{
            return Optional.empty();
        }
    }

}
