package edu.mum.cs545.localhost.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs545.localhost.domain.User;
import edu.mum.cs545.localhost.repository.UserRepository;

@Service
@Transactional(value=TxType.REQUIRES_NEW)
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
