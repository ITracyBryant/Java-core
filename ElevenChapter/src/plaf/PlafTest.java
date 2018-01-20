/**
 * 
 */
package plaf;

import java.awt.EventQueue;
import javax.swing.JFrame;


/**
 * @XinCheng 2017Äê12ÔÂ9ÈÕ Administrator
 *
 */
public class PlafTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(() ->
		{
			JFrame frame = new PlafFrame();
			frame.setTitle("PlafTest");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});

	}

}
