/**
 * 
 */
package whatfucking;

import java.awt.*;
import javax.swing.*;

/**
 * @XinCheng 2017Äê11ÔÂ29ÈÕ Administrator
 *
 */
public class WhatFucking {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(() ->
		{
			JFrame frame = new WhatFuckingFrame();
			frame.setTitle("WhatFucking");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});

	}

}

/**
 * A frame that contains a message panel.
 *
 */
@SuppressWarnings("serial")
class WhatFuckingFrame extends JFrame
{
	public WhatFuckingFrame()
	{
		add(new WhatFuckingComponent());
		pack();
	}
}

/**
 * A component that displays a message.
 *
 */
@SuppressWarnings("serial")
class WhatFuckingComponent extends JComponent
{
	public static final int MESSAGE_X = 75;
	public static final int MESSAGE_Y = 100;
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public void paintComponent(Graphics g)
	{
		g.drawString("WhatFucking?", MESSAGE_X, MESSAGE_Y);
	}
	
	public Dimension getPreferredSize()
	{
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}