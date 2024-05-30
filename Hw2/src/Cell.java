package vilia002.hw2;


/**
 * Describes a cell.
 * 
 * A cell has coordinates x and y, a type and a character for symbol.
 * 
 * @author Vasilis Ilia
 * @version 1.0
 * @since 3/13/2023
 */
public class Cell {
	private int x;
	private int y;
	private String type;
	private char symbol;
	
	/**
	 * Class constructor, specifying Cell's coordinates, type and symbol.
	 *  
	 * @param x       the x-coordinate or horizontal coordinate of the Cell
	 * @param y       the y-coordinate or vertical coordinate of the Cell
	 * @param type    the type of the Cell
	 * @param symbol  a character the Cell uses for its symbol
	 */
	public Cell(int x, int y, String type, char symbol) {
		this.x = x;
		this.y = y;
		this.type = type;
		this.symbol = symbol;
	}
	
	/**
	 * Class constructor, specifying Cell's coordinates.
	 * 
	 * @param x  the x-coordinate
	 * @param y  the y-coordinate
	 */
	public Cell(int x, int y) {
		this(x, y, "water", ' ');
	}
	
	/**
	 * Copy constructor, specifying the Cell to copy.
	 * 
	 * @param cell  the Cell to copy
	 */
	public Cell(Cell cell) {
		this(cell.x, cell.y, cell.type, cell.symbol);		
	}	
	
	/**
	 * Gets the x-coordinate of the Cell.
	 * 
	 * @return the x-coordinate
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Gets the y-coordinate of the Cell.
	 * 
	 * @return the y-coordinate
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Gets the type of the Cell.
	 * 
	 * @return the type of the Cell
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Gets the symbol of the Cell.
	 * 
	 * @return the symbol of the Cell
	 */
	public char getSymbol() {
		return symbol;		
	}
	
	/**
	 * Sets the type of the Cell to a specified type.
	 * 
	 * Also updates the cell's symbol.
	 * 
	 * @param type  the type to set the Cell
	 */
	public void setType(String type) {
		this.type = type;
		
		if (type == "hit")
			symbol = 'H';
	}
}
