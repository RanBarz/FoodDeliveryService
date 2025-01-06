package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("UI")
public class UI {
	
	@Autowired
	OrderHandler service;
	
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
            System.out.println("Press 7: Exit");

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
	
	                case 7:
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

    public static void viewMenu() {
        System.out.println("\n-- Hot Drinks --");
        System.out.println("1. Espresso - 10 ILS");
        System.out.println("2. Artistic Latte - 15 ILS");
        System.out.println("3. Green Tea with Mint - 12 ILS");
        System.out.println("4. Hot Chocolate with Whipped Cream - 14 ILS");

        System.out.println("\n-- Cold Drinks --");
        System.out.println("5. Cold Lemonade with Mint - 12 ILS");
        System.out.println("6. Vanilla Ice Coffee - 15 ILS");
        System.out.println("7. Fresh Fruit Shake (Strawberry, Banana, Mango) - 18 ILS");

        System.out.println("\n-- Main Dishes --");
        System.out.println("8. Vegetable Quiche with Side Salad - 35 ILS");
        System.out.println("9. Penne Pasta in Cream and Mushroom Sauce - 45 ILS");
        System.out.println("10. Caesar Salad with Chicken - 40 ILS");
        System.out.println("11. Goat Cheese Toast with Sun-Dried Tomatoes - 38 ILS");
        System.out.println("12. Vegan Burger with Sweet Potato Fries - 48 ILS");
        System.out.println("13. Spicy Shakshuka with Fresh Bread - 42 ILS");
        System.out.println("14. Grilled Fish Fillet with Stir-Fried Vegetables - 55 ILS");

        System.out.println("\n-- Desserts --");
        System.out.println("15. Warm Butter Croissant - 12 ILS");
        System.out.println("16. Belgian Chocolate Cake - 18 ILS");
        System.out.println("17. Profiterole with Vanilla Cream - 22 ILS");
    }
}
