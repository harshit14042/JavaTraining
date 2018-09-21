
public class InsuranceAgent {
	//Params passing=>instead of supertype can pass subtype
	public static void findPremium(Insurance insurance){
		System.out.println(insurance.claculatePremium());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VehicleInsurance pulsarBike=new VehicleInsurance(879, "John Doe", "bike", 2017);
		//SuperClass = SubClass
		Insurance bmwCar=new VehicleInsurance(100, "Jane Doe", "Car", 2016);
		
		findPremium(pulsarBike);
		findPremium(bmwCar);
		
		LifeInsurance Ramesh=new LifeInsurance(500, "Ramesh", 23);
		
		findPremium(Ramesh);
		
	}
}
/*
Create a Class LifeInsurance based on age
*/