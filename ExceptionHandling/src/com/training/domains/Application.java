package com.training.domains;

public class Application {
	
	
	public static void handle(){
		try {
			Employee e=new Employee(-5, "John Doe");
		} catch (RangeCheckException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		
		
		/*Address addr_1=new Address("Flat No. 20","ACK","New Delhi",-110019);
		
		Address addr_2=new Address("India","Asia","World",10000);
		
		Customer customer_1=new Customer(101,"HV",addr_1,123456789);
		Customer customer_2=new Customer(101,"HV",addr_1,123456789);
		//customer_2=null;
		//System.gc();
		
		//Runtime.getRuntime().gc();
		
		
		System.out.println(customer_1.equals(customer_2));
		
		Customer c3=null;
		
		//Cautious of null Value
		System.out.println(customer_1.equals(c3));
		
		System.out.println(customer_1.getAddress().getPincode());
		
		Customer s=new Customer();
		
		try {
			s.getAddress().setPincode(-5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("Working");
		handle();
	}

}
