package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "email")
public class Email {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	 private String email;
	 

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	@OneToOne(mappedBy = "email")
    private User user;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public Email(String email) {
		super();
		this.email = email;
	}

	public Email() {
		super();
	}
	
	
}
