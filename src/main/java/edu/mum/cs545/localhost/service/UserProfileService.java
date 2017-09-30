package edu.mum.cs545.localhost.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import edu.mum.cs545.localhost.domain.About;
import edu.mum.cs545.localhost.domain.Address;
import edu.mum.cs545.localhost.domain.User;
import edu.mum.cs545.localhost.domain.UserProfile;
import edu.mum.cs545.localhost.repository.AboutMeRepository;
import edu.mum.cs545.localhost.repository.UserProfileRepository;

@Service
@Transactional(value=TxType.REQUIRES_NEW)
public class UserProfileService {
	
	@Autowired
	private UserProfileRepository userProfileRepository;
	
	@Autowired
	private AboutMeRepository aboutMeRepository;
	
	public UserProfile getCurrentUserProfile() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return userProfileRepository.findByUser_Username(username);
	}
	
	public List<UserProfile> listUserProfile(String city, String state, String country) {
		List<UserProfile> userProfileList = userProfileRepository.findAllByPlace(city, state, country);
		List<UserProfile> userProfileListReturn = new ArrayList<UserProfile>();
		UserProfile userProfileReturn;
		Address address;
		User user;
		
		for (UserProfile userProfile : userProfileList) {
			userProfileReturn = new UserProfile();
			userProfileReturn.setFirstName(userProfile.getFirstName());
			userProfileReturn.setLastName(userProfile.getLastName());
			
			address = new Address();
			address.setCity(userProfile.getLocation().getCity());
			address.setState(userProfile.getLocation().getState());
			address.setCountry(userProfile.getLocation().getCountry());
			
			userProfileReturn.setLocation(address);
			
			user = new User();
			user.setUsername(userProfile.getUser().getUsername());
			
			userProfileReturn.setUser(user);
			
			userProfileListReturn.add(userProfileReturn);
		}
		
		return userProfileListReturn;
	}

	public List<UserProfile> getAllRequest() {
		
		return userProfileRepository.findAll();
	}

	public UserProfile save(UserProfile userProfile) {
		return userProfileRepository.save(userProfile);
	}

	public UserProfile update(UserProfile userProfile) {
		return userProfileRepository.save(userProfile);
	}

	public UserProfile get(long id) {
		return userProfileRepository.findOne(id);
	}

	public List<UserProfile> getAllUserProfileByContry(String country) {
		return userProfileRepository.getUserByCountry(country);
	}
	
	public About saveAbout(About about) {
		return aboutMeRepository.save(about);
	}
}
