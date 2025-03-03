package delivery.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="orders")
public class Order implements Comparable<Order>{	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "Dishes")
	private String dishes;
	
	@Column(name = "Restaurant")
	private String restaurant;
	
	@Column(name = "Address")
	private String address;
	
	public Order(String restaurant, String dishes, String address) {
		this.restaurant = restaurant;
		this.dishes = dishes;
		this.address = address;
	}
	
	public Order() {}

	public String getDishes() {
		return dishes;
	}

	public void setDishes(String dishes) {
		this.dishes = dishes;
	}

	public String getAddress() {
		return address;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this)
			return true;
		if (other == null)
			return false;
		if (other.getClass() != getClass())
			return false;
		Order otherOrder = (Order) other;
		if (otherOrder.id != this.id)
			return false;		
		return true;
	}

	@Override
	public String toString() {
		String str = "You ordered: ";
		String[] dishes = this.dishes.split(" ");
		for (String dish: dishes)
			str += dish + ", ";
		str += "from " + restaurant + " to address: " + address + ".";
		return str;
	}

	@Override
	public int compareTo(Order o) {
		if (o == null)
			throw new IllegalArgumentException();
		String[] dishes = this.dishes.split(" ");
		return o.dishes.length() - dishes.length;
	}
	
	
}
