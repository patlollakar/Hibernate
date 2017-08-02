package com.hibernatedemo.manytomany;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Teacherid;
	private String name;
	private String subject;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade =
        { CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.REFRESH,
                CascadeType.PERSIST
        },targetEntity=Students.class)
	@JoinTable(name = "Teacher_Student", joinColumns = {
			@JoinColumn(name = "Teacherid", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "Studentid", nullable = false) })
	private List<Students> student = new ArrayList<Students>();
	
	public Teacher(){
		
	}

	public Long getTeacherid() {
		return Teacherid;
	}

	public void setTeacherid(Long teacherid) {
		Teacherid = teacherid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<Students> getStudent() {
		return student;
	}

	public void setStudent(List<Students> student) {
		this.student = student;
	}
}
	