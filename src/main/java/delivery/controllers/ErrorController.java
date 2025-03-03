package delivery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/errors")
public class ErrorController {

    @GetMapping("/order-not-found")
    public String orderNotFound(@RequestParam(required = false) Integer id, Model model) {
        model.addAttribute("errorTitle", "Order Not Found");
        model.addAttribute("errorMessage", "The requested order" + 
                          (id != null ? " with ID: " + id : "") + 
                          " could not be found in our system.");
        model.addAttribute("errorCode", "404");
        model.addAttribute("backLink", "/orders");
        model.addAttribute("backLinkText", "Return to Orders List");
        return "customError";
    }
    
    @GetMapping("/io-error")
    public String ioError(@RequestParam(required = false) String message, Model model) {
        model.addAttribute("errorTitle", "File System Error");
        model.addAttribute("errorMessage", "An error occurred while accessing the file system" + 
                          (message != null ? ": " + message : "."));
        model.addAttribute("errorCode", "500");
        model.addAttribute("backLink", "/orders");
        model.addAttribute("backLinkText", "Return to Orders List");
        return "customError";
    }
    
    @GetMapping("/no-orders-exist")
    public String noOrdersExist(Model model) {
        model.addAttribute("errorTitle", "No Orders Available");
        model.addAttribute("errorMessage", "There are currently no orders in the system.");
        model.addAttribute("errorCode", "204");
        model.addAttribute("backLink", "/orders/create");
        model.addAttribute("backLinkText", "Create New Order");
        return "customError";
    }
    
    @GetMapping("/general-error")
    public String generalError(@RequestParam(required = false) String message, Model model) {
        model.addAttribute("errorTitle", "System Error");
        model.addAttribute("errorMessage", "An unexpected error occurred" + 
                          (message != null ? ": " + message : "."));
        model.addAttribute("errorCode", "500");
        model.addAttribute("backLink", "/orders");
        model.addAttribute("backLinkText", "Return to Orders List");
        return "customError";
    }
}