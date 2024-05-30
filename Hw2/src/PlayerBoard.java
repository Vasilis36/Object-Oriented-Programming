package vilia002.hw2;

/**
 * The board on which the game of Battleships will take place.
 * 
 * The board has a fixed size of 10x10 and is composed of {@link Cell cells}.
 * 
 * @author Vasilis Ilia
 * @version 1.0
 * @since  3/13/2023
 */
public class PlayerBoard {
	/**
	 * The size of each one of the sides of the board.
	 */
	public static final int BOARDSIZE = 10;
	private Cell[][] board;

	/**
	 * Class constructor. Initializes all the cells of the board to type "water".
	 */
	public PlayerBoard() {
		board = new Cell[BOARDSIZE][BOARDSIZE];
		
		for (int y = 0; y < BOARDSIZE; y++)
			for (int x = 0; x < BOARDSIZE; x++)
				board[x][y] = new Cell(x, y);			
	}
	
	/**
	 * Gets the type of Cell at specified coordinates.
	 * 
	 * @param x  the x-coordinate
	 * @param y  the y-coordinate
	 * @return the type of the cell at the specified coordinates
	 */
	public String getType(int x, int y) {
		return board[x][y].getType();	
	}
	
	/**
	 * Returns the symbol of Cell at specified coordinates.
	 * 
	 * @param x  the x-coordinate
	 * @param y  the y-coordinate
	 * @return the symbol of the cell at the specified coordinates
	 */
	public char getSymbol(int x, int y) {
		return board[x][y].getSymbol();
	}
	
	/**
	 * Sets the type of specified cell to a specified type.
	 * 
	 * @param x     the x-coordinate of the Cell
	 * @param y     the y-coordinate of the Cell
	 * @param type  the type to set the Cell
	 */
	public void setType(int x, int y, String type) {
		board[x][y].setType(type);
	}
	
	/**
	 * Checks whether the placement of a ship on the board is valid or not.
	 * 
	 * @param  bowX      the x-coordinate of the Bow of the ship
	 * @param  bowY      the y-coordinate of the Bow of the ship
	 * @param  size      the size of the ship
	 * @param  vertical  whether the ship is vertical or not
	 * @return true if placement is valid or false otherwise
	 */
	public boolean isShipPlacementValid(int bowX, int bowY, int size, boolean vertical) {		
		// If the cell in the position of the Bow is not water then placement is invalid.
		if (board[bowX][bowY].getType() != "water")
			return false;
		
		// Checks whether the ship is within the board's boundaries.
		if (vertical && bowY + size > BOARDSIZE)
			return false;
		
		if (!vertical && bowX + size > BOARDSIZE)
			return false;
		
		// If a cell in the position of the whole ship is not water then placement is invalid.
		if (vertical)
			for (int y = bowY; y < bowY + size; y++)
				if (board[bowX][y].getType() != "water")
					return false;
		
		if (!vertical)
			for (int x = bowX; x < bowX + size; x++)
				if (board[x][bowY].getType() != "water")
					return false;
		
		return true;
	}
	
	/**
	 * Adds a {@link Ship} to the board.
	 * 
	 * @param ship  the Ship to add to the board
	 */
	public void addShip(Ship ship) {			
		if (ship.isVertical()) {
			int x = ship.getBowX();
			
			for (int y = ship.getBowY(); y < ship.getBowY() + ship.getSize(); y++)
				board[x][y] = new Cell(x, y, "ship", ship.getSymbol());			
		}
		else {
			int y = ship.getBowY();
			
			for (int x = ship.getBowX(); x < ship.getBowX() + ship.getSize(); x++)
				board[x][y] = new Cell(x, y, "ship", ship.getSymbol());
		}		
	}
	
	/**
	 * Draws the board of the Battleships game.
	 */
	public void drawBoard() {
		System.out.print("  | ");		
		
		// Draws first line.
		for (int y = 0; y < BOARDSIZE; y++)
			System.out.print(y + " | ");
		
		System.out.println();
		drawLine();
		
		// Draws the rest lines.
		for (int y = 0; y < BOARDSIZE; y++) {
			System.out.print("|" + y + "| ");
			
			for (int x = 0; x < BOARDSIZE; x ++)
				System.out.print(board[x][y].getSymbol() + " | ");
			
			System.out.println();
			drawLine();
		}			
	}
	
	/*
	 * Private method that draws a line with specific characters.
	 */
	private void drawLine() {
		System.out.print("--|");
		
		for (int i = 0; i < BOARDSIZE; i++)
			System.out.print("---+");	
		
		System.out.println();
	}
}
