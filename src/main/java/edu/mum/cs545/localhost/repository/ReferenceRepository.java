package edu.mum.cs545.localhost.repository;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.cs545.localhost.domain.Reference;

@Repository
@Transactional(value=TxType.MANDATORY)
public interface ReferenceRepository extends JpaRepository<Reference, Long> {
	
	@Query("select r from Reference r where r.user.id = :userId")
	List<Reference> findAllByUserId(@Param("userId") Long userId);
}