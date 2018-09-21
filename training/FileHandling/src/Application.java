import java.io.File;
import java.util.List;

public class Application {

	public static void main(String[] args) {

		Address addr_1=new Address("Flat No. 20","ACK","New Delhi",110019);
		
		//Address addr_2=new Address("India","Asia","World",10000);
		
		Customer customer_1=new Customer(101,"HV",addr_1,123456789);
		Customer customer_2=new Customer(101,"HV",addr_1,123456789);
		
		ObjectHandling objHandling=new ObjectHandling();
		boolean status=objHandling.saveObject(customer_1);
		
		if(status){
			System.out.println("SAVED SUCCESSFULLY");
		}
		else{
			System.err.println("Not Saved");
		}
		
		Customer obj=(Customer)objHandling.loadObject();
		
		System.out.println(obj);
		
		status=objHandling.writeToTextFile(customer_1);
		if(status){
			System.out.println("SAVED SUCCESSFULLY");
		}
		else{
			System.err.println("Not Saved");
		}
		
		List<Customer> custList=objHandling.readFromTextFile(new File("Customer.txt"));
		
		System.out.println(custList);
	}

}
