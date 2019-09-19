package com.praveen.jpa.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.praveen.jpa.hibernate.entity.Review;
import com.praveen.jpa.hibernate.repository.CourseRepository;
import com.praveen.jpa.hibernate.repository.StudentRepository;

@SpringBootApplication
public class PraveenSpringJpaHibernateApplication implements CommandLineRunner {
	
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	CourseRepository courseRepository;


	public static void main(String[] args) {
		SpringApplication.run(PraveenSpringJpaHibernateApplication.class, args);
	}

	
	
	@Override
	public void run(String... args) throws Exception {
//		Course course=courseRepository.findById(10003L);
//		log.info("Course 10003 -> {} " , course);
		
		//studentRepository.saveStudentWithPassport();
		//courseRepository.addHardcodedReviewsForCourse();
		List<Review> reviews= new ArrayList<Review>();
		reviews.add(new Review("Superb Course","FOUR"));
		reviews.add(new Review("Excellent Course","FIVE"));
		courseRepository.addReviewsForCourse(10004L, reviews);
	}

}
