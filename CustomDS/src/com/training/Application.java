package com.training;

import java.util.Iterator;

public class Application {

	public static void main(String[] args) {
		MyArrayList<String> arr=new MyArrayList<String>();
		System.out.println(arr.toString());
		for(int i=0;i<=10;i++){
			arr.addElement(i+1);
		}
		
		System.out.println(arr.toString());
		
		arr.removeElement(2);
		
		System.out.println(arr.toString());
		
		arr.removeElement(2);
		
		System.out.println(arr.toString());
		
		Iterator it=arr.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		Iterator it1=arr.iterator();
		
		while(it1.hasNext()){
			System.out.println(it1.next());
		}
	}

}
