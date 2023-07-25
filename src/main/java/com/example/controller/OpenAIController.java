package com.example.controller;

import com.example.model.Message;
import com.example.service.OpenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenAIController {

    // @Autowired and @Service or @Component go hand in hand
    @Autowired
    private OpenAIService service;


    @GetMapping("/chat")
    public Message chat(@RequestParam String prompt) {
        return service.chat(prompt);
    }

}
