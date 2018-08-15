package br.com.meatrestapi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.meatrestapi.model.Restaurant;
import br.com.meatrestapi.model.Review;

@Repository
public class ReviewDAO extends AbstractDAO<Review, String> {
	public void load(List<Review> lReview) {
		for (Review m : lReview) {
			m.setRestaurant(new Restaurant(m.getRestaurantId()));
			update(m);
		}
	}

	public List<Review> findReviewByIdRestaurant(String idRestaurant) {
		return createQuery("select r from Review r where r.restaurant.id=?1", idRestaurant);
	}

}
