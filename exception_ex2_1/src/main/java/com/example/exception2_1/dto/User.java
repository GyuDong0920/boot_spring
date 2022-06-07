package com.example.exception2_1.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	
	@NotNull
	@Size(min = 2, max = 20)
	private String name;
	
	@Min(1)
	@NotNull
	private Integer age;
	
}