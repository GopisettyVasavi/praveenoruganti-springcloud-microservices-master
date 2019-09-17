package com.praveen.jpa.hibernate.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.praveen.jpa.hibernate.entity.Passport;
import com.praveen.jpa.hibernate.entity.Student;

@Repository
@Transactional
public class StudentRepository {
	
	@Autowired
	EntityManager em;
	
	public Student findById(Long id) {		
		return em.find(Student.class, id);
	}
	
	public void deleteById(Long id) {
		Student student=findById(id);
		 em.remove(student);
	}
	
	public void save(Student student) {
		if(student.getId()==null) {
		  em.persist(student); //insert
		}else {
		  em.merge(student); //update
		}
	}
	
	public void saveStudentWithPassport() {
		Passport passport= new Passport("Z123456");
		em.persist(passport);
		Student student= new Student("Varma");
		student.setPassport(passport);
		em.persist(student);
	}
}
