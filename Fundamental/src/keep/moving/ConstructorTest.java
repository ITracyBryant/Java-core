package keep.moving;

import java.util.*;

public class ConstructorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//fill the staff array with three Employee4 objects
		Employee4[] staff=new Employee4[3];
		
		staff[0]=new Employee4("Harry",40000);
		staff[1]=new Employee4(60000);
		staff[2]=new Employee4();
		
		//print out information about all Employee4 objects
		for (Employee4 employee4 : staff) {
			System.out.println("name=" + employee4.getName()+", id="+employee4.getId()
			+", salary="+employee4.getSalary());
		}
	}
		
}


class Employee4
{
	private static int nextId;
	
	private int id;
	private String name=""; //instance field initialization
	private double salary;
	
	//static initialization block
	static
	{
		Random generator=new Random();
		//set nextId to a random number between 0 and 9999
		nextId=generator.nextInt(10000);
	}
	
	//object initialization block
	{
		id=nextId;
		nextId++;
	}
	
	//three overloaded constructors
	public Employee4(String n,double s)
	{
		name=n;
		salary=s;
	}
	
	//awake other constructors by the constructor
	public Employee4(double s)
	{
		//calls the Employee(String, double) constructor
		this("Employee4 #"+nextId, s);
	}
	
	//the default constructor
	public Employee4()
	{
		//name initialized to " "---see above
		//salary not explicitly set ---initialized to 0
		//id initialized in initialization block
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	public int getId()
	{
		return id;
	}

}
