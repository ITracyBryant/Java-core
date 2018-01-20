/**
 * 
 */
package bounceThread;

import java.awt.geom.*;

/**
 * A ball that moves and bounces off the edges of a wall.
 * @XinCheng 2017��12��19�� Administrator
 *
 */
public class Ball {
	private static final int X_SIZE = 20;
	private static final int Y_SIZE = 20;
	private double x = 0;
	private double y = 0;
	private double dx = 1;
	private double dy = 1;
	
	/**
	 * Move the ball to the next position, reversing direction if it hits one of the edges
	 */
	public void move(Rectangle2D bounds)
	{
		x += dx;
		y += dy;
		if(x < bounds.getMinX())
		{
			x = bounds.getMinX();
			dx = -dx;
		}
		if(x + X_SIZE >= bounds.getMaxX())
		{
			x = bounds.getMaxX() - X_SIZE;
			dx = -dx;
		}
		if(y < bounds.getMinY())
		{
			y = bounds.getMinY();
			dy = -dy;
		}
		if(y + Y_SIZE >= bounds.getMaxY())
		{
			y = bounds.getMaxY() - Y_SIZE;
			dy = -dy;
		}
	}
	
	/**
	 * Gets the shape of the ball at its current position.
	 */
	public Ellipse2D getShape()
	{
		return new Ellipse2D.Double(x, y, X_SIZE, Y_SIZE);
	}

}
