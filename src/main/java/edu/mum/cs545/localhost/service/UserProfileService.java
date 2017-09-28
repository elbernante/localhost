package edu.mum.cs545.localhost.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import edu.mum.cs545.localhost.domain.UserProfile;
import edu.mum.cs545.localhost.repository.UserProfileRepository;

@Service
@Transactional(value=TxType.REQUIRES_NEW)
public class UserProfileService {
	
	@Autowired
	private UserProfileRepository userProfileRepository;
	
	public UserProfile getCurrentUserProfile() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return userProfileRepository.findByUser_Username(username);
	}
	
	public List<UserProfile> listUserProfile(String city, String state, String country) {
		return userProfileRepository.findAllByPlace(city, state, country);
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
}
