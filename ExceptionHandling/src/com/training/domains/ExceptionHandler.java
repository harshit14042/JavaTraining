package com.training.domains;

public class ExceptionHandler {

	public static String handleWithJava(){
		try{
			String args="5";
			int age=Integer.parseInt(args);
			
			int marksScored=450;
			
			int average=marksScored/0;
			
			//System.out.println(age);
			
			System.out.println(average);
		}catch(ArrayIndexOutOfBoundsException | NumberFormatException | ArithmeticException e){
			System.err.println(e.getClass());
		}
		finally{
		System.out.println("Done");
		}
		return "BYE";
	}
	
	public static String handler(){
		try{
			String args="5";
			int age=Integer.parseInt(args);
			
			int marksScored=450;
			
			int average=marksScored/0;
			
			//System.out.println(age);
			
			System.out.println(average);
		}catch(ArrayIndexOutOfBoundsException e){
			System.err.println("Required command Line Args");
		}catch(NumberFormatException e){
			System.err.println("Should Be Number");
			}
			catch(ArithmeticException e){
				//return "BYE BYE";
				System.err.println("Should Not be zero");
				return "BYE BYE";
				}
		finally{
		System.out.println("Done");
		}
		return "BYE";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		handleWithJava();
	}
}
