package com.example.demo4.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * 
 * {
 * 
 * "name" : "kkk",
 * "age " : 30,
 * "phoneNumber" : "010-10234-1234
 * "address" : "부산시 해운대구 우동"
 * 
 * }
 * 
 *
 */
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL) // null 값을 내려 주지 않고 싶을 때 사용한다.
public class User {
		
	private String name;
	private int age;
	private String phonNumber;
	private String address;
	private String idNumber;
	
	
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getPhonNumber() {
		return phonNumber;
	}
	public String getAddress() {
		return address;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setPhonNumber(String phonNumber) {
		this.phonNumber = phonNumber;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", phonNumber=" + phonNumber + ", address=" + address + "]";
	}
	
	
	
	
}
