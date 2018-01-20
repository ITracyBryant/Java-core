/**
 * 
 */
package map;

import java.util.*;

/**
 * This program demonstrates the use of a map with key type String and value type Employee. 
 * @XinCheng 2017Äê11ÔÂ17ÈÕ Administrator
 *
 */
public class MapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Employee> staff = new HashMap<>();
		//Map<String, Employee> staff = new TreeMap<>();
		staff.put("11-01-01", new Employee("cx", 50000, 1995, 10, 3));
		staff.put("22-02-02", new Employee("gl", 30000, 1995, 8, 15));
		staff.put("33-03-03", new Employee("jk", 20000, 1995, 8, 7));
		staff.put("44-04-04", new Employee("op", 10000, 1995, 12, 1));
		
		//print all entries
		//staff.keySet().iterator()   staff.values().iterator()
		System.out.println(staff);
		
		//remove an entry
		staff.remove("44-04-04");
		
		//replace an entry
		staff.put("33-03-03", new Employee("qq", 35000, 1993, 3, 3));
		
		//look up a value
		System.out.println(staff.get("11-01-01"));
		
		//iterate through all entries
		staff.forEach((k, v) -> System.out.println("key = " + k + ", value = " + v));
	}

}
