package com.training;

import java.util.Iterator;

public class Application {

	public static void main(String[] args) {
		MyArrayList arr=new MyArrayList();
		
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
	}

}
