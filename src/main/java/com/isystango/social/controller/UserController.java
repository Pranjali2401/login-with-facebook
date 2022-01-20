package com.isystango.social.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isystango.social.model.User;
import com.isystango.social.service.EmailSenderService;
import com.isystango.social.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailSenderService emailSender;
	
	@GetMapping("/")
	public String mainPage() {
		return "login";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/registration")
	public String showRegistration() {
		return "registration";
	}


	@PostMapping("/registration")
	public String setUser(@ModelAttribute User user) {
		System.out.println("in registration url" + user);
		
		emailSender.sendEmail(user.getEmail(),"Hello this is test mail","Testing");
		userService.setUser(user);
		return "login";

	}

	@PostMapping("/login")
	public String validUser(@ModelAttribute User user, Model model) {
		System.out.println("in login url " + user.getEmail()+" pass "+user.getPassword());
		User validUser = userService.validateUser(user.getEmail(), user.getPassword());
		System.out.println(validUser);
		model.addAttribute("name", validUser.getUsername());
		return validUser != null ? "home" : "login";

	}
	
	@GetMapping("/signin/facebook")
	public String validClient(Principal principal, Model model) {
		Map<String, Object> details =(Map<String, Object>)((OAuth2Authentication) principal).getUserAuthentication().getDetails();
		String uName = (String) details.get("name");
		System.out.println("facebook email *********"+details.get("email"));
		model.addAttribute("name", details.get("name"));
		User u = new User();
		u.setUsername(uName);
		userService.setUser(u);
		System.out.println(principal);		
		
		return "home";
	}
	
}
