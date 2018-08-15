package br.com.meatrestapi.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.meatrestapi.model.MenuItem;
import br.com.meatrestapi.model.Order;
import br.com.meatrestapi.model.Restaurant;
import br.com.meatrestapi.model.Review;
import br.com.meatrestapi.service.RestaurantService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

	public RestaurantController() {

	}

	@Autowired
	private RestaurantService restaurantService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Restaurant> findAll() {
		return restaurantService.findAll();
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Restaurant findById(@PathVariable String id) {
		return restaurantService.findById(id);
	}

	@RequestMapping(path = "/{id}/menu", method = RequestMethod.GET)
	@ResponseBody
	public List<MenuItem> findMenuItemByIdRestaurant(@PathVariable String id) {
		return restaurantService.findMenuItemByIdRestaurant(id);
	}

	@RequestMapping(path = "/order", method = RequestMethod.POST)
	public Integer saveOrder(@RequestBody Order order) {
		return restaurantService.saveOrder(order);
	}

	@RequestMapping(path = "/{id}/review", method = RequestMethod.GET)
	@ResponseBody
	public List<Review> findReviewByIdRestaurant(@PathVariable String id) {
		return restaurantService.findReviewByIdRestaurant(id);
	}

	@RequestMapping(path = "/load", method = RequestMethod.GET)
	public void load() {
		ObjectMapper o = new ObjectMapper();
		List<Restaurant> lRestaurant = null;
		List<MenuItem> lItem = null;
		List<Review> lReview = null;
		try {

			lRestaurant = o.readValue(new File(
					"C:\\Users\\vinicius\\ambiente_trabalho\\projetos\\springtool-workspace\\meat-rest-api\\restaurant.json"),
					new TypeReference<List<Restaurant>>() {
					});
			lItem = o.readValue(new File(
					"C:\\Users\\vinicius\\ambiente_trabalho\\projetos\\springtool-workspace\\meat-rest-api\\menuItem.json"),
					new TypeReference<List<MenuItem>>() {
					});

			lReview = o.readValue(new File(
					"C:\\Users\\vinicius\\ambiente_trabalho\\projetos\\springtool-workspace\\meat-rest-api\\review.json"),
					new TypeReference<List<Review>>() {
					});
			restaurantService.load(lRestaurant, lItem, lReview);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
