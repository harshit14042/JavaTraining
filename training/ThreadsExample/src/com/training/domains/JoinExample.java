package com.training.domains;

import java.io.IOException;

public class JoinExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main Started");
		System.out.println(Thread.currentThread().getName());
		Thread thread=new Thread(){
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(Thread.currentThread().getName());
				System.out.println("Reading");
				
				try {
					System.in.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("Finished Reading");
			}
			
		};
		
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName());
		System.out.println("Main Finished");
	}

}
