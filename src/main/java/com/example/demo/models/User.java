package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Transient;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank(message = "Field can not be empty.")
	@Length(min = 2, max = 10, message = "Name should be at least 2 and maximum 10 characters long.")
	private String name;
	
	@Column(unique = true)
	@NotBlank(message = "Field can not be empty.")
	@Email(regexp= "^(.+)@(\\S+)$", message = "Invalid email id.")
	private String email;
	
	@NotBlank(message = "Field can not be empty.")
	private String password;
	
	private String role;
	private boolean enabled;
	private String imageUrl;
	
	@Column(length = 100)
	@Length(max = 100, message = "Max 100 characters allowed.")
	private String about;

	@Transient
	@AssertTrue(message = "Please agree the terms and conditions.")
	private boolean agreement = false;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Contact> contacts = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public boolean isAgreement() {
		return agreement;
	}

	public void setAgreement(boolean agreement) {
		this.agreement = agreement;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", enabled=" + enabled + ", imageUrl=" + imageUrl + ", about=" + about + ", agreement=" + agreement
				+ ", contacts=" + contacts + "]";
	}


}
