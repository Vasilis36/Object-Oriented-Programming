package vilia002.hw2;

/**
 * A Carrier is a type of {@link Ship}. 
 * 
 * It has a size of 5.
 * 
 * @author Vasilis Ilia
 * @version 1.0
 * @since 3/13/2023 
 */
public class Carrier extends Ship {
	private int size = 5;
	
	/**
	 * Class constructor specifying coordinates for the Carrier's Bow and whether or not it's vertical. 
	 *
	 * @param x			the x-coordinate of the Bow
	 * @param y			the y-coordinate of the Bow
	 * @param vertical  whether the Carrier is vertical or not
	 */
	public Carrier(int x, int y, boolean vertical) {
		super(new Cell(x, y, "ship", '1'), vertical);	
	}
	
	/**
	 * Class constructor.
	 * 
	 * Initializes a Carrier with Bow at (0,0) and vertical.
	 */
	public Carrier() {
		this(0, 0, true);
	}	
	
	public int getSize() {
		return size;
	}
}
