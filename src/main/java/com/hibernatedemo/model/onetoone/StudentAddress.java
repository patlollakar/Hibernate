package com.hibernatedemo.model.onetoone;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class StudentAddress implements Serializable {

	private static final long serialVersionUID = 1L;

	@GenericGenerator(name="generator",strategy="foreign",parameters=@Parameter(name="property",value="std"))
	@Id
	@GeneratedValue(generator="generator")
	private Long studentid;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Student std;
	private String street;
	private String city;
	private String country;
	
	
	public Long getStudentid() {
		return studentid;
	}
	public void setStudentid(Long studentid) {
		studentid = studentid;
	}
	public Student getStd() {
		return std;
	}
	public void setStd(Student std) {
		this.std = std;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	}
	