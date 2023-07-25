package com.example.service;

import com.example.model.ChatRequestDto;
import com.example.model.ChatResponseDto;
import com.example.model.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

// @Component and @Service do the same thing. But @Component is better to use for things that are talking internally.
// @Service is good for talking externally to a service
@Service
public class OpenAIService {

    @Value("${API_KEY}")
    private String key;
    @Value("${API_URL}")
    private String url;
    @Value("${API_MODEL}")
    private String model;

    private RestTemplate template = new RestTemplate();

    public Message chat(String prompt) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(key);

        ChatRequestDto request = new ChatRequestDto(model, prompt);
        // bundle together your request and your header with HttpEntity
        HttpEntity<ChatRequestDto> entity = new HttpEntity<>(request, headers);

        // When we make the request, we will get back a response entity
        // ChatResponseDto.class is saying what type of object we are getting back. This is making it generic
        ResponseEntity<ChatResponseDto> response = template.postForEntity(url, entity, ChatResponseDto.class);

        // response.getBody gives you the body portion of the response (the responseDto)
        // get choices gives you
        // get the 0th one
        return response.getBody().getChoices().get(0).getMessage();
    }

}
