/**
 * 
 */
package plaf;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * A Frame with a button panel for changing look-and-feel
 * @XinCheng 2017Äê12ÔÂ9ÈÕ Administrator
 *
 */
@SuppressWarnings("serial")
public class PlafFrame extends JFrame {
	
	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public PlafFrame()
	{
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		buttonPanel = new JPanel();
		UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
		for(UIManager.LookAndFeelInfo info : infos)
			makeButton(info.getName(), info.getClassName());
		
		add(buttonPanel); //add panel to frame
		pack();
	}
	
	private void makeButton(String name, String className)
	{

		//add button to panel
		JButton button = new JButton(name);
		buttonPanel.add(button);
		
		//set button action
		button.addActionListener(event -> {
			//button action : switch to the new look-and-feel
			try
			{
				UIManager.setLookAndFeel(className);
				SwingUtilities.updateComponentTreeUI(this);
				pack();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		});
	}

}
