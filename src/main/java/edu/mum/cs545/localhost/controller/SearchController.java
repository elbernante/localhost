package edu.mum.cs545.localhost.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.cs545.localhost.domain.UserProfile;
import edu.mum.cs545.localhost.service.UserProfileService;

@Controller
@RequestMapping("/search")
public class SearchController {
	
	@Autowired
	UserProfileService userProfileService;

	@RequestMapping(value="/getForm", method=RequestMethod.GET)
	public String getSearch() {
		return "search";
	}
	
	@RequestMapping(value="/getList", method=RequestMethod.GET)
	public @ResponseBody List<UserProfile> listUserProfile(@RequestParam("city") String city,
			@RequestParam("state") String state, @RequestParam("country") String country) {
		return userProfileService.listUserProfile(city, state, country);
	}
}