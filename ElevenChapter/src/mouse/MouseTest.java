/**
 * 
 */
package mouse;

import java.awt.EventQueue;
import javax.swing.JFrame;


/**
 * @XinCheng 2018��1��20�� Administrator
 *
 */
public class MouseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			JFrame frame = new MouseFrame();
			frame.setTitle("MouseTest");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});

	}

}
