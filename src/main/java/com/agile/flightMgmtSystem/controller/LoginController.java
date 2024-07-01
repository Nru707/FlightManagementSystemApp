package com.agile.flightMgmtSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.agile.flightMgmtSystem.bean.FlightUser;
import com.agile.flightMgmtSystem.service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String showIndexPage() {
        return "index";
    }

    @GetMapping("/login")
    public String showLoginPage(Model model, @RequestParam(value = "error", required = false) String error) {
        if (error != null) {
            model.addAttribute("errorMessage", "Invalid email or password.");
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("email") String email, 
                            @RequestParam("password") String password, 
                            Model model) {
        if (userService.validateUser(email, password)) {
            return "redirect:/index"; // Redirect to home page after successful login
        } else {
            model.addAttribute("errorMessage", "Invalid email or password.");
            return "login";
        }
    }

    @GetMapping("/newUser")
    public String showNewUserForm(Model model) {
        model.addAttribute("user", new FlightUser());
        return "newUser";
    }

    @PostMapping("/newUser")
    public String registerNewUser(@ModelAttribute("user") FlightUser user, Model model) {
        if (userService.emailExists(user.getEmail())) {
            model.addAttribute("errorMessage", "Email already exists.");
            return "newUser";
        }
        userService.saveUser(user);
        return "redirect:/login"; // Redirect to login page after successful registration
    }
}
