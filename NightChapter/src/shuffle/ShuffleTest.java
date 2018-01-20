/**
 * 
 */
package shuffle;

import java.util.*;

/**
 * This program demonstrates the random shuffle and sort algorithms.
 * @XinCheng 2017Äê11ÔÂ25ÈÕ Administrator
 *
 */
public class ShuffleTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = new ArrayList<>();
		for(int i = 1; i <= 49; i++)
		{
			numbers.add(i);
		}
		Collections.shuffle(numbers);
		List<Integer> winningCombination = numbers.subList(0, 6);
		Collections.sort(winningCombination);
		System.out.println(winningCombination);
		
	}

}
