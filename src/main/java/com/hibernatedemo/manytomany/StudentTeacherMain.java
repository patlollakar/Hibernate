package com.hibernatedemo.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.hibernatedemo.util.HibernateUtil;

public class StudentTeacherMain {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		Students student = new Students();
		student.setFname("kar");
		student.setLname("thik");
		
		Students student1 = new Students();
		student1.setFname("tom");
		student1.setLname("hanks");
		
		
		

		Teacher teacher = new Teacher();
		teacher.setName("Israr");
		teacher.setSubject("Database");
		teacher.getStudent().add(student);

		Teacher teacher1 = new Teacher();
		teacher1.setName("wahby");
		teacher1.setSubject("Java");
		teacher1.getStudent().add(student1);
		
		Teacher teacher2 = new Teacher();
		teacher2.setName("wahby");
		teacher2.setSubject("Java");
		teacher2.getStudent().add(student1);
		
		Teacher teacher3 = new Teacher();
		teacher1.setName("wahby");
		teacher1.setSubject("Java");
		teacher1.getStudent().add(student);
		
		session.save(teacher3);
		session.save(student);
		
		
		
		session.save(teacher2);
		session.save(student1);
		

		session.save(teacher);
		session.save(student);
		
		session.save(teacher1);
		session.save(student1);

		session.getTransaction().commit();
		session.close();
		sf.close();
	}
}