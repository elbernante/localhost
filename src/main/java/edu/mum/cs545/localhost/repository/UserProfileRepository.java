package edu.mum.cs545.localhost.repository;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.cs545.localhost.domain.UserProfile;

@Repository
@Transactional(value = TxType.MANDATORY)
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

	@Query("Select u from UserProfile u where u.countriesLived =:country")
	public List<UserProfile> getUserByCountry(@Param("country") String Country);
	
	public UserProfile findByUser_Username(String username);
	
	@Query("select u from UserProfile u where u.location.city = :city or u.location.state = :state or u.location.country = :country")
	List<UserProfile> findAllByPlace(@Param("city") String city, @Param("state") String state,
		@Param("country") String country);

}
