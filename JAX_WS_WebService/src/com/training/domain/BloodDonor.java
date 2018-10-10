package com.training.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BloodDonor {

	
	@XmlAttribute
	private long id;
	
	@XmlElement
	private String name;
	
	@XmlElement
	private String bloodGroup;
	@XmlElement
	private String location;
	
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
	public BloodDonor() {
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
		BloodDonor other = (BloodDonor) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public BloodDonor(long id, String name, String bloodGroup, String location) {
		super();
		this.id = id;
		this.name = name;
		this.bloodGroup = bloodGroup;
		this.location = location;
	}
	@Override
	public String toString() {
		return "BloodDonor [id=" + id + ", name=" + name + ", bloodGroup=" + bloodGroup + ", location=" + location
				+ "]";
	}
	
	
	
}
