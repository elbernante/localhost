package edu.mum.cs545.localhost.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.cs545.localhost.domain.Itinerary;
import edu.mum.cs545.localhost.service.ItineraryService;
import edu.mum.cs545.localhost.service.UserProfileService;

@Controller
@RequestMapping("/itinerary")
public class ItineraryController {
	
	@Autowired
	private UserProfileService userProfileService;
	
	@Autowired
	private ItineraryService itineraryService;

	@RequestMapping(value="", method=RequestMethod.GET)
	public String itineraryPage() {
		return "itinerary";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	@ResponseBody
	public Itinerary newItinerary() {
		Itinerary it = new Itinerary();
		it.setUser(userProfileService.getCurrentUserProfile());
		System.out.println("USER PROFILE: " + it.getUser());
		return it;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseBody
	public Itinerary saveItinerary(@Valid @RequestBody Itinerary itinerary) {
		System.out.println("USER ID: " + itinerary.getUser().getId());
		itineraryService.saveItineray(itinerary);
		return itinerary;
	}
}
