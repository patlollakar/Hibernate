package com.hibernatedemo.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernatedemo.util.HibernateUtil;



public class OvenFoodMain {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Oven oven = new Oven();
		oven.setOvenname("Micro");
		oven.setOvencompany("Tata");
		

		Food food = new Food();
		food.setFoodname("Tea");
		food.setOven(oven);
		
		Food food1 = new Food();
		food1.setFoodname("Coffee");
		food1.setOven(oven);
		
		Food food2 = new Food();
		food2.setFoodname("frozen");
		food2.setOven(oven);
	

		oven.getFood().add(food);
		oven.getFood().add(food1);
		oven.getFood().add(food2);
		
		session.save(oven);
		
		session.getTransaction().commit();
		session.close();
		sf.close();

	}

}
