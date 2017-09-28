package edu.mum.cs545.localhost.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Credentials")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, unique=true)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	@Transient
	private String verifyPassword;
	
	private Boolean enabled = true;
	
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="user_id")
	private List<Authority> authority = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getVerifyPassword() {
		return verifyPassword;
	}
	
	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}
	
	public Boolean getEnabled() {
		return enabled;
	}
	
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	public List<Authority> getAuthority() {
		return Collections.unmodifiableList(authority);
	}
	
	public void addAuthority(Authority authority) {
		this.authority.add(authority);
	}
	
	public boolean removeAuthority(Authority authority) {
		return this.authority.remove(authority);
	}

	
	public void setAuthority(List<Authority> authority) {
		this.authority = authority;
	}
	
}
