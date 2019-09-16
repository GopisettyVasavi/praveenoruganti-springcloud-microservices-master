package com.praveen.jpa.hibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
public class JPQLTest {
	private Logger log= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public EntityManager em;
	
	@Test
	@DirtiesContext
	public void jpqlTest() {
		//Query q= em.createQuery("Select c from Course c");
		Query q= em.createNamedQuery("query_get_all_courses");
		log.info("Select c from Course c ->  {}",q.getResultList()); 
		//Output: Select c from Course c ->  [Course[CORE JAVA], Course[SPRING], Course[JPA HIBERNATE], Course[SQL in 25 Days], Course[Maven in 25 Days]]		
	}
	
	@Test
	@DirtiesContext
	public void jpqltypedTest() {
		//TypedQuery<Course> q= em.createQuery("Select c from Course c",Course.class);
		
		TypedQuery<Course>  q= em.createNamedQuery("query_get_all_courses",Course.class);
		List<Course> qlist=q.getResultList();
		log.info("Select c from Course c ->  {}",qlist);
		//Output: Select c from Course c ->  [Course[CORE JAVA], Course[SPRING], Course[JPA HIBERNATE], Course[SQL in 25 Days], Course[Maven in 25 Days]]		
	}
	
	@Test
	@DirtiesContext
	public void jpqlwhere() {
		//TypedQuery<Course> q= em.createQuery("Select c from Course c where name like '%25%' ",Course.class);
		TypedQuery<Course> q= em.createNamedQuery("query_get_like25",Course.class);
		List<Course> qlist=q.getResultList();
		log.info("Select c from Course c where name like '%25%' ->  {}",qlist);
		//Output: Select c from Course c where name like '%25%' ->  [Course[SQL in 25 Days], Course[Maven in 25 Days]]
		
	}
	
	
}
