package vilia002.hw2;

/**
 * Describes a ship.
 * 
 * Ship is the abstract base class for all type of ships.
 * A Ship has a {@link Cell} for its Bow.
 * A Ship can be vertical or horizontal.
 * 
 * @author Vasilis Ilia
 * @version 1.0
 * @since 3/13/2023
 */
public abstract class Ship {
	private Cell bowCell;
	private boolean vertical;
	private int hitsTaken = 0;
	private boolean destroyed = false;
	
	/**
	 * Class constructor specifying cell for the ship's Bow and whether or not it's vertical.
	 * 
	 * @param bowCell   the Cell at the Bow the of ship
	 * @param vertical  whether the Ship is vertical or not
	 */
	protected Ship(Cell bowCell, boolean vertical) {
		this.bowCell = new Cell(bowCell);	
		this.vertical = vertical;		
	}
	
	/**
	 * Gets the x-coordinate of the Bow of the Ship.
	 * 
	 * @return the x-coordinate of the Bow of the Ship
	 */
	public int getBowX() {
		return bowCell.getX();
	}
	
	/**
	 * Gets the y-coordinate of the Bow of the Ship.
	 * 
	 * @return the y-coordinate of the Bow of the Ship
	 */
	public int getBowY() {
		return bowCell.getY();
	}
	
	/**
	 * Checks whether the Ship is vertical.
	 * 
	 * @return true if the Ship is vertical and false otherwise
	 */
	public boolean isVertical() {
		return vertical;
	}	
	
	/**
	 * Checks whether the Ship is destroyed.
	 * 
	 * @return true if the Ship is destroyed and false otherwise
	 */
	public boolean isDestroyed() {
		return destroyed;
	}
	
	/**
	 * Gets the symbol of the Ship.
	 * 
	 * @return the symbol of the Ship
	 */
	public char getSymbol() {
		return bowCell.getSymbol();
	}
	
	/**
	 * Adds a hit to the hits the Ship has taken and checks whether the ship has been destroyed.
	 * 
	 * Also prints appropriate message 
	 * 
	 * @param size  the size of the ship
	 */
	public void addHit(int size) {
		hitsTaken++;
		checkIfDestroyed(size);
	}
	
	/*
	 * Private method that updates destroyed field if the ship gets destroyed
	 * and prints appropriate message.
	 */
	private void checkIfDestroyed(int size) {
		if (hitsTaken == size) {
			destroyed = true;
			System.out.println("You just sank a ship!");
		}
		else
			System.out.println("HIT!");
	}
	
	/**
	 * Returns the size of the Ship.
	 * 
	 * @return  the size of the Ship
	 */
	public abstract int getSize();
}
