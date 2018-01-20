/**
 * 
 */
package applet;

import java.awt.*;
import javax.swing.*;

/**
 * @XinCheng 2017Äê12ÔÂ13ÈÕ Administrator
 *
 */
@SuppressWarnings("serial")
public class TheWorld extends JApplet
{
	public void init()
	{
		EventQueue.invokeLater(() -> {
			JLabel label = new JLabel("The world, understanding", SwingConstants.CENTER);
			add(label);
		});
	}
}
