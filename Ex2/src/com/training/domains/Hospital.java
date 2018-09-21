package com.training.domains;

import java.util.*;

public class Hospital {
	private Set<Doctor> doctors=new HashSet<>();
	private Set<Patient> patients=new HashSet<>();
	private Map<Doctor,TreeSet<Patient>> appointments=new HashMap<Doctor,TreeSet<Patient>>();
	private Map<String,TreeSet<Doctor>> specialization=new HashMap<String,TreeSet<Doctor>>();
	
	@Override
	public String toString() {
		return "Hospital [doctors=" + doctors + ", patients=" + patients + ", appointments=" + appointments + "]";
	}
	
	private Doctor getDoctor(String doc){
		for(Doctor d:doctors){
			if(d.getName().equals(doc)){
				return d;
			}
		}
		return null;
	}
	
	private Patient getPatient(String pat){
		for(Patient p:patients){
			if(p.getName().equals(pat)){
				return p;
			}
		}
		return null;
	}

	

	public void addDoctor(Doctor doc){
		this.doctors.add(doc);
		TreeSet<Doctor> docs;
		if(this.specialization.containsKey(doc.getSpecialization())){
			docs=this.specialization.get(doc.getSpecialization());
		}
		else{
			docs=new TreeSet<Doctor>();
		}
		docs.add(doc);
		this.specialization.put(doc.getSpecialization(), docs);
	}
	
	public Map<String, TreeSet<Doctor>> getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Map<String, TreeSet<Doctor>> specialization) {
		this.specialization = specialization;
	}

	public void addPatient(Patient patient){
		this.patients.add(patient);
	}
	
	public void cancelAppointment(Doctor doc, Patient pat){
		TreeSet<Patient> patients_doc;
		if(this.appointments.containsKey(doc)){
			patients_doc=this.appointments.get(doc);
			patients_doc.remove(pat);
			this.appointments.put(doc, patients_doc);
		}
		
	}
	
	public void cancelAppointment(String doc, String pat){
		TreeSet<Patient> patients_doc;
		
		Doctor d=getDoctor(doc);
		Patient p=getPatient(pat);
		if(d==null){
			System.err.println("No Doctor with name "+doc+" found");
			return;
		}
		if(p==null){
			System.err.println("No Patient with name "+pat+" found");
			return;
		}
		cancelAppointment(d, p);		
	}
	
	
	
	
	
	public void addAppointment(Doctor doc, Patient pat){
		TreeSet<Patient> patients_doc;
		if(this.appointments.containsKey(doc)){
			patients_doc=this.appointments.get(doc);
		}
		else{
			patients_doc=new TreeSet<Patient>();
		}
		patients_doc.add(pat);
		this.appointments.put(doc, patients_doc);
	}
	
	public void addAppointment(String doc, String pat){
		TreeSet<Patient> patients_doc;
		
		Doctor d=getDoctor(doc);
		Patient p=getPatient(pat);
		if(d==null){
			System.err.println("No Doctor with name "+doc+" found");
			return;
		}
		if(p==null){
			System.err.println("No Patient with name "+pat+" found");
			return;
		}
		addAppointment(d, p);		
	}
	
	public Set<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}

	public Set<Patient> getPatients() {
		return patients;
	}

	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}

	public Map<Doctor, TreeSet<Patient>> getAppointments() {
		return appointments;
	}

	public void setAppointments(Map<Doctor, TreeSet<Patient>> appointments) {
		this.appointments = appointments;
	}

	public Hospital(Set<Doctor> doctors, Set<Patient> patients, Map<Doctor, TreeSet<Patient>> appointments) {
		super();
		this.doctors = doctors;
		this.patients = patients;
		this.appointments = appointments;
	}

	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
