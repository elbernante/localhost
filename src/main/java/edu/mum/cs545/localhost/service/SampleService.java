package edu.mum.cs545.localhost.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs545.localhost.domain.SampleModel;
import edu.mum.cs545.localhost.repository.SampleRepository;

@Service
@Transactional(value=TxType.REQUIRES_NEW)
public class SampleService {
	
	@Autowired
	private SampleRepository sampleRepository;
	
	public SampleModel getSample() {
		return sampleRepository.findOne(1L);
	}
}
