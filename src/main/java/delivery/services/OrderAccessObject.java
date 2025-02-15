package delivery.services;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import delivery.entities.Order;

@Component
@PropertySource("classpath:params.properties")
public class OrderAccessObject implements DataAccessObject, Serializable{
	private static final long serialVersionUID = 1L;
	
	@Value("${path}")
	private String PATH;
	private List<Order> orders = new ArrayList<>();
	private int counter;
	
	@PostConstruct
	public void load() {
		try { 
			FileInputStream fileIn = new FileInputStream(PATH);
    		GZIPInputStream gzipIn = new GZIPInputStream(fileIn);
    		ObjectInputStream in = new ObjectInputStream(gzipIn); 
	        OrderAccessObject loadedObject = (OrderAccessObject) in.readObject();
	        in.close();
	        orders = loadedObject.orders;
	        counter = loadedObject.counter;
		} catch (IOException | ClassNotFoundException e) {
	         System.out.println("No previous file of orders exists");
	    }
	}
	
	public void save() throws IOException {
		FileOutputStream fileOut = new FileOutputStream(PATH);
		GZIPOutputStream gzipOut = new GZIPOutputStream(fileOut);
		ObjectOutputStream out = new ObjectOutputStream(gzipOut); 
        out.writeObject(this);
		out.close();
	}
	
	@Override
	public int createOrder(String restaurant, String[] dishes, String address) throws IOException {
			Order o = new Order(restaurant, dishes, address, counter++);
			orders.add(o);
			this.save();
			return o.getId();
	}

	@Override
	public boolean deleteOrder(int id) throws IOException {
		Order toDel = null;
		for (Order o: orders)
			if (o.getId() == id)
				toDel = o;
		orders.remove(toDel);
		this.save();
		return toDel != null;
	}

	@Override
	public boolean updateOrder(int id, String address) throws IOException {
		Order toUp = null;
		for (Order o: orders)
			if (o.getId() == id)
				o.setAddress(address);
		this.save();
		return toUp == null;
	}

	@Override
	public Order readOrder(int id) {
		for (Order o: orders)
			if (o.getId() == id)
				return o;
		return null;
	}

	@Override
	public List<Order> getAllOrders() {
		List<Order> ordersDetail = new ArrayList<>();
		for (Order o: orders)
			ordersDetail.add(o);
		return ordersDetail;
	}
	
}
