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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.readingmonitor.dto.User;
import com.readingmonitor.form.helper.RegistrationFormResponse;
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

	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RegistrationFormResponse processRegistration(
			@ModelAttribute("user") @Valid User user,
			BindingResult bindingResult) {

		RegistrationFormResponse response = new RegistrationFormResponse();

		if (bindingResult.hasErrors()) {
			Map<String, String> errors = bindingResult
					.getFieldErrors()
					.stream()
					.collect(
							Collectors.toMap(FieldError::getField,
									FieldError::getDefaultMessage));
			response.setValidated(false);
			response.setErrorMessages(errors);
		} else if (userService.checkUserExists(user)) {
			Map<String, String> errors = new HashMap<>();
			errors.put("userExists", "User already exists");
			response.setValidated(false);
			response.setErrorMessages(errors);
		} else {
			int userId = userService.insertUser(user);
			response.setValidated(true);
			response.setUserId(userId);
		}
		return response;
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
