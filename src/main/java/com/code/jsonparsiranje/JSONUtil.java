package com.code.jsonparsiranje;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JSONUtil {

    private static ObjectMapper objectMapper = getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper(){
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        defaultObjectMapper.registerModule(new JavaTimeModule());

        return defaultObjectMapper;
    }

    public static JsonNode parse(String source) throws JsonProcessingException {
        return objectMapper.readTree(source);
    }

    public static <T> T fromJson(JsonNode node, Class<T> clazz) throws JsonProcessingException {
        return objectMapper.treeToValue(node, clazz);
    }

    public static JsonNode toJSON(Object o){
        return objectMapper.valueToTree(o);
    }

    public static String stingify(JsonNode node) throws JsonProcessingException {
        return generateString(node, false);
    }

    public static String lepsiPrint(JsonNode node) throws JsonProcessingException {
       return generateString(node, true);
    }

    public static String generateString(JsonNode node, boolean pretty) throws JsonProcessingException {
        ObjectWriter objectWriter = objectMapper.writer();
        if ( pretty ){
            objectWriter = objectWriter.with(SerializationFeature.INDENT_OUTPUT);
        }
        return objectWriter.writeValueAsString(node);
    }

}
