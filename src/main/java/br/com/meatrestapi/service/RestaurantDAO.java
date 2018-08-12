package br.com.meatrestapi.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.meatrestapi.model.Restaurant;

@Repository
public class RestaurantDAO extends AbstractDAO<Restaurant, String> {
	public void load(List<Restaurant> lRestaurant) {
		for (Restaurant r : lRestaurant) {
			save(r);
		}

	}

}
