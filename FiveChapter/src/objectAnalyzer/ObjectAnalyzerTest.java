/**
 * 
 */
package objectAnalyzer;

import java.util.ArrayList;;

/**
 * This program uses reflection to spy on objects
 * @Cheng 2017��10��11�� Administrator
 *
 */
public class ObjectAnalyzerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> squares = new ArrayList<>();
		for (int i = 1; i <= 5; i++)
			squares.add(i * i);
		System.out.println(new ObjectAnalyzer().toString(squares));

	}

}
