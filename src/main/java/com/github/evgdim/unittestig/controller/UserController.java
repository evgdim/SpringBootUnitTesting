package com.github.evgdim.unittestig.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.evgdim.unittestig.domain.User;
import com.github.evgdim.unittestig.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	private final UserService userService;
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	@GetMapping
	public List<User> allUsers() {
		return this.userService.findAllUsers();
	}
}
