package com.example.filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan // WebFilter 사용시 작성해주어야함
public class FilterExApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilterExApplication.class, args);
	}

}
