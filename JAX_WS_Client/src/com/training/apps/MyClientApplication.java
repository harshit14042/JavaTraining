package com.training.apps;

import javax.xml.ws.Response;

import com.training.ifaces.BloodDonor;
import com.training.ifaces.GetRequestResponse;

import examples.webservices.async.DonationRequest;
import examples.webservices.async.DonationRequestServiceService;

public class MyClientApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*CurrencyConverterImplService conv=new CurrencyConverterImplService();
		
		CurrencyConverter proxy=conv.getCurrencyConverterImplPort();
		
		System.out.println(proxy.dolorToRupees(100));*/
		
		DonationRequestServiceService conv=new DonationRequestServiceService();
		
		DonationRequest proxy=conv.getDonationRequestServicePort();
		
		//System.out.println(proxy.getRequest("apos"));
		Response res=proxy.getRequestAsync("apos");
		
		while(!res.isDone())
		{
			try {
				System.out.println("Waiting");
				
				//Thread.sleep(2000);
				
				Thread t=new Thread(){
					public void run(){
						for(int i=0;i<100;i++){
							System.out.println(i);
						}
					}
				};
				t.start();
				t.join(1000);
				GetRequestResponse resp=(GetRequestResponse) res.get();
				//BloodDonor b=resp.getReturn();
				System.out.println(resp.getReturn());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
//		System.out.println("Waiting");
//		while(!res.isDone());
//		try {
//			
//			GetRequestResponse resp=(GetRequestResponse) res.get();
//			//BloodDonor b=resp.getReturn();
//			System.out.println(resp.getReturn());
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
	}

}
