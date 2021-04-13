package com.example.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("metaTitle", "Index Page");
		return "index";
	}
}
