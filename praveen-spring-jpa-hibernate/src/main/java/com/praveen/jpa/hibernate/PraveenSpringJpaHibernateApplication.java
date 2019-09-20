package com.praveen.jpa.hibernate;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.praveen.jpa.hibernate.entity.FullTimeEmployee;
import com.praveen.jpa.hibernate.entity.PartTimeEmployee;
import com.praveen.jpa.hibernate.repository.CourseRepository;
import com.praveen.jpa.hibernate.repository.EmployeeRepository;
import com.praveen.jpa.hibernate.repository.StudentRepository;

@SpringBootApplication
public class PraveenSpringJpaHibernateApplication implements CommandLineRunner {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	CourseRepository courseRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(PraveenSpringJpaHibernateApplication.class, args);
	}

	
	
	@Override
	public void run(String... args) throws Exception {
//		Course course=courseRepository.findById(10003L);
//		log.info("Course 10003 -> {} " , course);
		
		//studentRepository.saveStudentWithPassport();
		//courseRepository.addHardcodedReviewsForCourse();
//		List<Review> reviews= new ArrayList<Review>();
//		reviews.add(new Review("Superb Course","FOUR"));
//		reviews.add(new Review("Excellent Course","FIVE"));
//		courseRepository.addReviewsForCourse(10004L, reviews);
		
		employeeRepository.insert(new FullTimeEmployee("Praveen", new BigDecimal("100000")));
		employeeRepository.insert(new PartTimeEmployee("Naveen", new BigDecimal("50")));	
		
		log.info("PartTime Employees {}"+employeeRepository.retrievePartTimeEmployees());
		log.info("FullTime Employees {}"+employeeRepository.retrieveFullTimeEmployees());
		
		
	}

}
