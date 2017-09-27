package edu.mum.cs545.localhost.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.cs545.localhost.domain.Reference;
import edu.mum.cs545.localhost.service.ReferenceService;

@Controller
@RequestMapping("/reference")
public class ReferenceController {
	
	@Autowired
	ReferenceService referenceService;

	@RequestMapping(value="", method=RequestMethod.POST)
	//public @ResponseBody Reference addReference(@Valid @RequestBody Reference reference) {
	public @ResponseBody Reference addReference(@RequestParam("description") String description) {
		//return referenceService.addReference(reference);
		
		Reference r = new Reference();
		r.setId(2L);
		r.setDescription(description);
		r.setDate(new Date());
		
		return r;
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public @ResponseBody List<Reference> listReferences(@RequestParam("userName") String userName) {
		return referenceService.listReferences(userName);
	}
}