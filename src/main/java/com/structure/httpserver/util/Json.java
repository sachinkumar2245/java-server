package com.structure.httpserver.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

import static com.fasterxml.jackson.databind.SerializationFeature.*;

public class Json {

    private static ObjectMapper myObjectMapper;

    public static ObjectMapper defualtObjectMapper(){
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return om;
    }

    public static JsonNode parse(String jsonSrc) throws JsonProcessingException {
        return myObjectMapper.readTree(jsonSrc);
    }

    public static <A> A fromJson(JsonNode node, Class<A> clazz) throws JsonProcessingException {
        return myObjectMapper.treeToValue(node, clazz);
    }

    public static JsonNode toJson(Object obj){
        return myObjectMapper.valueToTree(obj);
    }

    public static String stringify(JsonNode node){
        return generateJson(node, false);
    }

    public static String stringifyPretty(JsonNode node) throws JsonProcessingException {

        return generateJson(node, true);
    }

    //creating an auxiallary method to generate json

    private static String generateJson(Object o, boolean pretty) throws JsonProcessingException {
        ObjectWriter objectWriter = myObjectMapper.writer();


        // Apply pretty-printing if requested


        if (pretty) {
            objectWriter = myObjectMapper.writerWithDefaultPrettyPrinter();
        }

        return objectWriter.writeValueAsString(o);
    }
}
