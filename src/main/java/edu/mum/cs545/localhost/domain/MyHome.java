package edu.mum.cs545.localhost.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class MyHome {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private UserProfile userProfile;

	private String availableNights;
	
	private  int maxGuest;
	
	private String preferGenfer;
	
	//private List<String> childrenPetSmoking;
	
	private String addInformation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public String getAvailableNights() {
		return availableNights;
	}

	public void setAvailableNights(String availableNights) {
		this.availableNights = availableNights;
	}

	public int getMaxGuest() {
		return maxGuest;
	}

	public void setMaxGuest(int maxGuest) {
		this.maxGuest = maxGuest;
	}

	public String getPreferGenfer() {
		return preferGenfer;
	}

	public void setPreferGenfer(String preferGenfer) {
		this.preferGenfer = preferGenfer;
	}


	public String getAddInformation() {
		return addInformation;
	}

	public void setAddInformation(String addInformation) {
		this.addInformation = addInformation;
	}
}
