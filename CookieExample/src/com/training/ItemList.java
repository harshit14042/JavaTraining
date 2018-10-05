package com.training;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemList {

	public static Map<String,List<String>> getItems(){
		List<String> books=Arrays.asList("Sherlock","Bond");
		List<String> fashion=Arrays.asList("Lipstick","Kajal");
		List<String> textiles=Arrays.asList("Casual Wear","Party Wear");
		List<String> electronics=Arrays.asList("Laptop","Mobile");
		
		Map<String,List<String>> items=new HashMap<>();
		
		items.put("Books", books);
		items.put("Textiles", textiles);
		items.put("Electronics", electronics);
		items.put("Fashion", fashion);
		
		return items;
		
	}
	
}
