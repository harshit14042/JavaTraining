package com.training;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.google.gson.Gson;

public class Application {

	public static void main(String[] args) {
		
		Gson obj = new Gson();
		
		BasicConfigurator.configure();
		
		Logger log = Logger.getRootLogger();
		
		
		Movie diamond = new Movie(101,"Diamond");
		
	
		String jsonRep = obj.toJson(diamond);
		
		System.out.println(jsonRep);
		
		Movie captured = obj.fromJson(jsonRep, Movie.class);
		
		System.out.println(captured);
		
		
		
	}

}
