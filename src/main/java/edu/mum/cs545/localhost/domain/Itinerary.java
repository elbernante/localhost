package edu.mum.cs545.localhost.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import edu.mum.cs545.localhost.domain.validation.NotLessThanValue;
import edu.mum.cs545.localhost.util.CustomDateSerializer;
import edu.mum.cs545.localhost.util.UserProfileIdentityJsonSerializer;

@NotLessThanValue(
		baseField = "arrivalDate",
		greaterThanField = "departureDate",
		message="{departureDate} {localhost.domain.notbeforedate} {arrivalDate}"
)
@Entity
public class Itinerary {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST, optional=false)
	@JsonSerialize(using=UserProfileIdentityJsonSerializer.class)
	private UserProfile user;
	
	@NotNull(message="{NotNull}")
	@Future(message="{Future}")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape=Shape.STRING, pattern="MM/dd/yyyy", timezone="CST")
	@JsonSerialize(using=CustomDateSerializer.class)
	private Date arrivalDate;
	
	@NotNull(message="{NotNull}")
	@Future(message="{Future}")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape=Shape.STRING, pattern="MM/dd/yyyy", timezone="CST")
	@JsonSerialize(using=CustomDateSerializer.class)
	private Date departureDate;
	
	@NotBlank(message="{NotNull}")
	private String city;
	
	private String state;
	
	@NotBlank(message="{NotNull}")
	private String country;
	
	@Lob
	@NotBlank(message="{NotNull}")
	private String message;
	
	public Long getId() {
		return id;
	}
	
	public UserProfile getUser() {
		return user;
	}
	
	public void setUser(UserProfile user) {
		this.user = user;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
