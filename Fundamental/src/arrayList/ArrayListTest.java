/**
 * 
 */
package arrayList;

import java.util.*;

/**
 * @author c1114
 *
 */
public class ArrayListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//fill the staff array list with three Employee objects
		ArrayList<Employee> staff = new ArrayList<>();
		
		staff.add(new Employee("cx", 80000, 1995, 10, 3));
		staff.add(new Employee("zq", 60000, 1994, 8, 3));
		staff.add(new Employee("qy", 40000, 1994, 1, 3));
		
		//raise everyone's salary by 5%
		for(Employee e : staff) 
			e.raiseSalary(5);		
		/*for(int i = 0; i < staff.size(); i++)
		  {
		     Employee e = staff.get(i);
		     e.raiseSalary(5);
		  }
		 */
	
		//print out information about all Employee objects
		for(Employee e : staff)
			System.out.println("name=" + e.getName() + ", salary=" + e.getSalary() + ", hireDay="
					+e.getHireDay());
	}

}
