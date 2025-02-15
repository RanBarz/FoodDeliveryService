/*package delivery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    // Show login page
    @GetMapping({"/", "/login"})
    public ModelAndView showLoginPage() {
        return new ModelAndView("login");
    }

    // Handle login logic without session
    @PostMapping("/login")
    public ModelAndView handleLogin(@RequestParam("username") String username, 
                                    @RequestParam("password") String password) {
        // Dummy authentication (Replace with real authentication)
        if ("admin".equals(username) && "password".equals(password)) {
            return new ModelAndView("redirect:/dashboard"); // Redirect to success page
        } else {
            ModelAndView mav = new ModelAndView("login");
            mav.addObject("error", "Invalid username or password!");
            return mav; // Reload login page with error
        }
    }
}
*/