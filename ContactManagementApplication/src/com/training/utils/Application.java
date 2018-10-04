package com.training.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.training.entity.Contact;
import com.training.entity.ContactList;
import com.training.entity.Person;

public class Application {
	
	public static TreeSet<Contact> contactSet=null;
	
	public static TreeSet<String> peopleNames=null;
	
	public static TreeSet<Long> phNumbers=null;
	
	public static void init(DAO dao) throws SQLException{
		try {
			contactSet = dao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		peopleNames=dao.getAllNames();
		phNumbers=dao.getAllNumbers();
	}

	public static void main(String[] args) {
		Connection conn=DbConnections.getConnection();
		DAO dao=new DAOImpl(conn);
		int choice=0;
		try {
			init(dao);
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
				if(peopleNames.contains(firstName+" "+lastName)){
					System.out.println("Name already exists");
					break;
				}
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
					relation=ContactList.friendString;
					break;
				}
				
				System.out.println("Enter the Number");
				long number=s.nextLong();
				if(phNumbers.contains(number)){
					System.out.println("Number Already Exists");
					break;
				}
				TreeSet<Long> phContactNumbers=new TreeSet<>();
				phContactNumbers.add(number);
				Person person=new Person(firstName, lastName, email);
				Contact contact=new Contact(person, relation, phContactNumbers);
				dao.add(contact);
				break;
			case 2:
				for(Contact con:contactSet){
					System.out.println(con.toString());
				}
				break;
			case 3:
				System.out.println("Friends: "+dao.getContactsByRelation(ContactList.friendString).size());
				System.out.println("Relatives: "+dao.getContactsByRelation(ContactList.relativeString).size());
				System.out.println("Office: "+dao.getContactsByRelation(ContactList.officeString).size()+"\n");
				System.out.println("1. Friends\n2. Relatives\n3. Office\nEnter the choice");
				ch=s.nextInt();
					Set<Contact> categoryContactList=dao.findAll();
				switch(ch){
				case 1:
					categoryContactList=dao.getContactsByRelation(ContactList.friendString);
					System.out.println("Friends: "+categoryContactList.size()+"\n"+categoryContactList);
					break;
				case 2:
					categoryContactList=dao.getContactsByRelation(ContactList.relativeString);
					System.out.println("Relatives: "+categoryContactList.size()+"\n"+categoryContactList);
					break;
				case 3:
					categoryContactList=dao.getContactsByRelation(ContactList.officeString);
					System.out.println("Office: "+categoryContactList.size()+"\n"+categoryContactList);
					break;
				default:
					System.out.println("All: "+categoryContactList.size()+"\n"+categoryContactList);
					break;
				}
				break;
			case 4:
				for(Contact c:contactSet){
					System.out.println(c.getContactId()+" "+c.getPerson().getFirstName()+" "+c.getPerson().getLastName());
				}
				System.out.println("Enter the Id to delete");
				long idToDelete=s.nextLong();
					dao.removeContact(idToDelete);
				
				
				break;
			case 5:
				for(Contact c:contactSet){
					System.out.println(c.getContactId()+" "+c.getPerson().getFirstName()+" "+c.getPerson().getLastName());
				}
				System.out.println("Enter the Id to delete");
				long idToDeleteNumber=s.nextLong();
				Map<Integer,Long> sIDtoNumber=new HashMap<>();
				for(Contact c:contactSet){
					if(c.getContactId()==idToDeleteNumber){
						int count=0;
						
						for(long n:c.getNumbers()){
							System.out.println(++count +" "+n);
							sIDtoNumber.put(count, n);
						}
						System.out.println("Enter the Id to delete");
						int ch1=s.nextInt();
							dao.removeContactNumber(sIDtoNumber.get(ch1));
						
					}
				}
				break;
			case 6:
				for(Contact c:contactSet){
					System.out.println(c.getContactId()+" "+c.getPerson().getFirstName()+" "+c.getPerson().getLastName());
				}
				System.out.println("Enter the Id to Edit");
				ch=s.nextInt();
				contact=null;
				for(Contact c:contactSet){
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
						dao.updateContactList(contact, "firstname", newVal);
					
					break;
				case 2:
					System.out.println("Enter the new Last Name");
					newVal=s.next();
						dao.updateContactList(contact, "lastname", newVal);
					
					break;
				case 3:
					System.out.println("Enter the new Email Id");
					newVal=s.next();
						dao.updateContactList(contact, "email", newVal);
					
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
					default:
						newVal=ContactList.friendString;
						break;
					}
						dao.updateContactList(contact, "relation", newVal);
					
					
					break;
				case 5:
					System.out.println("Enter the number");
					long newNum=s.nextLong();
						dao.addContactNumber(contact.getContactId(), newNum);
					
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
					if(phNumbers.contains(newNum)){
						System.out.println("Number Already Exists");
						break;
					}
						dao.updateContactNumber(idToNum.get(ch), newNum);
					break;
				default:
					break;
				}
				break;
			case 7:
				System.out.println("Enter Name to Search Contact");
				String nameToSearch=s.next();
				ContactList contactList=new ContactList(contactSet);
				Set<Contact> searchedContacts=contactList.getContactByName(nameToSearch);
				searchedContacts.forEach(System.out::println);
				break;
			default:
				break;
			}
			try {
				init(dao);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(choice!=0);
		s.close();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

}
