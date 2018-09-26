package com.training;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

	
	public static <T> T showNUmbers(List<T> numList){
		
		return numList.get(2);
	}
	
	//Generic Method Type 2
	public static void print(List<?> list){
		
		list.forEach(System.out::println);
	}
	
	//Generic Method Type 3 Producer
	public static void printList(List<? extends Number> list){
		list.forEach(System.out::println);
	}
	
	//Generic Method Type 3 Consumer
	public static void addToList(List<? super Integer> list){
			list.add(7);
		//list.add(7); Cant add in wildcards as we don't have the complete knowledge of the class object that is going to be added.
	}
	
	public static void main(String[] args) {
		//Generic Method Type 1
		
		
		
		AddNumber<Double,String> marks=new AddNumber<>();
		marks.setDigit(23.5);
		marks.addObject("Ramesh");
		
		AddNumber<Integer,String> age=new AddNumber<>();
		age.setDigit(5);
		age.addObject("Suresh");
		
		System.out.println(age.getDigit()+" "+age.getList());
		System.out.println(marks.getDigit()+" "+marks.getList());
		
		
		List<Integer> intMarkList=Arrays.asList(1,2,3,4,5);
		
		List<Double> doubleMarkList=Arrays.asList(1.0,2.0,3.0,4.0,5.5);
		
		System.out.println(showNUmbers(doubleMarkList));
		
		List<Object> stuList=Arrays.asList(new Boolean(false),new Boolean(true),new Boolean(false));
		
		/*print(stuList);
		
		printList(intMarkList);
		
		printList(doubleMarkList);
		
		addToList(stuList);
		
		print(stuList);
		
		System.out.println(stuList.get(0).getClass());
		addToList(intMarkList);
		printList(intMarkList);*/
		
		ArrayList<Integer> arr=new ArrayList<>();
		arr.add(5);
		arr.add(6);
		addToList(arr);
		print(arr);
	}
}
