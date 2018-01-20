/**
 * 
 */
package button;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @XinCheng 2017��12��8�� Administrator
 *
 */

public class ButtonTest
{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(() ->
				{
					JFrame frame = new ButtonFrame();
					frame.setTitle("ButtonTest");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				});
		   

	}
}

/**
 * A frame with a button panel
 *
 */
@SuppressWarnings("serial")
class ButtonFrame extends JFrame
{
	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public ButtonFrame()
	{
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		//create buttons
		JButton yellowButton = new JButton("Yellow");
		JButton blueButton = new JButton("Blue");
		JButton redButton = new JButton("Red");
		
		buttonPanel = new JPanel();
		
		//add buttons to panel
		buttonPanel.add(yellowButton);
		buttonPanel.add(blueButton);
		buttonPanel.add(redButton);
		
		//add panel to frame
		add(buttonPanel);
		
		//create button actions
		ColorAction yellowAction = new ColorAction(Color.YELLOW);
		ColorAction blueAction = new ColorAction(Color.BLUE);
		ColorAction redAction = new ColorAction(Color.RED);
		
		//associate actions with buttons
		yellowButton.addActionListener(yellowAction);
		blueButton.addActionListener(blueAction);
		redButton.addActionListener(redAction);
		
	}
	
	/**
	 * An action listener that sets the panel's background color
	 *
	 */
	private class ColorAction implements ActionListener
	{
		private Color backgroundColor;
		
		public ColorAction(Color c)
		{
			backgroundColor = c;
		}
		
		public void actionPerformed(ActionEvent event)
		{
			buttonPanel.setBackground(backgroundColor);
		}
	}
	

}
