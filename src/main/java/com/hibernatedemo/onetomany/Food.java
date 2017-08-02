package com.hibernatedemo.onetomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Foodid;

	private String foodname;
	private String foodquantity;
	
	@ManyToOne
	@JoinColumn(name = "oven_id")
	private Oven oven;
	
	public Food() {

	}

	public Food(String foodname, String foodquantity, Oven oven) {
		super();
		this.foodname = foodname;
		this.foodquantity = foodquantity;
		this.oven = oven;

	}

	public Long getFoodid() {
		return Foodid;
	}

	public void setFoodid(Long foodid) {
		Foodid = foodid;
	}

	public String getFoodname() {
		return foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}

	public String getFoodquantity() {
		return foodquantity;
	}

	public void setFoodquantity(String foodquantity) {
		this.foodquantity = foodquantity;
	}

	public Oven getOven() {
		return oven;
	}

	public void setOven(Oven oven) {
		this.oven = oven;
	}
	
	
}

