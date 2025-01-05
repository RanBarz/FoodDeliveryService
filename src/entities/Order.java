package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable, Comparable<Order>{
	private static final long serialVersionUID = 1L;
	private static int counter = 0;
	private int id;
	private List<String> dishes;
	private String restaurant;
	private String address;
	
	public Order(String restaurant, String[] dishes, String address) {
		this.restaurant = restaurant;
		this.dishes = new ArrayList<>();
		this.address = address;
		this.id = counter++;
	}
	
	public void addDish(String dish) {
		dishes.add(dish);
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
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
		return dishes.size() - o.dishes.size();
	}
	
	
}
