package vilia002.hw3.neurons;

/**
 * Describes a position with coordinates.
 * 
 * @author Vasilis Ilia
 * @version 1.0
 * @since 02/04/2023
 */
public class Position {
	private double x;
	private double y;
	
	/**
	 * Class constructor specifying coordinates.
	 * 
	 * @param x  the x-coordinate
	 * @param y  the y-coordinate
	 */
	public Position(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * No parameter class constructor.
	 * 
	 * Initializes coordinates to zero.	 
	 */
	public Position() {
		this(0, 0);
	}
	
	/**
	 * Gets the x-coordinate.
	 * 
	 * @return  the x-coordinate
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Gets the y-coordinate.
	 * 	 
	 * @return  the y-coordinate
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * Returns the coordinates in string form.	
	 * 
	 * @return  the coordinates in string form
	 */
	public String toString() {
		return "(" + x + ", " + y + ")";
	}	
}
