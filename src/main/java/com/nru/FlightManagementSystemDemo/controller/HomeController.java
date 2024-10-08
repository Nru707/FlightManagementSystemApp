package com.nru.FlightManagementSystemDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nru.FlightManagementSystemDemo.bean.FlightUser;
import com.nru.FlightManagementSystemDemo.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String Home() {
		return "Home";
	}

	/*@GetMapping("/Login")
	public String showIndexPage() {
		return "Login";
	}
*/
	@GetMapping("/newUser")
	public String showSignupPage(Model model) {
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
		return "redirect:/Login"; // Redirect to login page after successful registration
	}

	@GetMapping("/Login")
	public String showLoginPage(Model model, @RequestParam(value = "error", required = false) String error) {
		if (error != null) {
			model.addAttribute("errorMessage", "Invalid email or password.");
		}
		return "Login";
	}

	@PostMapping("/signin") 
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model) { 
		if(userService.validateUser(email, password)) { 
		return "index";
	 } else { model.addAttribute("errorMessage", "Invalid email or password."); 
	 return "Login"; 
	 } 
}

}
