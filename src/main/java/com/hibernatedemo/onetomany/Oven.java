package com.hibernatedemo.onetomany;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;


@Entity
public class Oven {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ovenid;
	private String ovenname;
	private String ovencompany;

	@OneToMany(mappedBy = "oven", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OrderColumn
	private List<Food> food = new ArrayList<Food>();
	
	public Oven(){
		
	}
	
	public Oven(String ovenname, String ovencompany){
		this.ovenname = ovenname;
		this.ovencompany = ovencompany;
	}

	public Long getOvenid() {
		return ovenid;
	}

	public void setOvenid(Long ovenid) {
		this.ovenid = ovenid;
	}

	public String getOvenname() {
		return ovenname;
	}

	public void setOvenname(String ovenname) {
		this.ovenname = ovenname;
	}

	public String getOvencompany() {
		return ovencompany;
	}

	public void setOvencompany(String ovencompany) {
		this.ovencompany = ovencompany;
	}

	public List<Food> getFood() {
		return food;
	}

	public void setFood(List<Food> food) {
		this.food = food;
	}
	
	
}
