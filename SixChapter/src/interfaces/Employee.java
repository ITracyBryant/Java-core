/**
 * 
 */
package interfaces;

/**
 * @author 2017Äê10ÔÂ16ÈÕ Administrator
 *
 */
public class Employee implements Comparable<Employee> {
	private String name;
	private double salary;
	
	public Employee(String name, double salary)
	{
		this.name = name;
		this.salary = salary;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}
	
	public void raiseSalary(double byPercent)
	{
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	
	/* 
	 * compares employees by salary
	 * @param other another Employee object
	 * @return a negative value if this employee has a lower salary than otherObject, 0 if the salaries are the same, a positive value otherwise
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Employee other)
	{
		return Double.compare(salary, other.salary);
	}

}
