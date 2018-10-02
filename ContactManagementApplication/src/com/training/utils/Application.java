package com.training.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

import com.training.entity.Contact;
import com.training.entity.ContactList;
import com.training.entity.Person;

public class Application {
	
	public static TreeSet<Contact> getContacts(DAO dao){
		TreeSet<Contact> contacts=null;
		try {
			contacts = dao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contacts;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=DbConnections.getConnection();
		DAO dao=new DAOImpl(conn);
		int choice=0;
		Scanner s=new Scanner(System.in);
		do{
			System.out.println("Enter the choice");
			System.out.println("1. Add Contact\n2. View Contacts\n3. View Contacts by Categories\n4. Remove Contact\n5. Remove Number\n6. Edit Contact\n7. Search Contact By Name\n0. Exit");
			choice=s.nextInt();
			switch(choice){
			case 1:
				System.out.println("Enter the First Name");
				String firstName=s.next();
				System.out.println("Enter the Last Name");
				String lastName=s.next();
				System.out.println("Enter the email id");
				String email=s.next();
				System.out.println("Enter the Relation\n1. Friend\n2. Relative\n3. Office");
				int ch=s.nextInt();
				String relation=ContactList.friendString;
				switch(ch){
				case 1:
					relation=ContactList.friendString;
					break;
				case 2:
					relation=ContactList.relativeString;
					break;
				case 3:
					relation=ContactList.officeString;
					break;
				default:
					break;
				}
				
				System.out.println("Enter the Number");
				long number=s.nextLong();
				TreeSet<Long> phNumbers=new TreeSet<>();
				phNumbers.add(number);
				Person person=new Person(firstName, lastName, email);
				Contact contact=new Contact(person, relation, phNumbers);
				dao.add(contact);
				break;
			case 2:
				System.out.println(getContacts(dao));
				break;
			case 3:
				ContactList list=new ContactList(getContacts(dao));
				System.out.println("1. Friends\n2. Relatives\n3. Office\nEnter the choice");
				ch=s.nextInt();
				switch(ch){
				case 1:
					System.out.println(list.getFriendList());
					break;
				case 2:
					System.out.println(list.getRelativeList());
					break;
				case 3:
					System.out.println(list.getOfficeList());
					break;
				default:
					System.out.println(list.getAllContacts());
					break;
				}
				break;
			case 4:
				for(Contact c:getContacts(dao)){
					System.out.println(c.getContactId()+" "+c.getPerson().getFirstName()+" "+c.getPerson().getLastName());
				}
				System.out.println("Enter the Id to delete");
				long idToDelete=s.nextLong();
				try {
					dao.removeContact(idToDelete);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5:
				for(Contact c:getContacts(dao)){
					System.out.println(c.getContactId()+" "+c.getPerson().getFirstName()+" "+c.getPerson().getLastName());
				}
				System.out.println("Enter the Id to delete");
				long idToDeleteNumber=s.nextLong();
				Map<Integer,Long> sIDtoNumber=new HashMap<>();
				for(Contact c:getContacts(dao)){
					if(c.getContactId()==idToDeleteNumber){
						int count=0;
						
						for(long n:c.getNumbers()){
							System.out.println(++count +" "+n);
							sIDtoNumber.put(count, n);
						}
						System.out.println("Enter the Id to delete");
						int ch1=s.nextInt();
						try {
							dao.removeContactNumber(sIDtoNumber.get(ch1));
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				break;
			case 6:
				for(Contact c:getContacts(dao)){
					System.out.println(c.getContactId()+" "+c.getPerson().getFirstName()+" "+c.getPerson().getLastName());
				}
				System.out.println("Enter the Id to Edit");
				ch=s.nextInt();
				contact=null;
				for(Contact c:getContacts(dao)){
					if(c.getContactId()==ch){
						contact=c;
					}
				}
				System.out.println("1. First Name\n2. Last Name\n3. Email\n4. Relation\n5. Add Number\n6. Edit Number");
				System.out.println("Select the field to edit");
				int ch2=s.nextInt();
				switch(ch2){
				case 1:
					System.out.println("Enter the new First Name");
					String newVal=s.next();
					try {
						dao.updateContactList(contact, "firstname", newVal);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 2:
					System.out.println("Enter the new Last Name");
					newVal=s.next();
					try {
						dao.updateContactList(contact, "lastname", newVal);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 3:
					System.out.println("Enter the new Email Id");
					newVal=s.next();
					try {
						dao.updateContactList(contact, "email", newVal);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 4:
					System.out.println("1. Friends\n2. Relatives\n3. Office\nEnter the choice");
					ch=s.nextInt();
					newVal=ContactList.friendString;
					switch(ch){
					case 1:
						//System.out.println(list.getFriendList());
						newVal=ContactList.friendString;
						break;
					case 2:
						//System.out.println(list.getRelativeList());
						newVal=ContactList.relativeString;
						break;
					case 3:
						//System.out.println(list.getOfficeList());
						newVal=ContactList.officeString;
						break;
					}
					break;
				case 5:
					System.out.println("Enter the number");
					long newNum=s.nextLong();
					try {
						dao.addContactNumber(contact.getContactId(), newNum);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 6:
					int count=0;
					Map<Integer,Long> idToNum=new HashMap<>();
					for(long n:contact.getNumbers()){
						System.out.println(++count+" "+n);
						idToNum.put(count,n);
					}
					System.out.println("Select the number to edit");
					ch=s.nextInt();
					System.out.println("Enter the new Number");
					newNum=s.nextLong();
					try {
						dao.updateContactNumber(idToNum.get(ch), newNum);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				break;
			case 7:
				System.out.println("Enter Name to Search Contact");
				String nameToSearch=s.next();
				for(Contact c:getContacts(dao)){
					if(c.getPerson().getFirstName().equals(nameToSearch) || c.getPerson().getLastName().equals(nameToSearch)){
						System.out.println(c.toString());
					}
				}
				break;
			default:
				break;
			}
		}while(choice!=0);
	}

}
