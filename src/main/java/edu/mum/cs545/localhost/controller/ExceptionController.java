package edu.mum.cs545.localhost.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import edu.mum.cs545.localhost.domain.error.DomainError;
import edu.mum.cs545.localhost.domain.error.DomainErrors;

@Order(1)
@ControllerAdvice
public class ExceptionController {

	@Autowired
	MessageSourceAccessor messageSource;
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public DomainErrors handleException(MethodArgumentNotValidException exception) {
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		
		DomainErrors errors = new DomainErrors();
		errors.setErrorType("ValidationError");
		if (exception.getBindingResult().hasGlobalErrors()) {
			errors.setMessage(exception.getBindingResult().getGlobalError().getDefaultMessage());
		}
		
		for(FieldError fieldError : fieldErrors) {
			DomainError error = new DomainError(fieldError.getField(), messageSource.getMessage(fieldError));
			errors.addError(error);
		}
		
		return errors;
	}
	
	@ExceptionHandler(InvalidFormatException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public DomainErrors handleHttpMessageNotReadableExceptionException(InvalidFormatException exception) {
		DomainErrors errors = new DomainErrors();
		errors.setErrorType("ValueError");
		errors.setMessage(messageSource.getMessage("typeMismatch." + exception.getTargetType().getName()));
		return errors;
	}
	
	
	@ExceptionHandler(AccessDeniedException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ResponseBody
	public DomainErrors accessDenied(AccessDeniedException exception) {
		DomainErrors errors = new DomainErrors();
		errors.setErrorType("AccessDenied");
		errors.setMessage(messageSource.getMessage(exception.getMessage()));
		return errors;
	}
	
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public DomainErrors notFound(NotFoundException exception) {
		DomainErrors errors = new DomainErrors();
		errors.setErrorType("NotFound");
		errors.setMessage(messageSource.getMessage(exception.getMessage()));
		return errors;
	}
	
}
