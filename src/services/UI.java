package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("UI")
@PropertySource("classpath:params.properties")
public class UI {
	
	@Autowired
	OrderHandler service;
	
	@Value("${hotDrinksMenu}")
	private String HOT_DRINKS_MENU;
	@Value("${coldDrinksMenu}")
	private String COLD_DRINKS_MENU;
	@Value("${mainDishesMenu}")
	private String MAIN_DISHES_MENU;
	@Value("${dessertsMenu}")
	private String DESSERTS_MENU;
	
    public void chicCafe() {
        Scanner scanner = new Scanner(System.in);      
        String address;
        List<String> dishes = new ArrayList<>();
        int id;
        boolean using = true;

        System.out.println("Welcome to Cafe Chic!");
        System.out.println("Thank you for choosing our order service. What would you like to do?");

        while (using) {
            System.out.println("Press 1: View the menu");
            System.out.println("Press 2: Place an order");
            System.out.println("Press 3: Edit an order");
            System.out.println("Press 4: Cancel an order");
            System.out.println("Press 5: View order details");
            System.out.println("Press 6: Prioritize orders");
            System.out.println("Press 0: Exit");

            System.out.println("Please select a service:");
            int choice = scanner.nextInt();

            scanner.nextLine(); 
            
            try {
	            switch (choice) {
	                case 1:
	                    viewMenu();
	                    System.out.println("Would you like to order, enter yes/no");
	                    String input = scanner.nextLine();
	                    if (input.equals("no"))
	                        break;	
	                case 2:
	                    System.out.println("Please enter an order");
	                    System.out.println("If you finish enter end");
	                    String dish = scanner.nextLine();
	                    
	                    while(!dish.equals("end")) {
	                    	dishes.add(dish);
	                    	dish = scanner.nextLine();
	                    }
	                    System.out.println("Please enter an address");
	                    address = scanner.nextLine();
	                    
	                    String[] dishesArr = dishes.toArray(new String[0]);
	
	                    int orderId = service.createOrder( "Cafe Chic", dishesArr, address);
	                    System.out.println("Your order has been placed! Order ID: " + orderId);
	                    break;
	
	                case 3:
	                    System.out.println("Enter an order number");
	                    id = scanner.nextInt();
	                    scanner.nextLine(); 
	                    System.out.println("Please enter the new address");
	                    address = scanner.nextLine();
	                    service.updateOrder(id, address);
	                    System.out.println("The address has been changed successfully");
	                    break;
	
	                case 4:
	                    System.out.println("Please enter an order number");
	                    id = scanner.nextInt();
	                    service.deleteOrder(id);
	                    break;
	
	                case 5:
	                    System.out.println("Please enter an order number");
	                    id = scanner.nextInt();
	                    String message = service.readOrder(id);
	                    System.out.println(message);
	                    break;
	
	                case 6:
	                    List<String> orders = service.getAllOrders();
	                    for (String order: orders)
	                    	System.out.println(order);
	                    break;
	
	                case 0:
	                    System.out.println("Thank you for using Cafe Chic. Goodbye!");
	                    using = false;
	                    break;
	            }
            }
            catch(Exception e){
            	 System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close(); 
    }

    public void viewMenu() {
        System.out.printf(HOT_DRINKS_MENU);

        System.out.printf(COLD_DRINKS_MENU);

        System.out.printf(MAIN_DISHES_MENU);

        System.out.printf(DESSERTS_MENU);
    }
}
