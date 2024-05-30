package vilia002.hw2;

/**
 * A Destroyer is a type of {@link Ship}.
 * 
 * It has a size of 4.
 * 
 * @author Vasilis Ilia
 * @version 1.0
 * @since 3/13/2023 
 */
public class Destroyer extends Ship {
	private int size = 4;
	
	/**
	 * Class constructor specifying coordinates for the Destroyer's Bow and whether or not it's vertical.
	 * 
	 * @param x			the x-coordinate of the Bow
	 * @param y			the y-coordinate of the Bow
	 * @param vertical  whether the Destroyer is vertical or not
	 */
	public Destroyer(int x, int y, boolean vertical) {
		super(new Cell(x, y, "ship", '2'), vertical);
	}
	
	/**
	 * Class constructor.
	 * 
	 * Initializes a Destroyer with Bow at (0,0) and vertical.
	 */
	public Destroyer() {
		this(0, 0, true);
	}
	
	public int getSize() {
		return size;
	}
}
