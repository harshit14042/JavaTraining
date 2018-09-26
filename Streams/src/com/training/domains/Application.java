package com.training.domains;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Application {

	public static void main(String[] args) {
		
		Product sonyTV = new Product(101,"Sony","tv",40000);
		Product samsungTV = new Product(102,"Samsung","tv",55000);
		Product hitachiTV = new Product(103,"Hitachi","tv",60000);
		
		
		
		Product lg = new Product(201,"LG Refigeration","Fridge",30000);
		Product samsung= new Product(202,"Samsung Refigeration","Fridge",20000);
		Product haeir = new Product(203,"Haeir","Fridge",10000);
		
		
		List<Product> prdList = new ArrayList<>();
		
		prdList.add(sonyTV);
		prdList.add(samsungTV);
		prdList.add(hitachiTV);
		prdList.add(lg);
		prdList.add(samsung);
		prdList.add(haeir);
		
		
		ManageProducts mgr = new ManageProducts();
		
//		mgr.printProductByCategory("tv", prdList);
//		
//		mgr.printProductNames(prdList);
//		
//		mgr.printCategory(prdList);
		
//		mgr.printSortedList(prdList);
//		
//		System.out.println(mgr.countProducts(prdList));
//		
//		System.out.println(mgr.findMinpriceProduct(prdList));
//		
//		
//		System.out.println(mgr.findMaxPriceProduct(prdList));
		
//		System.out.println(mgr.findMinMax(prdList, true));
		
//		System.out.println(mgr.findMinMax(prdList, false));
		
//		Map<String,Double> priceList = mgr.getPriceList(prdList);
//		
//		System.out.println(priceList.get("Samsung"));
//		
//		Set<Map.Entry<String,Double>> items = priceList.entrySet();
//		
//		for(Map.Entry<String, Double>eachitem:items){
//			System.out.println(eachitem.getKey());
//			System.out.println(eachitem.getValue());
//		}
//		
		
		System.out.println(mgr.maxAmount(prdList));
		
		System.out.println("Hello");
		
		System.out.println("Hello");
		
	}
}
