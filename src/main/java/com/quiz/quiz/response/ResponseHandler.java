package com.quiz.quiz.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(Object data, HttpStatus status, String message, Boolean isOk){
        Map<String, Object> map = new HashMap<>();

        map.put("isOk", isOk);
        map.put("message", message);
        map.put("data", data);
        map.put("status", status);

        return new ResponseEntity<>(map, status);
    }
}
