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
public class Students {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Studentid;
	private String fname;
	private String lname;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade =
        {
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.REFRESH,
                CascadeType.PERSIST
        }, targetEntity=Teacher.class)
	@JoinTable(name = "Teacher_Student", joinColumns = {
			@JoinColumn(name = "Studentid", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "Teacherid", nullable = false) 
	})	
	private List<Teacher> teacher = new ArrayList<Teacher>();
	
	public Students(){
		
	}
	
	public Students(String fname, String lname){
		this.fname = fname;
		this.lname = lname;
	}

	public Long getStudentid() {
		return Studentid;
	}

	public void setStudentid(Long studentid) {
		Studentid = studentid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public List<Teacher> getTeacher() {
		return teacher;
	}

	public void setTeacher(List<Teacher> teacher) {
		this.teacher = teacher;
	}
}

	