package com.readingmonitor.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.readingmonitor.dto.User;
import com.readingmonitor.form.helper.LoginFormResponse;
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

	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces =MediaType.APPLICATION_JSON_VALUE)
	public LoginFormResponse processLogin(@ModelAttribute("user") @Valid User user,
			BindingResult bindingResult, Model model) {

		LoginFormResponse response = new LoginFormResponse();

		if (bindingResult.hasFieldErrors("email")
				|| bindingResult.hasFieldErrors("password")) {
			Map<String, String> errors = bindingResult
					.getFieldErrors()
					.stream()
					.collect(
							Collectors.toMap(FieldError::getField,
									FieldError::getDefaultMessage));
			response.setValidated(false);
			response.setErrorMessages(errors);
		}
		else if (!userService.validateUser(user)) 
		{
			Map<String, String> errors = new HashMap<>();
			errors.put("failedLoginMessage", "Invalid Credentials");
			response.setValidated(false);
			response.setErrorMessages(errors);
		}
		else
		{
			user = userService.getUserInfo(user);
			model.addAttribute("user", user);
			response.setUserName(user.getUsername());
			response.setValidated(true);
		}
		return response;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		if (!session.isNew()) {
			session.invalidate();
		}
		return "redirect:login";
	}
}
