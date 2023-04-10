package com.zachcarrera.omikujiform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/omikuji")
public class OmikujiController {

	// method to render the form
	@GetMapping("")
	public String index() {
		return "index.jsp";
	}
	
	// method to process form submission
	@PostMapping("/process")
	public String processForm(
			@RequestParam(value="year") Integer year,
			@RequestParam(value="city") String city,
			@RequestParam(value="person") String person,
			@RequestParam(value="hobby") String hobby,
			@RequestParam(value="livingThing") String livingThing,
			@RequestParam(value="message") String message,
			HttpSession session
			) {

		session.setAttribute("year", year);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("livingThing", livingThing);
		session.setAttribute("message", message);
		return "redirect:/omikuji/show";
	}

	// method to show complete omikuji
	@GetMapping("/show")
	public String show() {
		return "show.jsp";
	}

}
