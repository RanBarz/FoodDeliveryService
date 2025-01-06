package services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@Component("OrderService")
// CRUD service
public class FoodOrderHandler implements OrderHandler {
	@Autowired
	DataAccessObject dao;
	
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
	public List<String> GetAllOrders() throws OrderNotFoundException, NoOrdersExsistException{
		List<Integer> ids = dao.getAllIds();
		if (ids.size() == 0)
			throw new NoOrdersExsistException("No Orders Found :(");
		Collections.sort(ids);
		List<String> orders = new ArrayList<String>();
		for (int id : ids) {
			orders.add(readOrder(id));
		}
		return orders;
	}
	
	
}
