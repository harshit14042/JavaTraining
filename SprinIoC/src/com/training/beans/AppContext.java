package com.training.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages="com.training.beans")
public class AppContext {

	@Bean
	public Teacher getTeacher() {
		return new Teacher();
	}
	
	
	@Bean
	public Student getStudent() {
		return new Student();
	}
}
