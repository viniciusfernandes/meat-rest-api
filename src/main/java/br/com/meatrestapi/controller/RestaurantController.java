package br.com.meatrestapi.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.meatrestapi.model.MenuItem;
import br.com.meatrestapi.model.Restaurant;
import br.com.meatrestapi.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

	public RestaurantController() {

	}

	@Autowired
	private RestaurantService restaurantService;

	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Restaurant> findAll() {
		return restaurantService.findAll();
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Restaurant findById(@PathVariable String id) {
		return restaurantService.findById(id);
	}

	@GetMapping("/load")
	public void load() {
		ObjectMapper o = new ObjectMapper();
		List<Restaurant> lRestaurant = null;
		List<MenuItem> lItem = null;
		try {

			lRestaurant = o.readValue(new File(
					"C:\\Users\\vinicius\\ambiente_trabalho\\projetos\\springtool-workspace\\meat-rest-api\\restaurant.json"),
					new TypeReference<List<Restaurant>>() {
					});
			lItem = o.readValue(new File(
					"C:\\Users\\vinicius\\ambiente_trabalho\\projetos\\springtool-workspace\\meat-rest-api\\menuItem.json"),
					new TypeReference<List<MenuItem>>() {
					});
			restaurantService.load(lRestaurant, lItem);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
