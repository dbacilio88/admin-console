package com.bacsystem.microservice.console.region.infrastructure.adapter.input.messages.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.Map;

/**
 * ConversionUtils
 * <p>
 * ConversionUtils class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BACSYSTEM APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author cbaciliod
 * @author dbacilio88@outllok.es
 * @since 2/10/2024
 */
@Log4j2
public class ConversionUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private ConversionUtils() {
    }

    public static String map2Jsonstring(Map<String, Object> map) {
        log.info("map2Jsonstring {} ", map);
        if (map == null) return "{}";

        try {
            return objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            log.error("JsonProcessingException map2Jsonstring {} ", e.getMessage());
        }

        return "{}";
    }

    public static Map<String, Object> jsonstring2Map(String json) {
        if (json == null) return new HashMap<>();

        try {
            return objectMapper.readValue(json, Map.class);
        } catch (JsonProcessingException e) {
            log.error("JsonProcessingException jsonstring2Map {} ", e.getMessage());
        }

        return new HashMap<>();
    }
}
