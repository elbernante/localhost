package edu.mum.cs545.localhost.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs545.localhost.service.SampleService;

@Controller
public class HomeController {

	@Autowired
	private SampleService sampleService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(final Principal principal, Model model) {
		model.addAttribute("sampleModel", sampleService.getSample());
		
		if (principal != null) {
			return "redirect:/dashboard";
		}
		
		return "index";
	}
	
	@RequestMapping(value="/dashboard", method=RequestMethod.GET)
	public String dashboard() {
		return "dashboard";
	}
}
