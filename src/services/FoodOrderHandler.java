package services;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component()
public class FoodOrderHandler implements OrderHandler {
	@Autowired
	DataAccessObject dao;
	
	@PostConstruct
	public void printExistingOrders(){
		try {
			List<String> orders = getAllOrders();
			if(orders.size() > 0)
				System.out.println("Here is a list of existing orders");
			for (String order : orders) {
				System.out.println(order);
			}
		} catch (Exception e) {
			System.out.println("No existing orders");
		}
		
	}
	
	@PreDestroy
	public void printRemainingOrders() {
		try {
			List<String> orders = getAllOrders();
			if(orders.size() > 0)
				System.out.println("Here is a list of remaining orders");
			for (String order : orders) {
				System.out.println(order);
			}
		} catch (Exception e) {
			System.out.println("No remaining orders");
		}			
	}
	
	public int createOrder(String restaurant, String[] dishes, String address) throws IOException{
		int orderId = dao.createOrder(restaurant, dishes, address);
		return orderId;
	}
	public void deleteOrder(int orderId) throws IOException, OrderNotFoundException{
		
		if(!dao.deleteOrder(orderId))
			throw new OrderNotFoundException(String.format("Order %d was not found :(", orderId));
		
	}
	public void updateOrder(int orderId, String address) throws IOException, OrderNotFoundException {
		if(!dao.updateOrder(orderId, address))
			throw new OrderNotFoundException(String.format("Order %d was not found :(", orderId));
	}
	public String readOrder(int orderId) throws OrderNotFoundException {
		String order = dao.readOrder(orderId);
		if(order == null)
			throw new OrderNotFoundException(String.format("Order %d was not found :(", orderId));
		return order;
	}
	
	public List<String> getAllOrders() throws OrderNotFoundException, NoOrdersExsistException{
		List<String> orders = dao.getAllOrders();
		if (orders.size() == 0)
			throw new NoOrdersExsistException("No Orders Found :(");
		return orders;
	}
	
	
}
