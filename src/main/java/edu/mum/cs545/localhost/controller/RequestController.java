package edu.mum.cs545.localhost.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.mum.cs545.localhost.domain.Request;
import edu.mum.cs545.localhost.domain.RequestStatus;
import edu.mum.cs545.localhost.service.RequestService;
import edu.mum.cs545.localhost.service.UserProfileService;

@Controller
@SessionAttributes("id")
public class RequestController {
	@Autowired
	RequestService requestService;
	@Autowired
	UserProfileService userProfileService;

	@RequestMapping(value ="/addrequest",method =RequestMethod.GET)
	public String  request(@RequestParam("id") String id,@ModelAttribute("newRequest") Request req,Model model,Map map) {
    System.out.println("id request for guest"+id);
   
	model.addAttribute("id", id);
	return  "hostRequest";
		
	}
	
	
	@RequestMapping(value = { "/addrequest" }, method = RequestMethod.POST)
	public String request(@Valid @ModelAttribute("newRequest") Request req,BindingResult result, Map map) {
		System.out.println("hiiii:   " + (map.get("id")));
		if (result.hasErrors()){
			System.out.println("Hiiiiiiiii this is error");
			return "hostRequest";
		}
		req.setReqStatus(RequestStatus.Pending);
		Long userid = Long.parseLong(map.get("id").toString());
		req.setHost(userProfileService.get(userid));
		System.out.println(req.getHost().getFirstName());
		req.setGuest(userProfileService.getCurrentUserProfile());
		requestService.save(req);
		System.out.println("saved");
		return "redirect:/dashboard";
	}

	@RequestMapping(value = "/displayHost", method = RequestMethod.GET)
	public String display(@RequestParam("country") String country, Model model) {
		model.addAttribute("userProfile", userProfileService.getAllUserProfileByContry(country));
		return "hostUser";
	}

	@RequestMapping(value = "/viewRequest", method = RequestMethod.GET)
	public String viewRequest(Model model) throws Exception {
		System.out.println("idddddd   "+userProfileService.getCurrentUserProfile().getId());
		List<Request> r=requestService.getRequestByUser(userProfileService.getCurrentUserProfile().getId());
		if(r.size()==0) throw new Exception();
		
		Map<RequestStatus,RequestStatus> map=new HashMap<RequestStatus,RequestStatus>();
		map.put(RequestStatus.Accept, RequestStatus.Accept);
		map.put(RequestStatus.Reject, RequestStatus.Reject);
		map.put(RequestStatus.Pending, RequestStatus.Pending);
		
		model.addAttribute("staus",map);
		model.addAttribute("requests",requestService.getRequestByUser(userProfileService.getCurrentUserProfile().getId()));
		return "hostUser";
	}
   
	@RequestMapping(value="/listhost" ,method=RequestMethod.GET)
	public String displayUserByCountry(Model model){
		model.addAttribute("users",userProfileService.getAllUserProfileByContry("USA"));
		System.out.println("countrylived :"+userProfileService.getAllUserProfileByContry("USA").get(0).getFirstName());
		return "AllUserWithSelectedCountry";
	}
	
	@RequestMapping(value = "/requestview", method = RequestMethod.GET)
	public String requestDeatil(@RequestParam("id") String id,Model model) {
		
		Long reqId=Long.parseLong(id);
		System.out.println("Get path"+id);
		model.addAttribute("request",requestService.get(reqId));
		model.addAttribute("id",id);
	    return "RequestDetail";
	}
	
	@RequestMapping(value ="/requestview", method = RequestMethod.POST)
	public String saveResponse(@ModelAttribute("request") Request request,Map map) {
		// Request r=requestService.get(Long.parseLong(map.get("id").toString()));
		  System.out.println(map.get("id"));
		  request.setId(Long.parseLong(map.get("id").toString()));
		  request.setReqStatus(request.getReqStatus());
		  requestService.save(request);
		  return "redirect:/dashboard";
	}

}
