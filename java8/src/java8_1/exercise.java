package java8_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class exercise{
	
	final static String GABSIXNAME = "육갑이";
	public static void main(String[] args) {
		
		List<People> pp = new ArrayList<>();
		pp.add(new People("육갑이", 16));
		pp.add(new People("칠갑이", 17));
		pp.add(new People("팔갑이", 18));
		pp.add(new People("육갑이", 19));
		pp.add(new People("팔갑이", 21));
		pp.add(new People("육갑이", 55));
		List<Customer> cus = new ArrayList<>();
		pp.stream().forEach(item->{ 
									if(item.getName().equals(GABSIXNAME)){
										cus.add(new Customer(GABSIXNAME, "서울역 2층 " + item.getAge()));
									}
								  }
						    );
		
		cus.stream().forEach(System.out::println);
	}
	
	
}
class People{
	private String name;
	private int age;
	public People(String name, int age){
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
class Customer{
	private String name;
	private String address;
	public Customer(String name, String address){
		this.name = name;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}

