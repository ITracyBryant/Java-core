/**
 * 
 */
package bounce;

import java.awt.*;
import java.util.*;

import javax.swing.*;

/**
 * The component that draws the balls.
 * @XinCheng 2017Äê12ÔÂ19ÈÕ Administrator
 *
 */
@SuppressWarnings("serial")
public class BallComponent extends JPanel {

	private static final int DEFAULT_WIDTH = 440;
	private static final int DEFAULT_HEIGHT = 330;
	
	private java.util.List<Ball> balls = new ArrayList<>();
	
	public void add(Ball b){
		balls.add(b);
	}
	
	/* 
	 * Add a ball to the component
	 * @param b the ball to add
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);  //erase background
		Graphics2D g2 = (Graphics2D) g;
		for(Ball b : balls)
		{
			g2.fill(b.getShape());
		}
	}
	
	public Dimension getPreferredSize()
	{
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

}
