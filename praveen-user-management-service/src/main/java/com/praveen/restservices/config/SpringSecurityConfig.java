package com.praveen.restservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	// Authentication based on role
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		       .withUser("praveen")
		       .password("pcfadmin")
		       .roles("ADMIN")
			   .and()
			   .withUser("prasad")
			   .password("pcfuser")
			   .roles("USER");
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	// Authorization based on role
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			   .antMatchers("/rest/hello/getMsg/admin").hasRole("ADMIN")
			   .antMatchers("/rest/hello/getMsg/user").hasAnyRole("USER","ADMIN")
		       .antMatchers("/").permitAll()		       
		       .and().formLogin();
	}

}
