package com.posgate.stackportal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIController {

    @GetMapping("/")
	public String home(Model model) {
        model.addAttribute("page", "home"); 
		return "main";
	}

    @GetMapping("/greeting")
	public String greeting(Model model) {
        model.addAttribute("page", "greeting"); 
		return "main";
	}

}
