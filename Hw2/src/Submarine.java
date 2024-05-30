package vilia002.hw2;

/**
 * A Submarine is a type of {@link Ship}.
 * 
 * It has a size of 2.
 * 
 * @author Vasilis Ilia
 * @version 1.0
 * @since 3/13/2023 
 */
public class Submarine extends Ship {
	private int size = 2;
	
	/**
	 * Class constructor specifying coordinates for the Submarine's Bow and whether or not it's vertical.
	 * 
	 * @param x			the x-coordinate of the Bow
	 * @param y			the y-coordinate of the Bow
	 * @param vertical  whether the Submarine is vertical or not
	 */
	public Submarine(int x, int y, boolean vertical) {
		super(new Cell(x, y, "ship", '5'), vertical);
	}
	
	/**
	 * Class constructor.
	 * 
	 * Initializes a Submarine with Bow at (0,0) and vertical.
	 */
	public Submarine() {
		this(0, 0, true);
	}
	
	public int getSize() {
		return size;
	}
}
