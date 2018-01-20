/**
 * 
 */
package bounceThread;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Shows animated bouncing balls
 * @XinCheng 2017Äê12ÔÂ19ÈÕ Administrator
 *
 */
public class BounceThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(() -> {
			JFrame frame = new BounceFrame();
			frame.setTitle("BounceThread");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}

/**
 * The frame with panel and buttons
 *
 */
@SuppressWarnings("serial")
class BounceFrame extends JFrame
{
	private BallComponent comp;
	public static final int STEPS = 500;
	public static final int DELAY = 5;
	
	/**
	 * Constructs the frame with the component for showing the bouncing ball and start and close buttons.
	 */
	public BounceFrame()
	{
		comp = new BallComponent();
		add(comp, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		addButton(buttonPanel, "Start", event -> addBall());
		addButton(buttonPanel, "Close", event -> System.exit(0));
		add(buttonPanel, BorderLayout.SOUTH);
		pack();
	}
	
	/**
	 * Adds a button to a container
	 * @param c the container
	 * @param title the button title
	 * @param listener the action listener for the button
	 */
	public void addButton(Container c, String title, ActionListener listener)
	{
		JButton button = new JButton(title);
		c.add(button);
		button.addActionListener(listener);
	}
	
	/**
	 * Adds a bouncing ball to the canvas and starts a thread to makes it bounce 500 times of every interval 5 milliseconds.
	 */
	public void addBall()
	{
		Ball ball = new Ball();
		comp.add(ball);
		Runnable r = () -> {
			try
			{
				for(int i = 1; i <= STEPS; i++)
				{
					ball.move(comp.getBounds());
					comp.repaint();
					Thread.sleep(DELAY);
				}
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		};
		Thread t = new Thread(r);
		t.start();
	}
}