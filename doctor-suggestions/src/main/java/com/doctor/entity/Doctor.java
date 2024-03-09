package com.doctor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Doctor {
	
	@Id
	@GeneratedValue(generator = "doc_seq")
	@SequenceGenerator(name="doc_seq",initialValue = 101,allocationSize = 1)
	private int docid;
	@NotEmpty(message = "Name is required")
	//@Size(min = 3,message = "Name should have atleadt three character")
	@Pattern(regexp = "^[a-zA-Z' ']{3,}$",message = "Name can have only alphabets and space and min three characters")
	private String name;
	@NotEmpty(message = "City is required")
	@Pattern(regexp ="Noida|Delhi|Faridabad",message ="City must be either Noida or Delhi or Faridabad")
	private String city;
	@NotEmpty(message = "Phone is required")
	//@Pattern(regexp="^[0-9]{10,10}$",message ="phone number is invalid")
	@Pattern(regexp = "[0-9]*",message = "Only digits are allowed in phone number")
	private String phone;
	@NotEmpty(message = "Email is required")
	@Email(message ="Email is invalid")
	private String email;
	@NotEmpty(message = "Speciality is required")
	@Pattern(regexp ="Orthopedic|Gynecology|Dermatology|ENT",message = "This speciality is not allowed")
	private String speciality;

}
