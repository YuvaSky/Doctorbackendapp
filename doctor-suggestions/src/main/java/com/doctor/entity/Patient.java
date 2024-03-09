package com.doctor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Patient {

	@Id
	@GeneratedValue(generator = "pat_seq")
	@SequenceGenerator(name = "pat_seq",initialValue = 11111,allocationSize = 1)
	private int pid;
	@NotEmpty(message ="Name is required")
	@Pattern(regexp ="^[a-zA-Z' '{3,}$",message = "Name can have only alphabets and space and min three characters")
	private String name;
	@NotEmpty(message ="City is required")
	@Size(max = 3,message ="Maximum 20 character are allowed")
	private String city;
	@NotEmpty(message ="Phone number is required")
	@Pattern(regexp = "[0-9]*",message = "Only digits are allowed in phone number")
	private String phone;
	@Email
	@NotEmpty(message = "Email is required")
	private String email;
	@Pattern(regexp ="Arthitis|Backpain|Tissue Injuries|Dysmenorrhea|Skin infection|Ear pain",message ="Invalid sympton")
	private String sympton;
	
}
