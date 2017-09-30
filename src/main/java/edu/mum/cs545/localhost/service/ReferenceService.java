package edu.mum.cs545.localhost.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs545.localhost.domain.Reference;
import edu.mum.cs545.localhost.domain.ReferenceType;
import edu.mum.cs545.localhost.domain.UserProfile;
import edu.mum.cs545.localhost.repository.ReferenceRepository;

@Service
@Transactional(value=TxType.REQUIRES_NEW)
public class ReferenceService {
	
	@Autowired
	private UserProfileService userProfileService;
	
	@Autowired
	private ReferenceRepository referenceRepository;
	
	public Reference addReference(String userName, String type, String description) {
		Reference reference = new Reference();
		Long id = 1L;
		
		List<Reference> referenceList = referenceRepository.findAllOrderByIdDesc();
		
		if (referenceList != null && !referenceList.isEmpty()) {
			id = referenceList.get(0).getId() + 1L;
		}
		
		reference.setId(id);
		reference.setUserProfile(userProfileService.getByUsername(userName));
		reference.setDescription(description);
		reference.setDate(new Date());
		
		referenceRepository.save(reference);
		
		return new Reference();
	}
	
	public List<Reference> listReferences(String userName) {
		List<Reference> referenceList = referenceRepository.findAllByUserUserName(userName);
		List<Reference> referenceListReturn = new ArrayList<Reference>();
		Reference referenceReturn;
		UserProfile userProfile;
		
		for (Reference reference : referenceList) {
			referenceReturn = new Reference();
			referenceReturn.setDate(reference.getDate());
			referenceReturn.setDescription(reference.getDescription());
			
			userProfile = new UserProfile();
			userProfile.setFirstName(reference.getUserProfile().getFirstName());
			userProfile.setLastName(reference.getUserProfile().getLastName());
			
			referenceReturn.setUserProfile(userProfile);
			
			referenceListReturn.add(referenceReturn);
		}
		
		return referenceListReturn;
	}
}