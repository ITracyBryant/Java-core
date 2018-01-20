/**
 * 
 */
package clone;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @xincheng 2017年10月21日 Administrator
 *
 */
public class Employee implements Cloneable 
{
	private String name;
	private double salary; //Primitive type not mutable
	private Date hireDay; //mutable fields
	
	public Employee(String name, double salary) 
	{
		this.name = name;
		this.salary = salary;
		hireDay = new Date();
	}
	
	public Employee clone() throws CloneNotSupportedException
	{
		//call Object.clone()
		Employee cloned = (Employee)super.clone();
		
		//clone mutable fields
		cloned.hireDay = (Date)hireDay.clone();  //子对象可变，深拷贝

		return cloned;
	}
	
	/**
	 * Set the hire day to a given date.
	 * @param year the year of the hire day
	 * @param month the month of the hire day
	 * @param day the day of the hire day
	 */
	public void setHireDay(int year, int month, int day)
	{
		Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
		//Example of instance field mutation
		hireDay.setTime(newHireDay.getTime());
	}
	
	public void raiseSalary(double byPercent)
	{
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	
	public String toString()
	{
		return "Employee[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
	}

}
