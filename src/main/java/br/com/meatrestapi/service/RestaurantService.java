package br.com.meatrestapi.service;

import java.util.List;

import br.com.meatrestapi.model.MenuItem;
import br.com.meatrestapi.model.Order;
import br.com.meatrestapi.model.Restaurant;
import br.com.meatrestapi.model.Review;

public interface RestaurantService {
	public List<Restaurant> findAll();

	void load(List<Restaurant> lRestaurant, List<MenuItem> lItem, List<Review> lReview);

	Restaurant findById(String id);

	List<MenuItem> findMenuItemByIdRestaurant(String idRestaurant);

	List<Review> findReviewByIdRestaurant(String idRestaurant);

	Integer saveOrder(Order order);

	List<MenuItem> findMenuItemStatisticsIdRestaurant(String idRestaurant);
}
