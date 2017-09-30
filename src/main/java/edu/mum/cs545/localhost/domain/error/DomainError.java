package edu.mum.cs545.localhost.domain.error;

public class DomainError {
	
	private String field = "";
	private String message = "";
			
	public DomainError() {}
	
	public DomainError(String error) {
		this.message = error;
	}
	
	public DomainError(String field, String message) {
		this.field = field;
		this.message = message;
	}
	
	public String getField() {
		return field;
	}
	
	public void setField(String field) {
		this.field = field;
	}
	
	public String getError() {
		return message;
	}
	
	public void setError(String error) {
		this.message = error;
	}
}
