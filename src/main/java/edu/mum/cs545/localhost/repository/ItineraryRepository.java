package edu.mum.cs545.localhost.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.cs545.localhost.domain.Itinerary;
import edu.mum.cs545.localhost.domain.UserProfile;

@Repository
@Transactional(value=TxType.MANDATORY)
public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {

	@Query("SELECT i FROM Itinerary i WHERE i.user = :user ORDER BY i.arrivalDate DESC")
	public List<Itinerary> findAllUserItineray(@Param("user") UserProfile user);
	
	@Query("SELECT i FROM Itinerary i WHERE i.user = :user AND i.arrivalDate >= :arrivalDate ORDER BY i.arrivalDate ASC")
	public List<Itinerary> findUserUpcomingTrips(@Param("user") UserProfile user, @Param("arrivalDate") Date date);
	
}
