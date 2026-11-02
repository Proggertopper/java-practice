package com.springcore.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RequestParamsController {

    @RequestMapping("/showData")
	public ModelAndView showData(@RequestParam("id") int id , @RequestParam("name") String name,@RequestParam(value = "sal" , required = false ,  defaultValue = "60") double salary) {
		ModelAndView modelAndView = new ModelAndView("userReg");
		System.out.println("id: " + id);
		System.out.println("Name: " + name);
		System.out.println("Salary: " + salary);
		return modelAndView;
	}
}
