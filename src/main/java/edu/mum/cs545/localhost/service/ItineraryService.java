package edu.mum.cs545.localhost.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs545.localhost.domain.Itinerary;
import edu.mum.cs545.localhost.domain.UserProfile;
import edu.mum.cs545.localhost.repository.ItineraryRepository;

@Service
@Transactional(value=TxType.REQUIRES_NEW)
public class ItineraryService {

	@Autowired
	private ItineraryRepository itineraryRepository;
	
	public Itinerary getItenerary(Long id) {
		return itineraryRepository.findOne(id);
	}
	
	public void deleteItinerary(Long id) {
		itineraryRepository.delete(id);
	}
	
	public void deleteItinerarry(Itinerary itinerary) {
		itineraryRepository.delete(itinerary);
	}
	
	public Itinerary saveItineray(Itinerary itinerary) {
		return itineraryRepository.save(itinerary);
	}
	
	public List<Itinerary> findAllUserItineray(UserProfile user) {
		return itineraryRepository.findAllUserItineray(user);
	}
	
	public List<Itinerary> findUserUpcomingTrips(UserProfile user) {
		return itineraryRepository.findUserUpcomingTrips(user, new Date());
	}
}
