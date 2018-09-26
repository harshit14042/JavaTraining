package com.training.domains;

import java.util.*;
import java.util.stream.Collectors;

public class ManageProducts {

	
	public void printProductByCategory(String category,List<Product> prdList)
	{
		List<Product> catalog = prdList.stream().filter(eachProduct->eachProduct.getCategory().equals(category)).collect(Collectors.toList());
		
		catalog.forEach(System.out::println);
	}
	
	
	public void printProductNames(List<Product> prdList)
	{
		prdList.stream().map(product->product.getProductName()).forEach(System.out::println);
	}


	public void printCategory(List<Product> prdList)
	{
		prdList.stream().map(product->product.getCategory()).distinct().forEach(System.out::println);
	}

	
	
	
	public void printSortedList(List<Product> prdList)
	{
		
//		prdList.stream().sorted().forEach(System.out::println);
		
		prdList.stream().sorted(Comparator.comparing(Product::getratePerUnit)).forEach(System.out::println);
	
	}
	
	
	
	public Double findMaxPriceProduct(List<Product>prdList){
		Double maxPrice = 0.0;
		Optional<Product> prd =prdList.stream().max(Comparator.comparing(Product::getratePerUnit));
		
		if(prd.isPresent()){
			maxPrice = prd.get().getratePerUnit();
		}
		return maxPrice;
	}
	
	public double findMinpriceProduct(List<Product>prdList){
		
	Double minPrice = 0.0; 
	Optional<Product> prd =prdList.stream().min(Comparator.comparing(Product::getratePerUnit));
	
	if(prd.isPresent())
	{
		minPrice = prd.get().getratePerUnit();
	}
	 return minPrice;
	}
	
	public long countProducts(List<Product>prdList){
		
		long prodCount = prdList.stream().count();
		
		return prodCount;
	}
	
	
	public double findMinMax(List<Product> prdList,boolean mode){
		
		return mode==true?findMinpriceProduct(prdList):findMaxPriceProduct(prdList);
	}
	
	
	public Map<String,Double> getPriceList(List<Product>prdList){
		
	Map<String,Double> priceList =	prdList.stream().collect(Collectors.toMap(Product::getProductName, Product::getratePerUnit));
	 return priceList;
	}
	
	
	public double maxAmount(List<Product>prdList){
		Optional<Double> result = prdList.parallelStream().map(e->e.getratePerUnit()).reduce((p1,p2)->p1>p2?p1:p2);
		
		return result.get().doubleValue();
	}
	
}
