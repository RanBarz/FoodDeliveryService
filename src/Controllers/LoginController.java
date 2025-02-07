package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    /**
     * Redirects to the login page.
     * This method handles requests to the root path ("/") or explicitly to "/login".
     * 
     * @return ModelAndView pointing to the login view
     */
    @GetMapping({"/", "/login"})
    public ModelAndView showLoginPage() {
        return new ModelAndView("login");
    }

    /**
     * Alternative method using a direct return of the view name.
     * Some developers prefer this approach over ModelAndView.
     * 
     * @return String representing the view name
     */
    @GetMapping("/alternative-login")
    public String alternativeLoginPage() {
        return "login";
    }

    /**
     * Example of a login page with additional model attributes.
     * Useful for passing initial data or error messages to the login view.
     * 
     * @return ModelAndView with additional attributes
     */
    @GetMapping("/secure-login")
    public ModelAndView secureLoginPage() {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("message", "Please log in to continue");
        modelAndView.addObject("showRememberMe", true);
        return modelAndView;
    }
}