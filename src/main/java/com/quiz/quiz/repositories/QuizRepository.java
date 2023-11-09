package com.quiz.quiz.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.quiz.models.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, UUID>{

}
