package com.training.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Rentals {
	//private HashMap<Long,Customer> custDetails=new HashMap<>();
	private HashSet<Items> items=new HashSet<>();
	private HashSet<Customer> customers=new HashSet<>();
	/*private void utility(ArrayList<Customer> cust){
		for(Customer c:cust){
			this.custDetails.put(c.getId(), c);
		}
	}*/
	
	public Rentals(){
		//init();
	}
	
	public void init(){
		retrieveCustomers();
		retrieveItems();
	}
	
	public void printDetails(){
		System.out.println(customers);
	}
	public boolean writeToTextFile(Items item,boolean append){
		boolean status=false;
		
		PrintWriter writer =null;
		
		try {
			writer=new PrintWriter(new FileWriter(new File("Items.txt"),append));
			writer.write(item.toString());
			status=true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			writer.close();
		}
		
		return status;
	}
	
	public HashSet<Items> readFromTextFile(File file){
		HashSet<Items> itemsList=new HashSet<>();
		
		BufferedReader reader=null;
		
		try {
			reader=new BufferedReader(new FileReader(file));
			String custAsString;
			while((custAsString=reader.readLine())!=null){
				String[] items=custAsString.split(",");
				Items it=new Items(Long.parseLong(items[0]),items[1],Double.parseDouble(items[2]));
				itemsList.add(it);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return itemsList;
	}
	public Customer getCustObject(long CustomerId){
		for(Customer c:customers){
			if(c.getId()==CustomerId){
				return c;
			}
		}
		return null;
	}
	
	public Items getItemObject(long itemId){
		for(Items it:items){
			if(it.getItemId()==itemId){
				return it;
			}
		}
		return null;
	}
	
	/*public void rent(long orderId,long CustomerId, String itemType,int qty){
		Customer c=getCustObject(CustomerId);
		if(c==null){
			System.err.println("Customer Doesn't Exist, Please add Customer First");
			return;
		}
		Items i=getItemObject(itemType);
		if(i==null){
			System.err.println("No such Item Exists");
			return;
		}
		List<Order> ord=c.getOrders();
		
		
	}*/
	public double rent(long orderId,Customer cust,HashMap<Items,Integer> itemsList){
		double total=0.0;
		if(customers.contains(cust)){
			List<Order> orderList=cust.getOrders();
			Order order=new Order(orderId,itemsList);
			orderList.add(order);
			cust.setOrders(orderList);
			for(Items i:itemsList.keySet()){
				double amt=i.getPrice()*itemsList.get(i)*i.getDays_rented();
				if(i.getDays_rented()>=5){
					total+=amt*0.9;
				}
				else{
					total+=amt;
				}
			}
		}
		else{
			System.err.println("Customer Doesn't Exist, Please add Customer First");
		}
		storeCustomers(false);
		retrieveCustomers();
		return total;
	}
	
	
	
	
	public void retrieveItems(){
		this.items=readFromTextFile(new File("Items.txt"));
	}
	
	public HashSet<Customer> loadCustomers(){
		HashSet<Customer> cust=new HashSet<>();
		Object obj=null;
		ObjectInputStream inputStream=null;
		try {
			inputStream=new ObjectInputStream(new FileInputStream("customer.ser"));
			while((obj=inputStream.readObject())!=null){
				cust.add((Customer)obj);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cust;
	}
	
	public void retrieveCustomers(){
		this.customers=loadCustomers();
	}
	
	public void printItems(){
		retrieveItems();
		for(Items i:items){
			System.out.println(i.toString());
		}
	}
	
	public boolean saveObject(HashSet<Customer> objList, boolean append){
		
		boolean status = false;
		ObjectOutputStream outStream=null;
		try {
			outStream=new ObjectOutputStream(new FileOutputStream(new File("customer.ser"),append));
			for(Object obj:objList){
				outStream.writeObject(obj);
			}
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//System.out.println(status);
		return status;
	}
	
	public void storeCustomers(boolean a){
		saveObject(this.customers,a);
	}
	
	public void storeCustomer(long customerId, String name,long contact){
		Customer c=new Customer(customerId,name,contact,new ArrayList<Order>());
		this.customers.add(c);
		storeCustomers(true);
	}
	
	public void storeCustomer(Customer cust){
		this.customers.add(cust);
		storeCustomers(false);
	}
	
	public boolean storeItem(Items item){
		this.items.add(item);
		return writeToTextFile(item,true);
	}
	
	public boolean storeItem(long id,String type,double price){
		Items item=new Items(id,type,price);
		this.items.add(item);
		return writeToTextFile(item,true);
	}
	
	public void printOrderDetails(long Id){
		if(getCustObject(Id)!=null){
			System.out.println(getCustObject(Id).toString());
		}
		else{
			System.err.println("No such customer");
		}
	}
	public void printAllOrders(){
		//retrieveCustomers();
		for(Customer c:customers){
			System.out.println(c.toString());
		}
	}
}
