package com.bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookStore.entity.Users;
import com.bookStore.service.UserService;


@Controller
public class RegisterController {
	@Autowired
	UserService userService;
	
	@GetMapping("/register")
	public String getRegisterPage() {
		return "register";
	}

	@PostMapping("/register")
	public String getUserDetails(Users  user) {
		//register user call user service
		userService.registerUser(user);
		return "redirect:login";
	}
}
