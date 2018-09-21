package com.training.domains;

public class Calculate implements Runnable {

	private int count;
	
	public Calculate(int count) {
		super();
		this.count = count;
	}

	private long fact(long n){
		if(n==1){
			return n;
		}
		return n*fact(n-1);
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		// TODO Auto-generated method stub
		
		System.out.println(fact(count));
		System.out.println("Bye");
	}
	
	public static void main(String[] args){
		System.out.println(Thread.currentThread().getName());
		Calculate cal=new Calculate(5);
		Thread thread=new Thread(cal);
		
		thread.setName("5 Fact");
		thread.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Calculate fourFact=new Calculate(4);
		
		Thread thread2=new Thread(fourFact,"Four Fact");
		
		thread2.start();
	}

}
