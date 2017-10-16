package com.readingmonitor.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.readingmonitor.dto.User;
import com.readingmonitor.service.UserService;


@Controller
@SessionAttributes("user")
public class LoginController {

	@Autowired
	UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processLogin(@ModelAttribute("user") @Valid User user,
			BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasFieldErrors("email")
				|| bindingResult.hasFieldErrors("password")) {
			return "login";
		} else if (!userService.validateUser(user)) {
			model.addAttribute("failedLoginMessage","Invalid Credentials");
			return "login";
		}
		user = userService.getUserInfo(user);
		model.addAttribute("user", user);
		return "redirect:userHome/" + user.getUsername();
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		if (!session.isNew()) {
			session.invalidate();
		}
		return "redirect:login";
	}
}
