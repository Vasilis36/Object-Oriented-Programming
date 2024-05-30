package vilia002.hw2;

/**
 * A Frigate is a type of {@link Ship}.
 * 
 * It has a size of 3.
 * 
 * @author Vasilis Ilia
 * @version 1.0
 * @since 3/13/2023 
 */
public class Frigate extends Ship {
	private int size = 3;
	
	/**
	 * Class constructor specifying coordinates for the Frigate's Bow and whether or not it's vertical.
	 * 
	 * @param x			the x-coordinate of the Bow
	 * @param y			the y-coordinate of the Bow
	 * @param vertical  whether the Frigate is vertical or not
	 */
	public Frigate(int x, int y, boolean vertical) {
		super(new Cell(x, y, "ship", '3'), vertical);
	}
	
	/**
	 * Class constructor.
	 * 
	 * Initializes a Frigate with Bow at (0,0) and vertical.
	 */
	public Frigate() {
		this(0, 0, true);
	}
	
	public int getSize() {
		return size;
	}
}
