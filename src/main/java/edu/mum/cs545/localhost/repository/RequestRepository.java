package edu.mum.cs545.localhost.repository;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.cs545.localhost.domain.Request;


@Repository
@Transactional(value=TxType.MANDATORY)
	public interface RequestRepository extends JpaRepository<Request, Long>{
  
	@Query("Select r"+" from Request r left join r.host h"+" where h.id =:host")
	public List<Request> getRequestByUser(@Param("host") Long id);
	
}

