package delivery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    // Show the registration page
    @GetMapping("/register")
    public ModelAndView showRegisterPage() {
        return new ModelAndView("register");
    }

    // Handle registration form submission
    @PostMapping("/register")
    public ModelAndView handleRegistration(
            @RequestParam("username") String username,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("confirmPassword") String confirmPassword) {

        ModelAndView mav = new ModelAndView("register");

        // Simple validation
        if (!password.equals(confirmPassword)) {
            mav.addObject("error", "Passwords do not match!");
            return mav;
        }

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            mav.addObject("error", "All fields are required!");
            return mav;
        }

        // TODO: Save user to database (Add a UserService for actual registration logic)
        
        // Redirect to login page upon successful registration
        return new ModelAndView("redirect:/login");
    }
}
