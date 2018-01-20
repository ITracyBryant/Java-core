/**
 * 
 */
package action;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 * @XinCheng 2017Äê12ÔÂ11ÈÕ Administrator
 *
 */
public class ActionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(() ->
		{
			JFrame frame = new ActionFrame();
			frame.setTitle("ActionTest");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});

	}

}
