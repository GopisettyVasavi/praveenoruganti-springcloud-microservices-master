package com.praveen.jpa.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.praveen.jpa.hibernate.repository.StudentRepository;

@SpringBootApplication
public class PraveenSpringJpaHibernateApplication implements CommandLineRunner {
	
	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(PraveenSpringJpaHibernateApplication.class, args);
	}

	
	
	@Override
	public void run(String... args) throws Exception {
//		Course course=courseRepository.findById(10003L);
//		log.info("Course 10003 -> {} " , course);
		
		studentRepository.saveStudentWithPassport();
	}

}
