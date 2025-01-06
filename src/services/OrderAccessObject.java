package services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import entities.Order;

public class OrderAccessObject implements DataAccessObject, Serializable{
	private static final long serialVersionUID = 1L;
	private List<Order> orders = new ArrayList<>();
	
	public void save() throws IOException {
		FileOutputStream fileOut = new FileOutputStream("Data.ser.gz");
		GZIPOutputStream gzipOut = new GZIPOutputStream(fileOut);
		ObjectOutputStream out = new ObjectOutputStream(gzipOut); 
        out.writeObject(this);
		out.close();
	}
	
	@Override
	public int createOrder(String restaurant, String[] dishes, String address) throws IOException {
			Order o = new Order(restaurant, dishes, address);
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
		return toDel == null;
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
	public String readOrder(int id) {
		String str = null;
		for (Order o: orders)
			if (o.getId() == id)
				str = o.toString();
		return str;
	}

	@Override
	public List<Integer> getAllIds() {
		List<Integer> ids = new ArrayList<>();
		for (Order o: orders)
			ids.add(o.getId());
		return null;
	}
	
}
