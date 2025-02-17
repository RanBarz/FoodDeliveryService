package delivery.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order implements Serializable, Comparable<Order>{
	private static final long serialVersionUID = 1L;
	private int id;
	private List<String> dishes;
	private String restaurant;
	private String address;
	
	public Order(String restaurant, String[] dishes, String address, int id) {
		this.restaurant = restaurant;
		this.dishes = new ArrayList<>();
		Collections.addAll(this.dishes, dishes);
		this.address = address;
		this.id = id;
	}
	
	public Order() {}

	public void addDish(String dish) {
		dishes.add(dish);
	}

	public List<String> getDishes() {
		return dishes;
	}

	public void setDishes(List<String> dishes) {
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
		for (String dish: dishes)
			str += dish + ", ";
		str += "from " + restaurant + " to address: " + address + ".";
		return str;
	}

	@Override
	public int compareTo(Order o) {
		if (o == null)
			throw new IllegalArgumentException();
		return o.dishes.size() - dishes.size();
	}
	
	
}
