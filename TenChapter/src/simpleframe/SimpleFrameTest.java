/**
 * 
 */
package simpleframe;

import java.awt.*;
import javax.swing.*;

/**
 * @XinCheng 2017Äê11ÔÂ28ÈÕ Administrator
 *
 */
public class SimpleFrameTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(() ->
			{
				SimpleFrame frame = new SimpleFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//frame.setUndecorated(true);
				//frame.setLocation(100, 100);
				frame.setBounds(300, 300, 300, 300);
				frame.setVisible(true); 
			});
	}

}

@SuppressWarnings("serial")
class SimpleFrame extends JFrame
{
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public SimpleFrame()
	{
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}
