package com.training;

public class Application {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BloodDonor obj=new BloodDonor();
		obj.setAge(31);
		obj.setName("Messi");
		System.out.println(obj.getAge());
		System.out.println(obj.getName());
		
		BloodDonor Rahul=new BloodDonor("Rajesh","Male",50,"O+");
		System.out.println(Rahul.toString());
		
		//Doctor doc=new Doctor("Rajesh","Eyes",32,"M.B.B.S",8);
		Doctor doc=new Doctor();
		doc.setName(args[0]);
		doc.setLocation(args[1]);
		System.out.println(doc.getName()+" "+doc.getLocation());
	}
}