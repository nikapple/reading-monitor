package com.readingmonitor.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.readingmonitor.dto.User;
import com.readingmonitor.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("user") @Valid User user,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "register";
		} else if (userService.checkUserExists(user)) {
			return "register";
		}
		userService.insertUser(user);
		return "registerSuccess";
	}
	
	@RequestMapping(value = "/userHome/{username}", method = RequestMethod.GET)
	public String userHome(@PathVariable String username, Model model,
			HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		if (user != null && username.equals(user.getUsername())) {
			return "userHome";
		}
		return "error";
	}
}
