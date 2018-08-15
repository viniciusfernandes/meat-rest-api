package br.com.meatrestapi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Transient
	private String idMenuItem;

	private Double quantity;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_menu")
	private MenuItem menuItem;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_order")
	private Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getIdMenuItem() {
		return idMenuItem;
	}

	public void setIdMenuItem(String idMenuItem) {
		this.idMenuItem = idMenuItem;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
}
