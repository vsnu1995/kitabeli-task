package com.vsnu.market.utilities;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import java.io.IOException;
import java.util.Map;

public class HashMapConverter implements AttributeConverter<Map<String, Object>, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Map<String, Object> variations) {

        String variationsJson = null;
        try {
            variationsJson = objectMapper.writeValueAsString(variations);
        } catch (final JsonProcessingException e) {
            //do something
        }

        return variationsJson;
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String variationsJson) {

        Map<String, Object> variations = null;
        try {
            variations = objectMapper.readValue(variationsJson, Map.class);
        } catch (final IOException e) {
            //do something
            System.out.println(e);
        }

        return variations;
    }

}