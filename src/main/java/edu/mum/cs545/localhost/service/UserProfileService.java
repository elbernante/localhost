package edu.mum.cs545.localhost.service;

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
}
