package edu.mum.cs545.localhost.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs545.localhost.domain.Reference;
import edu.mum.cs545.localhost.repository.ReferenceRepository;

@Service
@Transactional(value=TxType.REQUIRES_NEW)
public class ReferenceService {
	
	@Autowired
	private ReferenceRepository referenceRepository;
	
	public Reference addReference(Reference reference) {
		return referenceRepository.save(reference);
	}
	
	public List<Reference> listReferences(String userName) {
		//return referenceRepository.findAllByUserId(userName);
		
		Reference r = new Reference();
		r.setId(10L);
		r.setDescription("Test");
		r.setDate(new Date());
		
		Reference r2 = new Reference();
		r2.setId(20L);
		r2.setDescription("Test2");
		r2.setDate(new Date());
		
		List<Reference> list = new ArrayList<Reference>();
		list.add(r);
		list.add(r2);
		
		return list;
	}
}