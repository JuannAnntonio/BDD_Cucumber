package cucumber.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class ObjetctToJson {

	public static final String convert(Object entity) {
		Gson gson = new Gson();
		return gson.toJson(entity);
	}

	public static final <T> T convertToObject(String json, Class<T> clazz) {
		try {
			return new ObjectMapper().readValue(json, clazz);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
		}
		return null;
	}

}
