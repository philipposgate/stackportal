package com.posgate.stackportal.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIController {

	private static final Logger logger = LoggerFactory.getLogger(UIController.class);

    @GetMapping("/")
	public String home(Model model) {
		logger.info("GET /");
        model.addAttribute("page", "home"); 
		return "main";
	}

    @GetMapping("/greeting")
	public String greeting(Model model) {
		logger.info("GET /greeting");
        model.addAttribute("page", "greeting"); 
		return "main";
	}

}
