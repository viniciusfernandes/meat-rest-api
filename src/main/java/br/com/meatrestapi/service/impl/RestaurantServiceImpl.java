package br.com.meatrestapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.meatrestapi.model.MenuItem;
import br.com.meatrestapi.model.Restaurant;
import br.com.meatrestapi.service.MenuItemDAO;
import br.com.meatrestapi.service.RestaurantDAO;
import br.com.meatrestapi.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	@Autowired
	private RestaurantDAO restaurantDAO;
	@Autowired
	private MenuItemDAO menuItemDAO;

	@Override
	public List<Restaurant> findAll() {
		return restaurantDAO.findAll();
	}

	@Transactional(readOnly = false)
	@Override
	public void load(List<Restaurant> lRestaurant, List<MenuItem> lItem) {
		restaurantDAO.load(lRestaurant);
		menuItemDAO.load(lItem);
	}

	@Override
	public Restaurant findById(String id) {
		return restaurantDAO.findById(id);
	}

}
