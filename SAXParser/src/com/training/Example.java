package com.training;

import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			XMLReader parser = XMLReaderFactory.createXMLReader();
			
			parser.setContentHandler(new Parser());
			parser.parse("src/Class.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
