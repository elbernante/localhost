package edu.mum.cs545.localhost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.cs545.localhost.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUsername(String username);
}
