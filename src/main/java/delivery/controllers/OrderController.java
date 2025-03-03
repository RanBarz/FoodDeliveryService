package delivery.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import delivery.services.OrderHandler;
import delivery.entities.Order;
import delivery.exceptions.*;

@RestController  // Changed from RestController to Controller for JSP views
@RequestMapping("/orders")  // Base mapping for all order operations
public class OrderController {

    @Autowired
    private OrderHandler orderHandler;

    // Main page - show all orders
    @GetMapping
    public String listOrders(Model model) {
        try {
            model.addAttribute("orders", orderHandler.getAllOrders());
        } catch (NoOrdersExsistException e) {
        	return "redirect:/errors/no-orders-exist?message=" + e.getMessage();
        } catch (OrderNotFoundException e) {
            model.addAttribute("error", "Error loading orders: " + e.getMessage());
        }
        return "orderList";
    }

    // Show create order form
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("order", new Order()); // Binds empty Order object
    	return "createOrder";
    }

    @PostMapping("/create")
    public String createOrder(@ModelAttribute Order order, RedirectAttributes redirectAttributes) {
        try {
            System.out.println("Order Created: " + order);
            orderHandler.createOrder(order);
            redirectAttributes.addFlashAttribute("message", "Order created successfully");
            return "redirect:/orders";
        } catch (IOException e) {
            return "redirect:/errors/io-error?message=" + e.getMessage();
        }
    }

    @GetMapping("/{id}")
    public String viewOrder(@PathVariable int id, Model model) {
        try {
            Order order = orderHandler.readOrder(id);
            model.addAttribute("order", order);
            return "viewOrder";
        } catch (OrderNotFoundException e) {
            return "redirect:/errors/order-not-found?id=" + id;
        }
    }
    
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable int id, Model model) {
        try {
            Order order = orderHandler.readOrder(id);
            model.addAttribute("order", order);
            model.addAttribute("orderId", id);
            return "editOrder";
        } catch (OrderNotFoundException e) {
            return "redirect:/errors/order-not-found?id=" + id;
        }
    }
    
    @PostMapping("/{id}/edit")
    public String updateOrder(@PathVariable int id,
                            @RequestParam String address,
                            RedirectAttributes redirectAttributes) {
        try {
            orderHandler.updateOrder(id, address);
            redirectAttributes.addFlashAttribute("message", "Order updated successfully");
            return "redirect:/orders";
        } catch (IOException e) {
            return "redirect:/errors/io-error?message=" + e.getMessage();
        } catch (OrderNotFoundException e) {
            return "redirect:/errors/order-not-found?id=" + id;
        }
    }
    
    @PostMapping("/{id}/delete")
    public String deleteOrder(@PathVariable int id, RedirectAttributes redirectAttributes) {
        try {
            orderHandler.deleteOrder(id);
            redirectAttributes.addFlashAttribute("message", "Order deleted successfully");
            return "redirect:/orders";
        } catch (IOException e) {
            return "redirect:/errors/io-error?message=" + e.getMessage();
        } catch (OrderNotFoundException e) {
            return "redirect:/errors/order-not-found?id=" + id;
        } catch (Exception e) {
            return "redirect:/errors/general-error?message=" + e.getMessage();
        }
    }
}