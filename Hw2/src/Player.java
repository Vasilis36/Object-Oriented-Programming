package vilia002.hw2;

/**
 * Describes a player of the game Battleships.
 * 
 * A player has a {@link PlayerBoard}, a name and 5 battleships of different types.
 * Player loses if all of their {@link Ship ships} are destroyed.
 * 
 * @author Vasilis Ilia
 * @version 1.0
 * @since 3/13/2023
 */
public class Player {
	private PlayerBoard board;
	private String name;
	private Carrier carrier;
	private Destroyer destroyer;
	private Frigate frigate;
	private Corvette corvette;
	private Submarine submarine;
	private boolean lost = false;

	/**
	 * Class constructor, specifying player name.
	 * 
	 * @param name  the name of the player
	 */
	public Player(String name) {
		board = new PlayerBoard();
		this.name = name;

		addShips();		
	}

	/*
	 * Private method for creating the ships of the player and adding them to the player board.
	 */
	private void addShips() {
		addCarrier();
		addFrigate();
		addDestroyer();
		addCorvette();
		addSubmarine();		
	}	

	/*
	 * Private method for creating a Carrier ship and adding it to the player board.
	 */
	private void addCarrier() {		
		int shipSize = new Carrier().getSize();
		int[] coordinates = new int[2];

		boolean vertical = shipPosition(coordinates, shipSize);

		carrier = new Carrier(coordinates[0], coordinates[1], vertical);
		board.addShip(carrier);
	}

	/*
	 * Private method for creating a Frigate ship and adding it to the player board.
	 */
	private void addFrigate() {		
		int shipSize = new Frigate().getSize();
		int[] coordinates = new int[2];

		boolean vertical = shipPosition(coordinates, shipSize);

		frigate = new Frigate(coordinates[0], coordinates[1], vertical);
		board.addShip(frigate);
	}

	/*
	 * Private method for creating a Destroyer ship and adding it to the player board.
	 */
	private void addDestroyer() {		
		int shipSize = new Destroyer().getSize();
		int[] coordinates = new int[2];

		boolean vertical = shipPosition(coordinates, shipSize);

		destroyer = new Destroyer(coordinates[0], coordinates[1], vertical);
		board.addShip(destroyer);
	}

	/*
	 * Private method for creating a Corvette ship and adding it to the player board.
	 */
	private void addCorvette() {		
		int shipSize = new Corvette().getSize();
		int[] coordinates = new int[2];

		boolean vertical = shipPosition(coordinates, shipSize);

		corvette = new Corvette(coordinates[0], coordinates[1], vertical);
		board.addShip(corvette);
	}

	/*
	 * Private method for creating a Submarine ship and adding it to the player board.
	 */
	private void addSubmarine() {		
		int shipSize = new Submarine().getSize();
		int[] coordinates = new int[2];

		boolean vertical = shipPosition(coordinates, shipSize);

		submarine = new Submarine(coordinates[0], coordinates[1], vertical);
		board.addShip(submarine);
	}

	/*
	 * Private method for finding random valid coordinates[] for the Bow of the ship
	 * of a given shipSize. Returns the direction of the ship.
	 */
	private boolean shipPosition(int coordinates[], int shipSize) {
		int boardSize = PlayerBoard.BOARDSIZE;
		boolean vertical;
		int x = coordinates[0];
		int y = coordinates[1];

		// Finds ships direction.
		if (Math.random() > 0.5)
			vertical = true;
		else 
			vertical = false;

		// Finds valid coordinates, depending on the direction of ship.
		if (vertical) {
			do {
				x = getRandomInteger(boardSize - 1);
				y = getRandomInteger(boardSize - shipSize);			
			} while(!board.isShipPlacementValid(x, y, shipSize, vertical));
		}
		else
			do {
				x = getRandomInteger(boardSize - shipSize);
				y = getRandomInteger(boardSize - 1);
			} while(!board.isShipPlacementValid(x, y, shipSize, vertical));	

		coordinates[0] = x;
		coordinates[1] = y;
		return vertical;
	}

	/*
	 *  Private method for calculating a random integer number from 0 to end
	 */
	private int getRandomInteger(int end) {
		return (int) (Math.random() * (end + 1));
	}
	
	/**
	 * Checks whether the Player has lost.
	 * 
	 * @return true if the player has lost and false otherwise.
	 */
	public boolean hasLost() {
		return lost;		
	}
	
	/**
	 * Gets the player's name.
	 * 
	 * @return the player's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the player's Board.
	 * 
	 * @return the player's board
	 */
	public PlayerBoard getBoard() {
		return board;
	}
	
	/**
	 * Gets Player's Carrier ship
	 * 
	 * @return Carrier ship
	 */
	public Ship getCarrier() {
		return carrier;
	}
	
	/**
	 * Gets Player's Destroyer ship
	 * 
	 * @return Destroyer ship
	 */
	public Ship getDestroyer() {
		return destroyer;
	}
	
	/**
	 * Gets Player's Frigate ship
	 * 
	 * @return Frigate ship
	 */
	public Ship getFrigate() {
		return frigate;
	}
	
	/**
	 * Gets Player's Corvette ship
	 * 
	 * @return Corvette ship
	 */
	public Ship getCorvette() {
		return corvette;
	}
	
	/**
	 * Gets Player's Submarine ship
	 * 
	 * @return Submarine ship
	 */
	public Ship getSubmarine() {
		return submarine;
	}
	
	/**
	 * Updates status of player to lost if he has taken the maximum amount of possible hits.
	 */
	public void checkIfLost() {
		if (carrier.isDestroyed() && destroyer.isDestroyed() && frigate.isDestroyed()
				&& corvette.isDestroyed() && submarine.isDestroyed())
			lost = true;
	}
}
