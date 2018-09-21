
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ObjectHandling {
	
	public boolean saveObject(Object obj){
		
		boolean status = false;
		ObjectOutputStream outStream=null;
		try {
			outStream=new ObjectOutputStream(new FileOutputStream(new File("customer.ser")));
			outStream.writeObject(obj);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return status;
	}
	
	public Object loadObject(){
		Object obj=null;
		ObjectInputStream inputStream=null;
		try {
			inputStream=new ObjectInputStream(new FileInputStream("customer.ser"));
			obj=inputStream.readObject();
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return obj;
	}
	
	public boolean writeToTextFile(Customer cust){
		boolean status=false;
		
		PrintWriter writer =null;
		
		try {
			writer=new PrintWriter(new FileWriter(new File("Customer.txt")));
			writer.write(cust.toString());
			status=true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			writer.close();
		}
		
		return status;
	}
	
	public List<Customer> readFromTextFile(File file){
		List<Customer> custList=new ArrayList<Customer>();
		
		BufferedReader reader=null;
		
		try {
			reader=new BufferedReader(new FileReader(file));
			String custAsString;
			while((custAsString=reader.readLine())!=null){
				String[] items=custAsString.split(",");
				Customer cust=new Customer(Long.parseLong(items[0]),items[1],Long.parseLong(items[2]));
				custList.add(cust);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return custList;
	}
	
	
}
