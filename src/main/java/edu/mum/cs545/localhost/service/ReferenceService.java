package edu.mum.cs545.localhost.service;

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
		reference.setDate(new Date());
		//reference.setUser(user); -- GET FROM SESSION CURRENT USER
		
		//return referenceRepository.save(reference);
		
		Reference r = new Reference();
		r.setId(2L);
		r.setDescription(reference.getDescription());
		r.setDate(new Date());
		
		return r;
	}
	
	public List<Reference> listReferences(Long userProfileId) {
		List<Reference> referenceList = referenceRepository.findAllByUserId(userProfileId);
		
		for (Reference reference : referenceList) {
			reference.setUserProfile(null);
		}
		
		return referenceList;
	}
}