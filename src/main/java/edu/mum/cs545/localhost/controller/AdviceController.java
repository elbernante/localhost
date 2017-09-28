package edu.mum.cs545.localhost.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class AdviceController {

	 @ExceptionHandler(Exception.class)
	 public ModelAndView errorHandler(HttpServletRequest request, Exception e) throws Exception {
		 ModelAndView mav = new ModelAndView();
		 mav.addObject("errorMessage", "Go back to home");
		 mav.setViewName("errorPage");;
		 return mav;
	 }
}
