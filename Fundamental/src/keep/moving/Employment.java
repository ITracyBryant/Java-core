package keep.moving;

import java.time.*;

class Employment 
{
	private String name;
	private double salary;
	private LocalDate assignDay;
	
	public Employment(String n,double s,int year,int month,int day)
	{
		name=n;
		salary=s;
		@SuppressWarnings("unused")
		LocalDate assignDay=LocalDate.of(year,month,day);
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	public LocalDate getAssignDay()
	{
		return assignDay;
	}

	public void raiseSalary(double byPercent)
	{
		double raise=this.salary*byPercent/100;
		this.salary+=raise;
	}
	
	public static void main(String[] args)//unit test
	{
		Employment e=new Employment("Romeo",50000,1993,3,31);
		e.raiseSalary(5);
		System.out.println("name: "+e.getName()+" , salary: "+e.getSalary());
		
		
	}
}

