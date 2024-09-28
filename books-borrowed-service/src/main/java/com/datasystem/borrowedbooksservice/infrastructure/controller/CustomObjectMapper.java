package com.datasystem.borrowedbooksservice.infrastructure.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomObjectMapper extends ObjectMapper {

    public <T> T readValueWithExceptionHandling(String content, Class<T> valueType) {
        try {
            return this.readValue(content, valueType);
        } catch (JsonProcessingException e) {
            log.error("Błąd przetwarzania JSON: {}", e.getMessage(), e);
        }
        return null;
    }
}