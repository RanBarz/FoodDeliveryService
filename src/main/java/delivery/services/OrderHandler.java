package delivery.services;

import java.io.IOException;
import java.util.List;

import delivery.exceptions.*;

public interface OrderHandler {
	public int createOrder(String restaurant, String[] dishes, String address) throws IOException;
	
	public void deleteOrder(int orderId) throws Exception;
	
	public void updateOrder(int orderId, String address) throws IOException, OrderNotFoundException;
	
	public String readOrder(int id) throws OrderNotFoundException ;
	
	public List<String> getAllOrders() throws OrderNotFoundException, NoOrdersExsistException;
}
