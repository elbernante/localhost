package edu.mum.cs545.localhost.domain;

import java.util.List;

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
	/*
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private UserProfile userProfile;

	private List<String> availableNights;
	
	private  int maxGuest;
	
	private String preferGenfer;
	
	private List<String> childrenPetSmoking;
	
	private String addInformation;*/
}
