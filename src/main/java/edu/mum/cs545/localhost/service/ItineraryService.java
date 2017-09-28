package edu.mum.cs545.localhost.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs545.localhost.domain.Itinerary;
import edu.mum.cs545.localhost.repository.ItineraryRepository;

@Service
@Transactional(value=TxType.REQUIRES_NEW)
public class ItineraryService {

	@Autowired
	private ItineraryRepository itineraryRepository;
	
	public Itinerary saveItineray(Itinerary itinerary) {
		return itineraryRepository.save(itinerary);
	}
}
