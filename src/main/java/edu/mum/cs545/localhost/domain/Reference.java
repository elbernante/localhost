package edu.mum.cs545.localhost.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reference {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
   private ReferenceType referenceType;
   private String discription;
public ReferenceType getReferenceType() {
	return referenceType;
}
public void setReferenceType(ReferenceType referenceType) {
	this.referenceType = referenceType;
}
public String getDiscription() {
	return discription;
}
public void setDiscription(String discription) {
	this.discription = discription;
}
   
}
