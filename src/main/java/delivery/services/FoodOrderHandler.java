package delivery.services;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import delivery.entities.Order;
import delivery.exceptions.*;

@Component()
public class FoodOrderHandler implements OrderHandler {
	@Autowired
	private DataAccessObject dao;
	
	@PostConstruct
	public void printExistingOrders(){
		try {
			List<Order> orders = getAllOrders();
			if(orders.size() > 0)
				System.out.println("Here is a list of existing orders");
			for (Order order : orders) {
				System.out.println(order);
			}
		} catch (Exception e) {
			System.out.println("No existing orders");
		}
		
	}
	
	@PreDestroy
	public void printRemainingOrders() {
		try {
			List<Order> orders = getAllOrders();
			if(orders.size() > 0)
				System.out.println("Here is a list of remaining orders");
			for (Order order : orders) {
				System.out.println(order);
			}
		} catch (Exception e) {
			System.out.println("No remaining orders");
		}			
	}
	
	public int createOrder(Order order) throws IOException{
		int orderId = dao.createOrder(order);
		return orderId;
	}
	public void deleteOrder(int orderId) throws Exception{
		
		if(!dao.deleteOrder(orderId))
			throw new OrderNotFoundException(String.format("Order %d was not found :(", orderId));
		
	}
	public void updateOrder(int orderId, String address) throws IOException, OrderNotFoundException {
		if(!dao.updateOrder(orderId, address))
			throw new OrderNotFoundException(String.format("Order %d was not found :(", orderId));
	}
	
	public Order readOrder(int orderId) throws OrderNotFoundException {
		Order order = dao.readOrder(orderId);
		if(order == null)
			throw new OrderNotFoundException(String.format("Order %d was not found :(", orderId));
		return order;
	}
	
	public List<Order> getAllOrders() throws OrderNotFoundException, NoOrdersExsistException{
		List<Order> orders = dao.getAllOrders();
		if (orders.size() == 0)
			throw new NoOrdersExsistException("No Orders Found :(");
		return orders;
	}
	
	
}
