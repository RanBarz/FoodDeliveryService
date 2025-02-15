package delivery.services;

import java.io.IOException;
import java.util.List;

import delivery.entities.Order;
import delivery.exceptions.*;

public interface OrderHandler {
	public int createOrder(String restaurant, String[] dishes, String address) throws IOException;
	
	public void deleteOrder(int orderId) throws Exception;
	
	public void updateOrder(int orderId, String address) throws IOException, OrderNotFoundException;
	
	public Order readOrder(int id) throws OrderNotFoundException ;
	
	public List<Order> getAllOrders() throws OrderNotFoundException, NoOrdersExsistException;
}
