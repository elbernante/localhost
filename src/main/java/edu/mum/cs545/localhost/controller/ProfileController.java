package edu.mum.cs545.localhost.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.cs545.localhost.domain.About;
import edu.mum.cs545.localhost.domain.Address;
import edu.mum.cs545.localhost.domain.Authority;
import edu.mum.cs545.localhost.domain.User;
import edu.mum.cs545.localhost.domain.UserProfile;
import edu.mum.cs545.localhost.service.UserProfileService;

@Controller
@RequestMapping("/profile")
public class ProfileController {
	@Autowired
    UserProfileService userProfileService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public String view(@PathVariable("username") String username, Model model) {
		model.addAttribute("userProfile", userProfileService.getByUsername(username));
		
		return "profile";
	}
	
	@RequestMapping(value="/addProfile", method=RequestMethod.GET)
	public String addProfile(@ModelAttribute("newUserProfile") UserProfile UserProfile) {
		return "UserProfile";
	}
	
	@RequestMapping(value="/addProfile", method=RequestMethod.POST)
	public String saveProfile(@ Valid @ModelAttribute("newUserProfile") UserProfile userProfile,BindingResult resut,
			RedirectAttributes redirect,Model model) {
		if(resut.hasErrors())
			return "UserProfile";
		
		
		
//		userProfile.setUser(userProfile.getUser());
		/*System.out.println("PASSWORD: " + userProfile.getUser().getPassword());
		String password = passwordEncoder.encode(userProfile.getUser().getPassword());
		System.out.println("ENCODED PASSWORD: " + password);*/
		//userProfile.getUser().setPassword(password);
		//System.out.println("SET PASSWORD: " + userProfile.getUser().getPassword());
		
		User user = userProfile.getUser();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Authority auth = new Authority();
		auth.setAuthority("USER_ROLE");
		user.addAuthority(auth);
		userProfile.setUser(user);
		
		userProfileService.save(userProfile);
	    //model.addAttribute("user",userProfile.getUser());
	    System.out.println("Hi hi ");
		return "redirect:/dashboard";
	}
	
	@RequestMapping(value="/addAddress", method=RequestMethod.POST)
	public @ResponseBody Address saveRequest(@RequestBody Address address)
	{
		return address;
	}
	
	@RequestMapping(value="/{username}/aboutme", method=RequestMethod.GET)
	public String addABout(@PathVariable("username") String username,Model model) {
		 Map<String, String> hostAvaliableList=new HashMap<String,String>();  
		 hostAvaliableList.put("yes", "Accepting Guests");  
		 hostAvaliableList.put("no", "Not Accepting Guests");  
		 hostAvaliableList.put("hang", "Wants to Meet Up"); 
	 	 model.addAttribute("hostAvaliableList",hostAvaliableList);
	 	 model.addAttribute("about", new About());
	 	 
		 return "aboutMe";
	}
	
	@RequestMapping(value="/{username}/aboutme", method=RequestMethod.POST)
	public String saveAbout(@ModelAttribute("about") About about,Model model,RedirectAttributes redirectAttributes) {
		about.setUserProfile(userProfileService.getCurrentUserProfile());
		userProfileService.saveAbout(about);
		redirectAttributes.addFlashAttribute( "about", about);
		return "redirect:/profile/aboutView";
	}
	
	@RequestMapping(value="/aboutView", method=RequestMethod.GET)
	public String aboutView(Model model) {
		
		About about = (About)( ((ModelMap) model).get("about") );

		return "aboutView";
	}
	
}

