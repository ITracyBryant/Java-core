/**
 * 
 */
package timer;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer; //to resolve conflict with java.util.Timer

/**
 * @xincheng 2017Äê10ÔÂ16ÈÕ Administrator
 *
 */
public class TimerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActionListener listener = new TimePrinter();
		
		//construct a timer that calls the Listener
		//once every 10 seconds
		Timer t = new Timer(3000, listener);
		t.start();
		JOptionPane.showMessageDialog(null, "exit?");
		System.exit(0);

	}

}

class TimePrinter implements ActionListener
{
	public void actionPerformed(ActionEvent event)
	{
		System.out.println("At the tone, the time is " + new Date());
		Toolkit.getDefaultToolkit().beep();
	}
}
