/**
 * 
 */
package resource;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

/**
 * @XinCheng 2017��12��11�� Administrator
 *
 */
public class ResourceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(() -> {
			JFrame frame = new ResourceTestFrame();
			frame.setTitle("ResourceTest");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			});
	}

}

@SuppressWarnings("serial")
class ResourceTestFrame extends JFrame
{
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	
	public ResourceTestFrame()
	{
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		URL aboutURL = getClass().getResource("about.gif");
		Image img = new ImageIcon(aboutURL).getImage();
		setIconImage(img);
		
		JTextArea textArea = new JTextArea();
		InputStream stream = getClass().getResourceAsStream("about.txt");
		try(Scanner in = new Scanner(stream, "UTF-8"))
		{
			while(in.hasNext())
				textArea.append(in.nextLine() + "\n");
		}
		add(textArea);
	}
}