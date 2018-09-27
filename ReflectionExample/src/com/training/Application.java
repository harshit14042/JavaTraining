package com.training;

import java.lang.reflect.*;

public class Application {

	public static void main(String[] args) {
		
		try {
			
			Class<?> cls=Class.forName("com.training.Movie");
			Movie diamond=(Movie)cls.newInstance();
			
			diamond.setMovieName("Titanic");
			diamond.setMovieId(101);
			
			System.out.println(diamond);
			
			Constructor<?>[] cons=cls.getDeclaredConstructors();
			
			for(Constructor<?> c:cons){
				System.out.println(c.getName()+" "+c.getParameterCount());
			}
			
			Method addRatingMethod=cls.getDeclaredMethod("addRating", int.class);
			System.out.println("Add Rating Method Reference"+addRatingMethod);
			String result=(String)addRatingMethod.invoke(diamond,new Integer(5));
			System.out.println(diamond);
			
			/*
			
			Method[] methodList=cls.getDeclaredMethods();
			
			
			for(Method m:methodList){
				System.out.println(m.getName());
				System.out.println(m.getReturnType());
				System.out.println(m.getParameterTypes());
				
				Class[] types=m.getParameterTypes();
				for(Class param:types){
					System.out.println(param.getName());
				}
			}*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
