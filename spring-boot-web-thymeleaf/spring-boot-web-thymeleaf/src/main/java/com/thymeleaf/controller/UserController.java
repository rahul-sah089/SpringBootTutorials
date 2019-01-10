package com.thymeleaf.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.thymeleaf.domain.User;
import com.thymeleaf.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/singup")
	public String signUpForm(User user) {
		return "add-user";
	}

	@PostMapping("/adduser")
	public String addUser(@Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-user";
		}

		userRepository.save(user);
		model.addAttribute("users", userRepository.findAll());
		return "index";
	}

	@GetMapping("/edit/{id}")
	public String editUsers(Model model, @PathVariable("id") long id) {
		User user = null;
		try {
			user = userRepository.findOne(id);
		} catch (Exception ex) {
			throw new IllegalArgumentException("Invalid user id " + id);
		}
		model.addAttribute("user", user);
		return "update-user";
	}
	
	@PostMapping("/delete/{id}")
	public String deleteUser(Model  model,@PathVariable("id") long id,@Valid User user,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			
		}
		return null;
	}
}
