package br.com.meatrestapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.meatrestapi.dao.MenuItemDAO;
import br.com.meatrestapi.dao.OrderDAO;
import br.com.meatrestapi.dao.OrderItemDAO;
import br.com.meatrestapi.dao.RestaurantDAO;
import br.com.meatrestapi.dao.ReviewDAO;
import br.com.meatrestapi.model.MenuItem;
import br.com.meatrestapi.model.Order;
import br.com.meatrestapi.model.OrderItem;
import br.com.meatrestapi.model.Restaurant;
import br.com.meatrestapi.model.Review;
import br.com.meatrestapi.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	@Autowired
	private RestaurantDAO restaurantDAO;
	@Autowired
	private MenuItemDAO menuItemDAO;
	@Autowired
	private ReviewDAO reviewDAO;
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private OrderItemDAO orderItemDAO;

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
	@Transactional(readOnly = false)
	public Integer saveOrder(Order order) {
		Integer id = orderDAO.update(order).getId();
		order.setId(id);

		if (order.getOrderItems() != null) {
			for (OrderItem item : order.getOrderItems()) {
				if (item.getIdMenuItem() == null) {
					throw new IllegalStateException("Um dos itens nao contem o id do item do menu");
				}
				item.setMenuItem(new MenuItem(item.getIdMenuItem()));
				item.setOrder(order);
				orderItemDAO.update(item);
			}
		}
		return id;
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
