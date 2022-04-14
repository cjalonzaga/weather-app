package com.webb.app.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Json {
	
private static ObjectMapper objectMapper = getDefaultObjectMapper();
	
	private static ObjectMapper getDefaultObjectMapper() {
		ObjectMapper defaultObjectMapper = new ObjectMapper();
		
		defaultObjectMapper.configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		return defaultObjectMapper;
	}
	
	public static JsonNode parse(String src) throws JsonMappingException, JsonProcessingException {
		return objectMapper.readTree(src);
	}
	
	public static <T> T fromJson(JsonNode jsonNode , Class<T> cls) throws JsonProcessingException, IllegalArgumentException {
		return objectMapper.treeToValue(jsonNode, cls);
	}
	
	//convert Json to String
	public static String stringify(JsonNode node) throws JsonProcessingException {
		
		//ObjectWriter objectWriter = objectMapper.writer();
		
		return generateString(node , false);
	}
	
	//for better printing of json 
	public static String beautifyPrint(JsonNode node) throws JsonProcessingException {
//		ObjectWriter objectWriter = objectMapper.writer();
//		objectWriter = objectWriter.with(SerializationFeature.INDENT_OUTPUT);
		return generateString(node , true);
	}
	
	private static String generateString(JsonNode node , boolean isbeautiful) throws JsonProcessingException {
		ObjectWriter objectWriter = objectMapper.writer();
		if(isbeautiful) 
			objectWriter = objectWriter.with(SerializationFeature.INDENT_OUTPUT);	
		return objectWriter.writeValueAsString(node);
	}
}
