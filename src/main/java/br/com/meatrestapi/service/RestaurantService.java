package br.com.meatrestapi.service;

import java.util.List;

import br.com.meatrestapi.model.MenuItem;
import br.com.meatrestapi.model.Restaurant;

public interface RestaurantService {
	public List<Restaurant> findAll();

	void load(List<Restaurant> lRestaurant, List<MenuItem> lItem);

	Restaurant findById(String id);
}
