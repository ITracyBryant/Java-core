/**
 * 
 */
package sizedFrame;

import java.awt.*;
import javax.swing.*;

/**
 * @XinCheng 2017Äê11ÔÂ29ÈÕ Administrator
 *
 */
public class SizedFrameTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(() ->
		{
			JFrame frame = new SizedFrame();
			frame.setTitle("SizedFrame");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//frame.setExtendedState(Frame.MAXIMIZED_BOTH);
			frame.setVisible(true);
		});
	}

}

@SuppressWarnings("serial")
class SizedFrame extends JFrame
{
	public SizedFrame()
	{
		//get screen dimensions
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		//set frame width, height and let platform pick screen location
		setSize(screenWidth / 2, screenHeight / 2);
		setLocationByPlatform(true);
		
		//set frame icon
		Image img = new ImageIcon("icon.gif").getImage();
		setIconImage(img);
	}
}