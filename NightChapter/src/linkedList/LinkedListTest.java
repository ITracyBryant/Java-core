/**
 * 
 */
package linkedList;

import java.util.*;

/**
 * This program demonstrates operations on linked lists.
 * @XinCheng 2017Äê11ÔÂ14ÈÕ Administrator
 *
 */
public class LinkedListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> a = new LinkedList<>();
		a.add("James");
		a.add("Bryant");
		a.add("Curry");
		
		List<String> b = new LinkedList<>();
		b.add("Durant");
		b.add("Westbrook");
		b.add("Harden");
		b.add("YIBAKA");
		
		//merge the words from b into a
		ListIterator<String> aIter = a.listIterator();
		Iterator<String> bIter = b.iterator();
		
		while(bIter.hasNext())
		{
			if(aIter.hasNext())
			{
				aIter.next();
			}
			aIter.add(bIter.next());
		}
		
		System.out.println(a);
		
		//remove every second word from b
		bIter = b.iterator();
		while(bIter.hasNext())
		{
			bIter.next(); //skip one element (head element)
			if(bIter.hasNext())
			{
				bIter.next();  //Interval next element
				bIter.remove(); //remove that element from b
			}
		}
		
		System.out.println(b);
		
		//bulk operation: remove all words in b from a
		a.removeAll(b);
		
		System.out.println(a);

	}

}
