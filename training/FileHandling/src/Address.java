import java.io.Serializable;

public class Address implements Serializable{
	@Override
	public String toString() {
		return "Address [address_line1=" + address_line1 + ", address_line2=" + address_line2 + ", city=" + city
				+ ", pincode=" + pincode + "]";
	}
	private String address_line1;
	private String address_line2;
	private String city;
	private long pincode;
	public String getAddress_line1() {
		return address_line1;
	}
	public void setAddress_line1(String address_line1) {
		this.address_line1 = address_line1;
	}
	public String getAddress_line2() {
		return address_line2;
	}
	public void setAddress_line2(String address_line2) {
		this.address_line2 = address_line2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) throws Exception {
		if(pincode<0){
			throw new Exception("Pincode should be positive");
		}
		else{
			this.pincode = pincode;
		}
	}
	public Address(String address_line1, String address_line2, String city, long pincode) {
		super();
		this.address_line1 = address_line1;
		this.address_line2 = address_line2;
		this.city = city;
		if(pincode<0){
			try {
				throw new Exception("Pincode Must be Positive");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
		}
		else{
			this.pincode = pincode;
		}
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
}
