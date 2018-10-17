package com.training.entity;

public class Insurance {

	private long insurance_id;
	private String car_no;
	private int coverage;
	public long getInsurance_id() {
		return insurance_id;
	}
	public void setInsurance_id(long insurance_id) {
		this.insurance_id = insurance_id;
	}
	public String getCar_no() {
		return car_no;
	}
	public void setCar_no(String car_no) {
		this.car_no = car_no;
	}
	public int getCoverage() {
		return coverage;
	}
	public void setCoverage(int coverage) {
		this.coverage = coverage;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((car_no == null) ? 0 : car_no.hashCode());
		result = prime * result + (int) (insurance_id ^ (insurance_id >>> 32));
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
		Insurance other = (Insurance) obj;
		if (car_no == null) {
			if (other.car_no != null)
				return false;
		} else if (!car_no.equals(other.car_no))
			return false;
		if (insurance_id != other.insurance_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Insurance [insurance_id=" + insurance_id + ", car_no=" + car_no + ", coverage=" + coverage + "]";
	}
	public Insurance(long insurance_id, String car_no, int coverage) {
		super();
		this.insurance_id = insurance_id;
		this.car_no = car_no;
		this.coverage = coverage;
	}
	public Insurance() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
