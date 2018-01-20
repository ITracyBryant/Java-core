/**
 * 
 */
package roadApplet;

import java.awt.*;
import java.applet.*;
import javax.swing.*;

/**
 * @XinCheng 2017��12��14�� Administrator
 *
 */
@SuppressWarnings({ "serial", "unused" })
public class RoadApplet extends JApplet{
	private RoadComponent roadComponent;
	private JSlider slowdown;
	private JSlider arrival;
	
	public void init()
	{
		EventQueue.invokeLater(() -> {
			roadComponent = new RoadComponent();
			slowdown = new JSlider(0, 100, 10);
			arrival = new JSlider(0, 100, 50);
			
			JPanel p = new JPanel();
			p.setLayout(new GridLayout(1, 6));
			p.add(new JLabel("Slowdown"));
			p.add(slowdown);
			p.add(new JLabel(""));
			p.add(new JLabel("Arrival"));
			p.add(arrival);
			p.add(new JLabel(""));
			setLayout(new BorderLayout());
			add(p, BorderLayout.NORTH);
			add(roadComponent, BorderLayout.CENTER);
		});
	}
	
	public void start()
	{
		new Thread(() -> {
			for(;;)
			{
				roadComponent.update(0.01 * slowdown.getValue(), 0.01 * arrival.getValue());
				try
				{
					Thread.sleep(50);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}).start();
	}

}

@SuppressWarnings("serial")
class RoadComponent extends JComponent
{
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 400;

	public void update(double d, double e) {
		// TODO Auto-generated method stub
		d = d * 10;
		e = e * 10;
	}
	
	public Dimension getPreferredSize()
	{
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}
