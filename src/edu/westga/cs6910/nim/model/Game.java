package edu.westga.cs6910.nim.model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Game represents a Nim game with 1 pile of sticks.
 * This class was started by CS6910
 * 
 * @author Jordan Barron
 * @version June 6th, 2020
 */
public class Game implements Observable {
	/** Constant to define the initial pile size */
	public static final int INITIAL_PILE_SIZE = 7;
	
	/** Constant to define the Maximum pile size */
	public static final int MAX_PILE_SIZE = 50;
	
	/** Constant to define the maximum number of sticks to be
	 *  removed per turn */
	public static final int MAX_STICKS_PER_TURN = 3;

	private HumanPlayer theHuman;
	private ComputerPlayer theComputer;

	private ObjectProperty<Player> currentPlayerObject;	
	
	private Pile thePile;

	/**
	 * Creates a nim Game with the specified Players and a pile
	 * of INITIAL_PILE_SIZE sticks.
	 * 
	 * @param theComputer
	 *            the automated player
	 * @param theHuman
	 *            the human player
	 * 
	 * @require theHuman != null && theComputer != null
	 * 
	 * @ensure humanPlayer().equals(theHuman) &&
	 *         computerPlayer.equals(theComputer) &&
	 *         sticksLeft() == INITIAL_PILE_SIZE
	 */
	public Game(HumanPlayer theHuman, ComputerPlayer theComputer) {
		if (theHuman == null || theComputer == null) {
			throw new IllegalArgumentException("The human or computer player cannot be equal to null");
		}
		this.theHuman = theHuman;
		this.theComputer = theComputer;

		this.currentPlayerObject = new SimpleObjectProperty<Player>();
		
		this.setPile(INITIAL_PILE_SIZE);
	}

	/**
	 * Initializes the game for play.
	 * 
	 * @param firstPlayer 	the Player who takes the first turn
	 * 
	 * @require firstPlayer != null && 
	 * 
	 * @ensures whoseTurn().equals(firstPlayer) &&
	 * 			sticksLeft() == INITIAL_PILE_SIZE
	 */
	public void startNewGame(Player firstPlayer) {
		if (firstPlayer == null) {
			throw new IllegalArgumentException("first player cannot be null");
		} else if (this.thePile == null) {
			throw new IllegalArgumentException("cannot start game with a null pile");
		}
		this.currentPlayerObject.setValue(firstPlayer); 
	}

	/**
	 * Conducts a move in the game, allowing the appropriate Player to
	 * take a turn. Has no effect if the game is over.
	 * 
	 * @requires !isGameOver()
	 * 
	 * @ensures !whoseTurn().equals(whoseTurn()@prev) &&
	 * 			sticksLeft() < sticksLeft()@prev
	 */
	public void play() {
		if (this.currentPlayerObject.getValue() == this.theHuman) {
			this.theHuman.takeTurn();
			this.swapWhoseTurn();
		} else if (this.currentPlayerObject.getValue() == this.theComputer) {
			this.theComputer.takeTurn();
			this.swapWhoseTurn();
		}

		this.isGameOver();
	}
	
	/**
	 * Changes the number of sticks in the initial pile
	 * @param pileSize The number of sticks in the pile
	 */
	public void setPile(int pileSize) {
		if (pileSize < Game.INITIAL_PILE_SIZE) {
			throw new IllegalArgumentException("Not good to set pile size less than initial size");
		} else if (pileSize > Game.MAX_PILE_SIZE) {
			throw new IllegalArgumentException("Cannot exceed maximum pile size");
		}
		this.thePile = new Pile(pileSize);
	}

	/**
	 * Returns the human Player object.
	 * 
	 * @return the human Player
	 */
	public HumanPlayer getHumanPlayer() {
		return this.theHuman;
	}

	/**
	 * Returns the computer Player object.
	 * 
	 * @return the computer Player
	 */
	public ComputerPlayer getComputerPlayer() {
		return this.theComputer;
	}
	
	/**
	 * Returns the Player whose turn it is.
	 * 
	 * @return	the current Player
	 */
	public Player getCurrentPlayer() {
		return this.currentPlayerObject.getValue();
	}

	/**
	 * Returns the number of sticks remaining in the pile.
	 * 
	 * @return how many sticks are left in the pile
	 */
	public int getSticksLeft() {
		return this.thePile.getSticksLeft();
	}

	/**
	 * Return whether the game is over.
	 * 
	 * @return true iff sticksLeft() <= 1 or if isTimeUp() == true;
	 */
	public boolean isGameOver() {		
		return this.thePile.getSticksLeft() <= 1;
	}
	
	/**
	 * Returns the Pile used in this Game.
	 * 
	 * @return	the Pile
	 */
	public Pile getPile() {
		return this.thePile;
	}

	/**
	 * Returns a String representing the pile size, or, if
	 * the game is over, the name of the winner.
	 * 
	 * @return a String representation of this Game
	 */
	@Override
	public String toString() {
		if (!this.isGameOver()) {
			return " Pile size: " + this.thePile.getSticksLeft();
		}
		
		String result = "Game over! Winner: ";
		if (this.currentPlayerObject.getValue() == this.theComputer) {
			result += this.theHuman.getName();
		} else {
			result += this.theComputer.getName();
		}
		return result;
	}
	
	/**
	 * Swaps the object that controls the current player
	 */
	private void swapWhoseTurn() {
		if (this.currentPlayerObject.getValue() == this.theHuman) {
			this.currentPlayerObject.setValue(this.theComputer);
		} else if (this.currentPlayerObject.getValue() == this.theComputer) {
			this.currentPlayerObject.setValue(this.theHuman);
		}
	}

	@Override
	public void addListener(InvalidationListener listener) {
		this.currentPlayerObject.addListener(listener);
	}

	@Override
	public void removeListener(InvalidationListener listener) {
		this.currentPlayerObject.removeListener(listener);
	}
}
