package com.springcore.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springcore.springmvc.dto.Employee;

@Controller
public class ObjectController {
	
	@RequestMapping("/readObject")
	public ModelAndView sendObject() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("displayObject");
		
		Employee emp = new Employee();
		emp.setId(123);
		emp.setName("Sasha");
		emp.setSalary(10000);
		modelAndView.addObject("employee", emp);
		return modelAndView;
	}

}
