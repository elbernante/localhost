package edu.mum.cs545.localhost.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(@RequestParam(name="error", required=false) String error,
			Principal principal, Model model) {
		
		if (principal != null) {
			return "redirect:/";
		}
		
		if (error != null) {
			model.addAttribute("error", "true");
		}
		return "login";
	}
//	
//	@RequestMapping(value="/logout", method=RequestMethod.GET)
//	public String logout() {
//		return "redirect:/";
//	}
}
