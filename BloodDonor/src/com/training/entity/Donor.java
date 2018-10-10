package com.training.entity;


public class Donor {

	private long id;
	private String name;
	private String bloodGroup;
	private String location;
	private String gender;
	private int timesDonated;
	private long phNumber;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Donor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getTimesDonated() {
		return timesDonated;
	}
	public void setTimesDonated(int timesDonated) {
		this.timesDonated = timesDonated;
	}
	public long getPhNumber() {
		return phNumber;
	}
	public void setPhNumber(long phNumber) {
		this.phNumber = phNumber;
	}
	@Override
	public String toString() {
		return "Donor [id=" + id + ", name=" + name + ", bloodGroup=" + bloodGroup + ", location=" + location
				+ ", gender=" + gender + ", timesDonated=" + timesDonated + ", phNumber=" + phNumber + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Donor other = (Donor) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public Donor(long id, String name, String bloodGroup, String location, String gender, int timesDonated,
			long phNumber) {
		super();
		this.id = id;
		this.name = name;
		this.bloodGroup = bloodGroup;
		this.location = location;
		this.gender = gender;
		this.timesDonated = timesDonated;
		this.phNumber = phNumber;
	}
	
	
	
}
