package edu.mum.cs545.localhost.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.mum.cs545.localhost.domain.Itinerary;
import edu.mum.cs545.localhost.domain.UserProfile;
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
	
	@RequestMapping(value="/view/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Itinerary getItinerary(@PathVariable("id") Long id) {
		return itineraryService.getItenerary(id);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ResponseBody
	public void deleteItinerary(@PathVariable("id") Long id) {
		Itinerary itinerary = itineraryService.getItenerary(id);
		if (itinerary == null) {
			throw new NotFoundException("localhost.domain.itinerary.notexists");
		}
		
		UserProfile currentUser = userProfileService.getCurrentUserProfile();
		if (currentUser != null && !(itinerary.getUser().getId().equals(currentUser.getId()))) {
			throw new AccessDeniedException("localhost.domain.itinerary.forbidden");
		}
		
		itineraryService.deleteItinerarry(itinerary);;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseBody
	public Itinerary saveItinerary(@Valid @RequestBody Itinerary itinerary) {
		itinerary.setUser(userProfileService.getCurrentUserProfile());
		itineraryService.saveItineray(itinerary);
		return itinerary;
	}
	
	@RequestMapping(value="/list/mytrips", method=RequestMethod.GET)
	@ResponseBody
	public List<Itinerary> myItinerary() {
		return itineraryService.findAllUserItineray(userProfileService.getCurrentUserProfile());
	}
	
	@RequestMapping(value="/list/upcoming", method=RequestMethod.GET)
	@ResponseBody
	public List<Itinerary> myUpcomingTrips() {
		return itineraryService.findUserUpcomingTrips(userProfileService.getCurrentUserProfile());
	}
}
