package com.training.apps;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.training.beans.AppContext;
import com.training.beans.Teacher;

public class JavaConfigApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BeanFactory ctx=new AnnotationConfigApplicationContext(AppContext.class);
			Teacher teacher=ctx.getBean("teacher",Teacher.class);
			System.out.println(teacher);
			
			teacher=ctx.getBean("getTeacher",Teacher.class);
			System.out.println(teacher);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
