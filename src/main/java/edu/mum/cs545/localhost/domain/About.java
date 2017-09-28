package edu.mum.cs545.localhost.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;


@Entity
public class About {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private UserProfile userProfile;
	
	private String hostAvaliable;
	
	private String grewUp;
	
	private String occupation;
	
	private String education;
	
	@ElementCollection
	@CollectionTable(
	        name="LANGUAGE",
	        joinColumns=@JoinColumn(name="ABOUT_ID")
	  )
	@Column(name="LANGUAGE")
	private List<String> languages;
	
	private String aboutMe;
	
	private String myFavorite;
	
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

	public String getHostAvaliable() {
		return hostAvaliable;
	}

	public void setHostAvaliable(String hostAvaliable) {
		this.hostAvaliable = hostAvaliable;
	}

	public String getGrewUp() {
		return grewUp;
	}

	public void setGrewUp(String grewUp) {
		this.grewUp = grewUp;
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



	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public String getMyFavorite() {
		return myFavorite;
	}

	public void setMyFavorite(String myFavorite) {
		this.myFavorite = myFavorite;
	}

}
