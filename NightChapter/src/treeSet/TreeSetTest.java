/**
 * 
 */
package treeSet;

import java.util.*;

/**
 * This program sorts a set of item by comparing their descriptions.
 * @XinCheng 2017��11��17�� Administrator
 *
 */
public class TreeSetTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortedSet<Item> parts = new TreeSet<>();
		parts.add(new Item("Toaster", 1234));
		parts.add(new Item("Widget", 4562));
		parts.add(new Item("Modem", 9912));
		System.out.println(parts);
		
		NavigableSet<Item> sortByDescription = new TreeSet<>(Comparator.comparing(Item::getDescription));
		
		sortByDescription.addAll(parts);
		System.out.println(sortByDescription);

	}

}
