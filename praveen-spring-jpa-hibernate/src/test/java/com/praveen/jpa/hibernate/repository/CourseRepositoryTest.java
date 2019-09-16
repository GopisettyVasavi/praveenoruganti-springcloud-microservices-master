package com.praveen.jpa.hibernate.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.praveen.jpa.hibernate.PraveenSpringJpaHibernateApplication;
import com.praveen.jpa.hibernate.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=PraveenSpringJpaHibernateApplication.class)
public class CourseRepositoryTest {
	private Logger log= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public CourseRepository courseRepository;
	
	
	@Test
	@DirtiesContext
	public void findById() {
		log.info("findById Test is running");
		Course course=courseRepository.findById(10003L);
		assertEquals("JPA HIBERNATE", course.getName());
	}
	
	@Test
	@DirtiesContext
	public void save() {
		log.info("save Test is running");
		Course course=courseRepository.findById(10003L);
		assertEquals("JPA HIBERNATE", course.getName());
		course.setName("SQL");
		courseRepository.save(course);
		assertEquals("SQL", course.getName());
		
	}

}
