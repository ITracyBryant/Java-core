/**
 * 
 */
package interfaces;

import java.util.*;

/**
 * This program demonstrates the use of Comparable Interface.
 * @author Administrator
 *
 */
public class EmployeeSortTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee[] staff = new Employee[3];
		
		staff[0] = new Employee("Q", 35000);
		staff[1] = new Employee("C", 75000);
		staff[2] = new Employee("Z", 38000);
		
		Arrays.sort(staff); //use sort method by implement Comparable interface
		
		//print out information about all Employee objects
		for(Employee e : staff)
			System.out.println("name = " + e.getName() + ",salary = " + e.getSalary());

	}

}
