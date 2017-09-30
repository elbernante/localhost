package edu.mum.cs545.localhost.domain;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Future;
//import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Request {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@DateTimeFormat(pattern ="dd-MM-yyyy")
    private LocalDate arrivalDate ;
	
    @DateTimeFormat(pattern ="dd-MM-yyyy")
    private LocalDate departureDate ;
    private String responseMessage;
    public void setId(Long id) {
		this.id = id;
	}
	private String sendMessage;
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
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public String getSendMessage() {
		return sendMessage;
	}
	public void setSendMessage(String sendMessage) {
		this.sendMessage = sendMessage;
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
	public UserProfile getHost() {
		return host;
	}
	public void setHost(UserProfile host) {
		this.host = host;
	}
	public Long getId() {
		return id;
	}
//   @NotNull
   @Min(value=1, message="{request.traveler.validation}")
   private Integer numberOfTraveler;
   private RequestStatus reqStatus;
   @OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
   private UserProfile guest; 
   //many request belongs to one Userprofile
   @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//   @Valid
   private UserProfile host;


  
}
