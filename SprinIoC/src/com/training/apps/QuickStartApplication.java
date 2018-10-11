package com.training.apps;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.beans.Invoice;

public class QuickStartApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BeanFactory fact=new ClassPathXmlApplicationContext("context.xml");
		
		Invoice inv=fact.getBean("invBean",Invoice.class);
		
		/*Invoice inv2=fact.getBean("invBean",Invoice.class);
		
		System.out.println(inv.hashCode()+" "+inv2.hashCode());*/
		
		System.out.println(inv);
		
		Invoice inv2=fact.getBean("contructorBean",Invoice.class);
		System.out.println(inv2);
	}

}
