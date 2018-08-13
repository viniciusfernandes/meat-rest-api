package br.com.meatrestapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.meatrestapi.model.MenuItem;
import br.com.meatrestapi.model.Restaurant;
import br.com.meatrestapi.model.Review;
import br.com.meatrestapi.service.MenuItemDAO;
import br.com.meatrestapi.service.RestaurantDAO;
import br.com.meatrestapi.service.RestaurantService;
import br.com.meatrestapi.service.ReviewDAO;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	@Autowired
	private RestaurantDAO restaurantDAO;
	@Autowired
	private MenuItemDAO menuItemDAO;
	@Autowired
	private ReviewDAO reviewDAO;

	@Override
	public List<Restaurant> findAll() {
		return restaurantDAO.findAll();
	}

	@Transactional(readOnly = false)
	@Override
	public void load(List<Restaurant> lRestaurant, List<MenuItem> lItem, List<Review> lReview) {
		restaurantDAO.load(lRestaurant);
		menuItemDAO.load(lItem);
		reviewDAO.load(lReview);
	}

	@Override
	public Restaurant findById(String id) {
		return restaurantDAO.findById(id);
	}

	@Override
	public List<MenuItem> findMenuItemByIdRestaurant(String idRestaurant) {
		List<MenuItem> l = menuItemDAO.findMenuItemByIdRestaurant(idRestaurant);
		for (MenuItem m : l) {
			m.setRestaurant(null);
		}
		return l;
	}

	@Override
	public List<Review> findReviewByIdRestaurant(String idRestaurant) {
		List<Review> l = reviewDAO.findReviewByIdRestaurant(idRestaurant);
		for (Review r : l) {
			r.setRestaurant(null);
		}
		return l;
	}

}
