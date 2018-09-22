package com.training.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Application {
	static long orderId=1;
	static long customerId=1;
	static long ItemId=1;
	static Rentals rental;
	public static void init(){
		Customer c1=new Customer(customerId++,"Ramesh",65489723,new ArrayList<Order>());
		Customer c2=new Customer(customerId++,"Suresh",65489127,new ArrayList<Order>());
		Customer c3=new Customer(customerId++,"Mahesh",6548917,new ArrayList<Order>());

		
		Items it1=new Furniture(ItemId++);
		Items it2=new Car(ItemId++);
		Items it3=new Utensils(ItemId++);
		Items it4=new Fan(ItemId++);
		
		
		rental.storeCustomer(c1);
		rental.storeCustomer(c2);
		rental.storeCustomer(c3);
		
		rental.storeItem(it1);
		rental.storeItem(it2);
		rental.storeItem(it3);
		rental.storeItem(it4);
	}
	
	public static void main(String[] args) {
		rental=new Rentals();
		init();
		Scanner s=new Scanner(System.in);
		String choice="y";
		int option=0;
		while(option<=5){
			System.out.println("Press 1 to Rent\nPress 2 to Print Details of a particular Customer\nPress 3 to print details of all the customers\nPress 4 to add new Item\nPress 5 to add new Customer\n6 to Exit");
			option=s.nextInt();
			switch(option){
			case 1:
				do{
					System.out.println("Enter the Customer Id");
					long customerId=s.nextLong();
					Customer customer=rental.getCustObject(customerId);
					HashMap<Items,Integer> its=new HashMap<>();
					String more="y";
					do{
						rental.printItems();
						System.out.println("Enter the Items type to rent");
						long itemId=s.nextLong();
						System.out.println("Enter the Days you want to add");
						int no_days=s.nextInt();
						Items item=rental.getItemObject(itemId);
						item.setDays_rented(no_days);
						System.out.println("Enter the quantity");
						int qty=s.nextInt();
						if(its.containsKey(item)){
							System.out.println("Contains");
							its.put(item, its.get(item)+qty);
						}
						else{
							its.put(item, qty);
						}
						System.out.println("Do you want to add more items?\nPress 'y' for yes and 'n' for no.");
						more=s.next();
					}while(more.equals("y"));
					System.out.println(rental.rent(orderId++, customer, its));
					System.out.println("Do you want to add more orders?\nPress 'y' for yes and 'n' for no.");
					choice=s.next();
				}while(choice.equals("y"));
				break;
			case 2:
				System.out.println("Enter the Id of the customer");
				long cId=s.nextLong();
				rental.printOrderDetails(cId);
				break;
			case 3:
				rental.printAllOrders();
				break;
			case 4:
				System.out.println("Enter the Following Details");
				System.out.print("Price: ");
				double price=s.nextDouble();
				System.out.print("Type: ");
				String type=s.next();
				rental.storeItem(ItemId++, type, price);
				break;
			case 5:
				System.out.println("Enter the Following Details");
				System.out.print("Name: ");
				String name=s.next();
				System.out.print("Contact: ");
				long contact=s.nextLong();
				rental.storeCustomer(customerId++, name, contact);
				break;
			default:
				break;
			}
		}
	}

}
