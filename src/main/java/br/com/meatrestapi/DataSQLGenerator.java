package br.com.meatrestapi;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.meatrestapi.model.Restaurant;

public class DataSQLGenerator {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper o = new ObjectMapper();
		List<Restaurant> r = (List<Restaurant>) o.readValue(new File(
				"C:\\Users\\vinicius\\ambiente_trabalho\\projetos\\springtool-workspace\\meat-rest-api\\restaurant.json"),
				new TypeReference<List<Restaurant>>() {
				});
		System.out.println(r);
	}

}
