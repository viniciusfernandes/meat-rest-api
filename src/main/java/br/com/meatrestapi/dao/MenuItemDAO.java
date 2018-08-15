package br.com.meatrestapi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.meatrestapi.model.MenuItem;
import br.com.meatrestapi.model.Restaurant;

@Repository
public class MenuItemDAO extends AbstractDAO<MenuItem, String> {
	public void load(List<MenuItem> lItem) {
		for (MenuItem m : lItem) {
			m.setRestaurant(new Restaurant(m.getRestaurantId()));
			update(m);
		}
	}

	public List<MenuItem> findMenuItemByIdRestaurant(String idRestaurant) {
		return createQuery("select m from MenuItem m where m.restaurant.id= ?1", idRestaurant);
	}

}
