package com.praveen.restservices.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Entity 
//and
@ApiModel(description = "This model is to create a user")
@Entity
@Table(name = "user")
//@JsonIgnoreProperties({"firstname", "lastname"})  -- Static Filtering @JsonIgnore
//@JsonFilter(value = "userFilter")  -- Used for MappingJacksonValue filtering section
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User extends ResourceSupport {

	@ApiModelProperty(notes = " Auto generated unique id", required = true, position = 1)
	@Id
	@GeneratedValue
	@JsonView(Views.External.class)
	private Long userid;
	
	@ApiModelProperty(notes = "username should be in format flname", example = "PraveenOruganti", required = false, position = 2)
	@Size(min = 2, max = 50)
	@NotEmpty(message = "Username is Mandatory field. Please provide username")
	@Column(name = "USER_NAME", length = 50, nullable = false, unique = true)
	@JsonView(Views.External.class)
	private String username;

	@Size(min = 2, max = 50,  message = "FirstName should have atleast 2 characters")
	@Column(name = "FIRST_NAME", length = 50, nullable = false)
	@JsonView(Views.External.class)
	private String firstname;

	@Column(name = "LAST_NAME", length = 50, nullable = false)
	@JsonView(Views.External.class)
	private String lastname;

	@Column(name = "EMAIL_ADDRESS", length = 50, nullable = false)
	@JsonView(Views.External.class)
	private String email;

	@Column(name = "ROLE", length = 50, nullable = false)
	@JsonView(Views.Internal.class)
	private String role;

	@Column(name = "SSN", length = 50, nullable = false, unique = true)
	//@JsonIgnore -- Static Filtering @JsonIgnore
	@JsonView(Views.Internal.class)
	private String ssn;
	
	@Column(name = "ADDRESS")
	private String address;
	
	

}