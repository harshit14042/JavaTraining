import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 006L;
	@Override
	public String toString() {
		return customerId + "," + customerName + "," + mobileNumber;
	}
	public Customer(long customerId, String customerName, long mobileNumber) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
	}
	private long customerId;
	private String customerName;
	private Address address;
	private transient long mobileNumber;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(long customerId, String customerName, Address address, long mobileNumber) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.address = address;
		this.mobileNumber = mobileNumber;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		//return super.equals(obj);
		if(this==obj){
			return true;
		}
		if(obj==null){
			return false;
		}
		if(this.getClass()!=obj.getClass()){
			return false;
		}
		Customer cst=(Customer)obj;
		return this.customerId==cst.customerId && this.customerName.equals(cst.customerName)?true:false;
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("One custom Object "+this.customerId);
	}
	
	private void readObject(ObjectInputStream in){
		try {
			in.defaultReadObject();
			this.mobileNumber=(long)in.readObject();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void writeObject(ObjectOutputStream out){
		try {
			out.defaultWriteObject();
			out.writeObject(mobileNumber);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
