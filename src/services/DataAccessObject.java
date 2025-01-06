package services;

import java.io.IOException;
import org.springframework.stereotype.Component;

@Component
public interface DataAccessObject {
	public int createOrder(String restaurant, String[] dishes, String address) throws IOException;
	
	public boolean deleteOrder(int id) throws IOException;
	
	public boolean updateOrder(int id, String address) throws IOException;
	
	public String readOrder(int id);
		
}
