/**
 * 
 */
package innerClass;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * This program demonstrates the use of inner classes
 * @xincheng 2017��10��25�� Administrator
 *
 */
public class InnerClassTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TalkingClock clock = new TalkingClock(3000, true);
		clock.start();
		
		//keep program running until user selects "OK"
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}

}

/**
 * A clock that prints the time in regular intervals.
 * @xincheng 2017��10��25�� Administrator
 *
 */
class TalkingClock
{
	private int interval;
	private boolean beep;
	
	/**
	 * Constructs a talking clock
	 * @param interval the interval between messages (in milliseconds)
	 * @param beep true if the clock should beep
	 */
	public TalkingClock(int interval, boolean beep)
	{
		this.interval = interval;
		this.beep = beep;
	}
	
	/**
	 * Starts the clock.
	 */
	public void start()
	{
		ActionListener listener = new TimePrinter();
		Timer t = new Timer(interval, listener);
		t.start();
	}
	
	public class TimePrinter implements ActionListener  //a inner class
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("At the tone, the time is" + new Date());
			if(beep) Toolkit.getDefaultToolkit().beep();
		}
	}
}
