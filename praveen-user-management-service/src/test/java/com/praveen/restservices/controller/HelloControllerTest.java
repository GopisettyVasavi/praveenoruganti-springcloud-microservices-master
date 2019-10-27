package com.praveen.restservices.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.praveen.restservices.model.User1;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@SpringBootTest
public class HelloControllerTest {

	@Autowired
	private HelloController helloController;

	@Test
	public void testGreetingBean() {
		User1 user1 = helloController.greetingBean();
		assertEquals(user1.getUserEmail(), "praveenoruganti@gmail.com");
		assertEquals(user1.getAddress(), "Hyderabad");
		assertEquals(user1.getUserId(), Integer.valueOf(149903));
		assertEquals(user1.getUserName(), "PraveenOruganti");
	}

	@Test
	public void testGreeting() {
		String result = helloController.greeting();
		assertEquals(result, "praveen-user-management-service Welcome To Praveen Oruganti Forum !!");

	}
}

