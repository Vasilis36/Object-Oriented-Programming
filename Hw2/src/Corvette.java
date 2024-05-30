package vilia002.hw2;

/**
 * A Corvette is a type of {@link Ship}.
 * 
 * It has a size of 3.
 * 
 * @author Vasilis Ilia
 * @version 1.0
 * @since 3/13/2023 
 */
public class Corvette extends Ship {
	private int size = 3;
	
	/**
	 * Class constructor specifying coordinates for the Corvette's Bow and whether or not it's vertical.
	 * 
	 * @param x			the x-coordinate of the Bow
	 * @param y			the y-coordinate of the Bow
	 * @param vertical  whether the Corvette is vertical or not
	 */
	public Corvette(int x, int y, boolean vertical) {
		super(new Cell(x, y, "ship", '4'), vertical);
	}
	
	/**
	 * Class constructor.
	 * 
	 * Initializes a Corvette with Bow at (0,0) and vertical.
	 */
	public Corvette() {
		this(0, 0, true);
	}
	
	public int getSize() {
		return size;
	}
}
