package com.wadi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class FormPageController {
	
	@GetMapping("login")
	public String formPage() {
			
			return "login";
	}
	
	@GetMapping("courses")
	public String coursesPage() {
			
			return "courses";
	}
	
	

}
