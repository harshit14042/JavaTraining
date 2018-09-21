package com.training.domains;

import java.util.Scanner;

//import java.util.*;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hospital hospital=new Hospital();
		
		Doctor doc1=new Doctor("Ramesh","ENT","Delhi");
		Doctor doc2=new Doctor("Suresh","Dental","Delhi");
		Doctor doc3=new Doctor("Mukesh","Dental","Bangalore");
		
		Patient patient1=new Patient("Harshit", 20, "4678");
		Patient patient2=new Patient("Hamaad", 23, "4689798");
		
		hospital.addDoctor(doc1);
		hospital.addDoctor(doc2);
		hospital.addDoctor(doc3);
		
		hospital.addPatient(patient1);
		hospital.addPatient(patient2);
		
		/*hospital.addAppointment(doc1, patient1);
		
		hospital.addAppointment(doc2, patient2);*/
		
		//Set<Doctor> docs=hospital.getAppointments().keySet();
		//System.out.println(hospital.getAppointments());
		/*for(Doctor doc:docs){
			System.out.println("Doctor: "+doc+" Patients: "+hospital.getAppointments().get(doc));
		}*/
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Doctor Name");
		String docName=s.next();
		System.out.println("Enter the Patient Name");
		String patName=s.next();
		hospital.addAppointment(docName, patName);
		hospital.addAppointment(doc2, patient2);
		System.out.println(hospital.getAppointments());
		
		System.out.println(hospital.getSpecialization());
		System.out.println("Enter the Doctor Name");
		docName=s.next();
		System.out.println("Enter the Patient Name");
		patName=s.next();
		hospital.cancelAppointment(docName, patName);
		System.out.println(hospital.getAppointments());
	}

}
