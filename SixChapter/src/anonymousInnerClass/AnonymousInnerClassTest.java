/**
 * 
 */
package anonymousInnerClass;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * This program demonstrates anonymous inner classes
 * @xincheng 2017年10月25日 Administrator
 *
 */
public class AnonymousInnerClassTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TalkingClock clock = new TalkingClock();
		clock.start(1000, true);
		
		//keep program running until user selects "OK"
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}

}

/**
 * A clock that prints the time in regular intervals.
 * @xincheng 2017年10月25日 Administrator
 *
 */
class TalkingClock
{
	/**
	 * Starts the clock.
	 * @param interval the interval between messages (in milliseconds)
	 * @param beep true if the clock should beep
	 */
	public void start(int interval, boolean beep)
	{
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("At the tone, the time is " + new Date());
				if(beep) Toolkit.getDefaultToolkit().beep();
			}
		};
		Timer t = new Timer(interval, listener);
		t.start();
	}
	
	/*public void start(int interval, boolean beep)  //使用lambda表达式写法更简洁
	{
		Timer t = new Timer(interval, event -> {
			System.out.println("At the tone, the time is " + new Date());
			if(beep) Toolkit.getDefaultToolkit().beep();
		});
		t.start();
	}*/
}

