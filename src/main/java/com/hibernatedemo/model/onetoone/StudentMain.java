package com.hibernatedemo.model.onetoone;

import org.hibernate.Session;
//import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernatedemo.util.HibernateUtil;


public class StudentMain {

	public static void main(String[] args) {
		System.out.println("Hibernate one to one (Annotation)");
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session =sf.openSession();

		session.beginTransaction();

	Student s1 = new Student();

		s1.setStudentName("kar");
		s1.setStudentEmail("kar@gmail.com");

		StudentAddress sa = new StudentAddress();
		sa.setStreet("Main street");
		sa.setCity("Lewisville");
		sa.setCountry(" USA");
	

		s1.setStudentaddress(sa);
		sa.setStd(s1);

	session.save(s1);
	
		Student s = session.get(Student.class, 1L);
		System.out.println(s.getStudentName());
		System.out.println(s.getStudentaddress().getStreet());
	
		/*
		Student student = session.get(Student.class, 2L);
		System.out.println(student.getStudentName());
		System.out.println(student.getStudentEmail());
		System.out.println(student.getStudentaddress().getStreet());
		*/
		
		
		
		
		//System.out.println(s.getStockDetail().getCompanyName());
		session.getTransaction().commit();
		session.close();
		sf.close();

		System.out.println("Done");
		
		
	}

}