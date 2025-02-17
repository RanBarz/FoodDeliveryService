package delivery.services;

import java.io.IOException;
import java.util.List;

import delivery.entities.Order;

public interface DataAccessObject {
	public int createOrder(Order order) throws IOException;
	
	public boolean deleteOrder(int id) throws IOException;
	
	public boolean updateOrder(int id, String address) throws IOException;
	
	public Order readOrder(int id);

	public List<Order> getAllOrders();
		
}
