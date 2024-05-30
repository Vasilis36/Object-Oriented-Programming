package vilia002.hw2;

import java.util.Scanner;

/**
 * Plays the game of Battleships.
 *  
 * A Battleships game has two {@link Player players}. One player plays each round. 
 * The games ends when all of a player's {@link Ship ships} are destroyed.
 * 
 * @author Vasilis Ilia
 * @version 1.0
 * @since 3/13/2023
 */
public class BattleshipsGame {
	private Player player0;
	private Player player1;
	private boolean gameOver = false;

	/**
	 * Class constructor.
	 */
	public BattleshipsGame() {
		player0 = new Player("0");
		player1 = new Player("1");
	}

	/**
	 * Starts the game of Battleships.
	 */
	public void startGame() {
		System.out.println("Welcome to the Battleship game!");
		for (int i = 0; i < 17; i++)
			System.out.print("=-");	
		
		while (!gameOver) {
			playRound(player0, player1);
			updateGameOver();

			if (gameOver)
				break;

			playRound(player1, player0);
			updateGameOver();
		}		
		System.out.println("\nWINNER IS THE:" + getWinner());		
	}

	/*
	 * Private method for playing a round of Battleships between two Players, 
	 * where one is the attacker and the other the defender.
	 */
	private void playRound(Player attacker, Player defender) {		
		System.out.println("\nPlayer: " + attacker.getName() + " your Ships:");
		attacker.getBoard().drawBoard();
		System.out.println("\nPlayer: " + attacker.getName() + " Please select 2 coordinates(0-9) to attack Enemy:");

		int attackX, attackY;  // attack coordinates the attacker gives as input
		
		do{
			Scanner read = new Scanner(System.in);
			
			String input = read.next();

			for (int i = 0; i < input.length(); i++)
				
				// If user gives a not valid number or a negative number game is aborted.
				if (input.charAt(i) < '0' || input.charAt(i) > '9') {
					System.out.println("Game Aborted");
					System.exit(0);
				}

			attackY = Integer.parseInt(input);

			input = read.next();

			for (int i = 0; i < input.length(); i++)
				if (input.charAt(i) < '0' || input.charAt(i) > '9') {
					System.out.println("Game Aborted");
					System.exit(0);
				}

			attackX = Integer.parseInt(input);	
			
			// If a coordinate is above 9 user gives coordinates again.
			if (attackX > 9 || attackY > 9)
				System.out.println("Invalid coordinates\nPlease select 2 coordinates(0-9) again:");
			
		} while(attackX > 9 || attackY > 9);
		
		playerAttack(attackX, attackY, defender);
	} 
	
	/*
	 * Private method to attack defender at specified coordinates.
	 */
	private void playerAttack(int attackX, int attackY, Player defender) {
		PlayerBoard defenderBoard = defender.getBoard();
		String type = defenderBoard.getType(attackX, attackY);
		
		// If attack misses.
		if (type == "water" || type == "hit")
			System.out.println("MISS!");
		
		// If attack hits a ship.
		else if (type == "ship") {			
			addShipHit(attackX, attackY, defender);			
			defenderBoard.setType(attackX, attackY, "hit");					
			defender.checkIfLost();
		}
	}
	
	/*
	 * Private method that adds a hit to the the ship that got hit.
	 */
	private void addShipHit(int x, int y, Player defender) {
		char symbol = defender.getBoard().getSymbol(x, y);
		
		if (symbol == defender.getCarrier().getSymbol())
			defender.getCarrier().addHit(defender.getCarrier().getSize());
		
		else if (symbol == defender.getDestroyer().getSymbol())
			defender.getDestroyer().addHit(defender.getDestroyer().getSize());
		
		else if (symbol == defender.getFrigate().getSymbol())
			defender.getFrigate().addHit(defender.getFrigate().getSize());
		
		else if (symbol == defender.getCorvette().getSymbol())
			defender.getCorvette().addHit(defender.getCorvette().getSize());
		
		else if (symbol == defender.getSubmarine().getSymbol())
			defender.getSubmarine().addHit(defender.getSubmarine().getSize());
	}

	/*
	 * Private method for updating gameOver to true if a player has lost.
	 */
	private void updateGameOver() {
		if (player0.hasLost() || player1.hasLost())
			gameOver = true;		
	}

	/*
	 * Private method for getting the winner of the game.
	 */
	private String getWinner() {
		if (player0.hasLost())
			return player1.getName();
		else
			return player0.getName();
	}
}
