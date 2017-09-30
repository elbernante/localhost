package edu.mum.cs545.localhost.domain.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

public class NotLessThanValueValidator implements ConstraintValidator<NotLessThanValue, Object> {

	private String baseField;
	private String greaterThanField;
	
	@Override
	public void initialize(NotLessThanValue constraintAnnotation) {
		this.baseField = constraintAnnotation.baseField();
		this.greaterThanField = constraintAnnotation.greaterThanField();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Object baseFieldValue = new BeanWrapperImpl(value).getPropertyValue(baseField);
		Object greaterThanFieldValue = new BeanWrapperImpl(value).getPropertyValue(greaterThanField);
		
		if (!(baseFieldValue instanceof Comparable<?>) || 
				!(greaterThanFieldValue instanceof Comparable<?>)) {
			return false;
		}		
		return ((Comparable<Object>) baseFieldValue).compareTo(greaterThanFieldValue) <= 0;
	}
}
