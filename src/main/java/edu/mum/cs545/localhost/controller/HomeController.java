package edu.mum.cs545.localhost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs545.localhost.service.SampleService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private SampleService sampleService;

	@RequestMapping(value="", method=RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("sampleModel", sampleService.getSample());
		return "index";
	}
}
