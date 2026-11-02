package com.springcore.springmvcorm.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springcore.springmvcorm.user.entity.User;
import com.springcore.springmvcorm.user.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("registrationPage")
	public String showRegistrationPage() {
		return "userReg";
	}
	
	@RequestMapping(value = "registerUser", method=RequestMethod.POST)
	public String showRegistrationPage(@ModelAttribute("user") User user, ModelMap model) {
		int result = userService.save(user);
		model.addAttribute("result" , "User Created With Id : "+ result);
		return "userReg";
	}
	
	@RequestMapping("validateEmail")
	public @ResponseBody String validateEmail(@RequestParam("id") int id) {
		User user = userService.getUser(id);
		String msg = "";
		
		if(user != null) {
			msg = id + " already exists";
		}
		
		return msg;
	}
	
	@RequestMapping("getUsers")
	public String getUser(ModelMap model) {
		List<User> users = userService.getAll();
		model.addAttribute("users" , users);
		return "displayUsers";
	}
}
