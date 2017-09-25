package edu.mum.cs545.localhost.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public String view(@PathVariable("username") String username) {
		return "profile";
	}
}
