package com.training.domains;

public class Employee implements Comparable<Employee>{
	private int age;
	private long id;
	private String name;
	static public String order;
	static public int ord;
	
	@Override
	public String toString() {
		return "Employee [age=" + age + ", id=" + id + ", name=" + name + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) throws RangeCheckException {
		if(age<18 || age>58){
			throw new RangeCheckException("Please provide the age in the range 18 to 58");
		}
		else{
			this.age = age;
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int age, String name) throws RangeCheckException {
		super();
		if(age<18 || age>58){
			throw new RangeCheckException("Please provide the age in the range 18 to 58"); 
		}
		else{
			this.age = age;
		}
		this.name = name;
	}
	public Employee(int age, String name,long id) {
		super();
		this.age = age;
		this.id = id;
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		if(this.id>o.id) return -1*ord;
		if(this.id<o.id) return 1*ord;
		return 0;
	}
	
}
