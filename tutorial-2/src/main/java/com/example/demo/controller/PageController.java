package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}

	@RequestMapping("/viral/challenge")
	public String challenge(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name",name);
		return "challenge";
	}

	@RequestMapping("/challenge/{name}")
	public String challengePath(@PathVariable String name, Model model) {
		model.addAttribute("name", name);
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String generator(@RequestParam(value = "a", defaultValue = "0") String a, @RequestParam(value = "b", defaultValue = "0") String b, Model model) {
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		int vala = Integer.parseInt(a);
		int valb = Integer.parseInt(b);
		
		if (vala == 0) {
			vala = 1;
		}
		
		if (valb == 0) {
			valb = 1;
		}
		
		String hm = "h";
		for (int i = 0; i<valb; i++) {
			hm += "m";
		}
		
		String text = "";
		for (int i = 0; i<vala; i++) {
			text += (hm + " ");
		}
		
		model.addAttribute("text", text);
		return "generator";
	}
}
