package com.training.domain;

public class Outer {
	public void show(String[] data,String condition){
		filter obj=new filter(){

			@Override
			public String filter(String[] data, String condition) {
				return data[0];
			}
			
		};
		System.out.println(obj.filter(data, condition));
	}
	public static void main(String[] args){
		Outer out=new Outer();
		String[] data={"1","2"};
		out.show(data, "");
	}
}
