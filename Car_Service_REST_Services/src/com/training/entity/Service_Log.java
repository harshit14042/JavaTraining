package com.training.entity;

public class Service_Log {
	private long sid;
	private String car_no;
	private String service_date;
	private String delivery_date;
	private int net_amount;
	private long serviceid;
	public long getSid() {
		return sid;
	}
	public void setSid(long sid) {
		this.sid = sid;
	}
	public String getCar_no() {
		return car_no;
	}
	public void setCar_no(String car_no) {
		this.car_no = car_no;
	}
	public String getService_date() {
		return service_date;
	}
	public void setService_date(String service_date) {
		this.service_date = service_date;
	}
	public String getDelivery_date() {
		return delivery_date;
	}
	public void setDelivery_date(String delivery_date) {
		this.delivery_date = delivery_date;
	}
	public int getNet_amount() {
		return net_amount;
	}
	public void setNet_amount(int net_amount) {
		this.net_amount = net_amount;
	}
	public long getServiceid() {
		return serviceid;
	}
	public void setServiceid(long serviceid) {
		this.serviceid = serviceid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((car_no == null) ? 0 : car_no.hashCode());
		result = prime * result + ((delivery_date == null) ? 0 : delivery_date.hashCode());
		
		result = prime * result + net_amount;
		result = prime * result + ((service_date == null) ? 0 : service_date.hashCode());
		result = prime * result + (int) (serviceid ^ (serviceid >>> 32));
		result = prime * result + (int) (sid ^ (sid >>> 32));
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
		Service_Log other = (Service_Log) obj;
		if (car_no == null) {
			if (other.car_no != null)
				return false;
		} else if (!car_no.equals(other.car_no))
			return false;
		if (delivery_date == null) {
			if (other.delivery_date != null)
				return false;
		} else if (!delivery_date.equals(other.delivery_date))
			return false;
		if (net_amount != other.net_amount)
			return false;
		if (service_date == null) {
			if (other.service_date != null)
				return false;
		} else if (!service_date.equals(other.service_date))
			return false;
		if (serviceid != other.serviceid)
			return false;
		if (sid != other.sid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Service_Log [sid=" + sid + ", car_no=" + car_no + ", service_date=" + service_date + ", delivery_date="
				+ delivery_date + ", net_amount=" + net_amount + " serviceid=" + serviceid + "]";
	}
	public Service_Log(long sid, String car_no, String service_date, String delivery_date, int net_amount,
			 long serviceid) {
		super();
		this.sid = sid;
		this.car_no = car_no;
		this.service_date = service_date;
		this.delivery_date = delivery_date;
		this.net_amount = net_amount;
		this.serviceid = serviceid;
	}
	public Service_Log() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
