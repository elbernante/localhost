package edu.mum.cs545.localhost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.cs545.localhost.domain.About;

public interface AboutMeRepository extends JpaRepository<About, Long> {
	
}
