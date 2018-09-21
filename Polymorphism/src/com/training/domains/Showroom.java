package com.training.domains;
import java.util.*;
import com.training.ifaces.IAutomobile;

public class Showroom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuoteManager quote=new UpdatedQuoteManager();
		Scanner s=new Scanner(System.in);
		String choice="y";
		do{
			System.out.println("Enterthe value for key");
		int key=s.nextInt();
		
		IAutomobile auto=quote.getModel(key);
		
		quote.printQuote(auto);
		System.out.println("y to continue n for exit");
		choice=s.next();
		}while(choice.equals("y"));
		s.close();
	}

}
