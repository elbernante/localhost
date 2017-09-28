package edu.mum.cs545.localhost.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs545.localhost.domain.Request;
import edu.mum.cs545.localhost.domain.UserProfile;
import edu.mum.cs545.localhost.repository.RequestRepository;
@Service
@Transactional
public class RequestService {
	
  @Autowired
  RequestRepository requestRepository;
    public List<Request> getAllRequest(){
    	return requestRepository.findAll();
    }
    
   public Request save(Request req){
	   return requestRepository.save(req);
   }
    public Request update(Request req){
    	return requestRepository.save(req);
    }
    public Request get(long id){
    	return  requestRepository.findOne(id);
    }
    public List<Request> getRequestByUser(Long host)
    { 
    	
    	return requestRepository.getRequestByUser(host);
    }
    
   
}
