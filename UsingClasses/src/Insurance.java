
public abstract class Insurance {
	private long policyNumber;
	private String policyHolderName;
	
	
	
	
	public long getPolicyNumber() {
		return policyNumber;
	}



	public void setPolicyNumber(long policyNumber) {
		this.policyNumber = policyNumber;
	}



	public String getPolicyHolderName() {
		return policyHolderName;
	}



	public void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName = policyHolderName;
	}



	public Insurance(long policyNumber, String policyHolderName) {
		super();
		this.policyNumber = policyNumber;
		this.policyHolderName = policyHolderName;
	}



	public abstract double claculatePremium();
}
