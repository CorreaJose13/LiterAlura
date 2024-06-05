package com.aluracursos.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OMapper implements IMapper{
    private ObjectMapper mapper = new ObjectMapper();
    @Override
    public <T> T convertData(String json, Class<T> customClass) {
        try {
            return mapper.readValue(json, customClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
