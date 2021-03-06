package edu.mum.cs545.localhost.repository;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs545.localhost.domain.SampleModel;

@Repository
@Transactional(value=TxType.MANDATORY)
public interface SampleRepository extends JpaRepository<SampleModel, Long> {

}
