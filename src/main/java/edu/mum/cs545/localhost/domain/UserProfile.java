package edu.mum.cs545.localhost.domain;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;

@Entity
public class UserProfile {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private User user;
	
	private File picture;
	@Valid
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Address location;
	
	private  HostingStatus HostingStatus;
	private String occupation;
	private String education;
	private String language;
	private String aboutMe;
	private String myInterests;
	private String countriesVisited;
	private String countriesLived;
	@OneToMany(fetch=FetchType.LAZY ,cascade=CascadeType.ALL)
	private List<Request> request=new ArrayList<Request>();
	
	public List<Request> getRequest() {
		return request;
	}
	public void setRequest(List<Request> request) {
		this.request = request;
	}
	private List<Reference> userReference=new ArrayList<Reference>();
	public List<Reference> getUserReference() {
		return userReference;
	}
	public void setUserReference(List<Reference> userReference) {
		this.userReference = userReference;
	}
	
	public File getPicture() {
		return picture;
	}
	public void setPicture(File picture) {
		this.picture = picture;
	}
	public Address getLocation() {
		return location;
	}
	public void setLocation(Address location) {
		this.location = location;
	}
	public HostingStatus getHostingStatus() {
		return HostingStatus;
	}
	public void setHostingStatus(HostingStatus hostingStatus) {
		HostingStatus = hostingStatus;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getAboutMe() {
		return aboutMe;
	}
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	public String getMyInterests() {
		return myInterests;
	}
	public void setMyInterests(String myInterests) {
		this.myInterests = myInterests;
	}
	public String getCountriesVisited() {
		return countriesVisited;
	}
	public void setCountriesVisited(String countriesVisited) {
		this.countriesVisited = countriesVisited;
	}
	public String getCountriesLived() {
		return countriesLived;
	}
	public void setCountriesLived(String countriesLived) {
		this.countriesLived = countriesLived;
	}
	public Long getId() {
		return id;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
