package com.training.apps;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.beans.Invoice;
import com.training.beans.Teacher;

public class QuickStartApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BeanFactory fact=new ClassPathXmlApplicationContext("context.xml");
		
		//Invoice inv=fact.getBean("invBean",Invoice.class);
		
		/*Invoice inv2=fact.getBean("invBean",Invoice.class);
		
		System.out.println(inv.hashCode()+" "+inv2.hashCode());*/
		
		//System.out.println(inv.totalAmount());
		
		/*Invoice inv2=fact.getBean("contructorBean",Invoice.class);
		System.out.println(inv2.totalAmount());*/
		
		
		Teacher teacher=fact.getBean("teacher", Teacher.class);
		System.out.println(teacher.getTeacherName()+" "+teacher.getStudent().getStudentName());
		
		/*teacher=fact.getBean("teacherEx2", Teacher.class);
		System.out.println(teacher.getTeacherName()+" "+teacher.getStudent().getStudentName());*/
	}

}
