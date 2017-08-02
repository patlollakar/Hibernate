package com.hibernatedemo.model.onetoone;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long studentId;
	private String studentName;
	private String studentEmail;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="std")
	private StudentAddress studentaddress;

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public StudentAddress getStudentaddress() {
		return studentaddress;
	}

	public void setStudentaddress(StudentAddress studentaddress) {
		this.studentaddress = studentaddress;
	}

	
	
	}