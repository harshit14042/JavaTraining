package com.training;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.training.module.Employee;

public class Parser extends DefaultHandler {

	
	boolean element=false;
	String celem="";
	List<Employee> emps=new ArrayList<>();
	@Override
	public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
		// TODO Auto-generated method stub
		//super.characters(arg0, arg1, arg2);
		System.out.println("Characters Method called");
//		for(char c:arg0){
//			System.out.print(c+" ");
//		}
//		System.out.println(":"+arg1+" "+arg2);
		if(element){
			
			//System.out.println("Arg0"+arg0[arg1:arg2]+" Arg1"+arg1+" Arg2"+arg2);
			String s="";
			for(int i=arg1;i<arg1+arg2;i++){
				//System.out.print(arg0[i]);
				s+=arg0[i];
			}
			s=s.trim();
			System.out.println(s);
		}
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		//super.endDocument();
		System.out.println("EndDocument Method called");
		//System.out.println(arg0);
	}

	@Override
	public void endElement(String arg0, String arg1, String arg2) throws SAXException {
		// TODO Auto-generated method stub
		//super.endElement(arg0, arg1, arg2);
		System.out.println("endElement Method called");
		System.out.println(arg1);
		element=false;
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		//super.startDocument();
		System.out.println("startDocument Method called");
		//System.out.println(arg0);
	}

	@Override
	public void startElement(String arg0, String arg1, String arg2, Attributes arg3) throws SAXException {
		// TODO Auto-generated method stub
		//super.startElement(arg0, arg1, arg2, arg3);
		System.out.println("startElement Method called");
		System.out.println(arg1);
		element=true;
	}

	
	
}
