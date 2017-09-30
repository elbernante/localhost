package edu.mum.cs545.localhost.domain.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy=NotLessThanValueValidator.class)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotLessThanValue {
	
	String message() default "{localhost.domain.notlessthan}";
	
	String baseField();
	
	String greaterThanField();
	
	Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
	
	@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	@interface List {
		NotLessThanValue[] value();
	}
}
