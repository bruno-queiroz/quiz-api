package com.quiz.quiz.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class QuizControllerTests {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testGetQuiz() throws Exception{
        mvc
        .perform(MockMvcRequestBuilders.get("/quiz"))
        .andDo(print()).andExpect(MockMvcResultMatchers.status().isOk());
        
    }
}
