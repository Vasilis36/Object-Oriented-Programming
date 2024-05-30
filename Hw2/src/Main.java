package vilia002.hw2;

/**
 * Starts the game of Battleships.
 * 
 * @author Vasilis Ilia
 * @version 1.0
 * @since 3/13/2023
 */
public class Main {
	
	/**
	 * Class constructor.
	 */
	public Main() {
	}
	
	/**
	 * Main method.
	 * 
	 * Instantiates {@link BattleshipsGame} and calls {@link BattleshipsGame#startGame()}.
	 * 
	 * @param args  the command line arguments
	 */
	public static void main(String[] args) {
		BattleshipsGame game = new BattleshipsGame();
		game.startGame();
	}
}
