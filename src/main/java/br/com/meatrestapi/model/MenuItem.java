package br.com.meatrestapi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tb_menu_item")
public class MenuItem implements Serializable {
	@Id
	private String id;
	private String name;
	private String description;
	private String imagePath;
	private double price;
	@Transient
	private double qtySold;
	@Transient
	private double totValue;

	public double getTotValue() {
		return totValue;
	}

	public void calcTotValue() {

		totValue = price * qtySold;
	}

	public void setTotValue(double totValue) {
		this.totValue = totValue;
	}

	public MenuItem() {
	}

	public MenuItem(String description, String id, String imagePath, String name, double price, double qtySold) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.imagePath = imagePath;
		this.price = price;
		this.qtySold = qtySold;
	}

	public MenuItem(String idMenu) {
		this.id = idMenu;
	}

	@Transient
	private String restaurantId;

	public double getQtySold() {
		return qtySold;
	}

	public void setQtySold(double qtySold) {
		this.qtySold = qtySold;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_restaurant")
	private Restaurant restaurant;

	public String getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
