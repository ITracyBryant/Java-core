/**
 * 
 */
package lambda;

import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
/**
 * This program demonstrates the use of lambda expressions
 * @xincheng 2017��10��21�� Administrator
 *
 */
public class LambdaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] planets = new String[] {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
		System.out.println(Arrays.toString(planets));
		System.out.println("Sorted in dictionary order:");
		Arrays.sort(planets);
		System.out.println(Arrays.toString(planets));
		System.out.println("Sorted by length:");
		Arrays.sort(planets, (first, second) -> first.length() - second.length());
		System.out.println(Arrays.toString(planets));
		
		Timer t = new Timer(1000, event -> System.out.println("The time is " + new Date()));
		t.start();
		
		//keep program running until user selects "OK"
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}

}
