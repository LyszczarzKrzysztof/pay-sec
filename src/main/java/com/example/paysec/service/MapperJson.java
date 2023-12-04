package com.example.paysec.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class MapperJson<E> {
    private ObjectMapper objectMapper;

    public MapperJson(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String mapPojoToString(E pojo) throws JsonProcessingException {
        return objectMapper.writeValueAsString(pojo);
    }
}
