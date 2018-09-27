package com.training;
import org.apache.log4j.*;
public class Application {

	public static void main(String[] args) {
		//Logger log=Logger.getLogger("example");
		Logger log=Logger.getRootLogger();
		//Logger log=Logger.getLogger("second");
		
		String mark="Fifty Five";
		try {
			double markScored=Double.parseDouble(mark);
			log.info(markScored);
		} catch (Exception e) {
			log.error("Invalid Number Format"+e.getMessage());
		}
		
	}

}