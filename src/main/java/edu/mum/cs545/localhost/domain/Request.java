package edu.mum.cs545.localhost.domain;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
//import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Request {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	//@Future
	@DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate arrivalDate ;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
   // @Future
   private LocalDate departureDate ;
   @Min(value=1, message="{validation.traveler}")
   private Integer numberOfTraveler;
   private RequestStatus reqStatus;
   @OneToOne(fetch = FetchType.EAGER)
   private UserProfile guest; 
   @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
   private User host;
   public LocalDate getArrivalDate() {
	return arrivalDate;
}
public void setArrivalDate(LocalDate arrivalDate) {
	this.arrivalDate = arrivalDate;
}
public LocalDate getDepartureDate() {
	return departureDate;
}
public void setDepartureDate(LocalDate departureDate) {
	this.departureDate = departureDate;
}
public Integer getNumberOfTraveler() {
	return numberOfTraveler;
}
public void setNumberOfTraveler(Integer numberOfTraveler) {
	this.numberOfTraveler = numberOfTraveler;
}
public RequestStatus getReqStatus() {
	return reqStatus;
}
public void setReqStatus(RequestStatus reqStatus) {
	this.reqStatus = reqStatus;
}
public UserProfile getGuest() {
	return guest;
}
public void setGuest(UserProfile guest) {
	this.guest = guest;
}
public User getHost() {
	return host;
}
public void setHost(User host) {
	this.host = host;
}

  
}
