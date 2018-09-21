
public class VehicleInsurance extends Insurance {

	private String VehicleType;
	private int yearOfManufacturate;


	


	public VehicleInsurance(long policyNumber, String policyHolderName, String vehicleType, int yearOfManufacturate) {
		super(policyNumber, policyHolderName);
		VehicleType = vehicleType;
		this.yearOfManufacturate = yearOfManufacturate;
	}





	@Override
	public double claculatePremium() {
		// TODO Auto-generated method stub
		double premium=0.0;
		if(this.VehicleType.equals("bike")){
			switch(this.yearOfManufacturate){
			case 2017:
				premium = 200;
				break;
			case 2016:
				premium=500;
				break;
			default:
				premium=400;
			}
		}
		else{
			switch(this.yearOfManufacturate){
			case 2017:
				premium = 600;
				break;
			case 2016:
				premium=700;
				break;
			default:
				premium=500;
			}
		}
		return premium;
	}

}