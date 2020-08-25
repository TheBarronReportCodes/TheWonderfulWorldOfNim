package edu.westga.cs6910.nim.model;

import edu.westga.cs6910.nim.model.strategy.NumberOfSticksStrategy;

/**
 * ComputerPlayer represents a very simple automated player in the game Nim.
 * It removes 1 stick at a time.
 * This class was started by CS6910
 * 
 * @author Jordan Barron
 * @version June 6th, 2020
 * 
 */
public class ComputerPlayer extends AbstractPlayer {
	private NumberOfSticksStrategy theStrategy;
	private int sticksToTake;
	
	/**
	 * Default constructor that creates a new ComputerPlayer with a specified name
	 * 
	 */
	public ComputerPlayer() {
		super();
	}
	
	/**
	 * Creates a new ComputerPlayer with the specified name.
	 * @param theStrategy The Parent class of strategic play for the computer player
	 */
	public ComputerPlayer(NumberOfSticksStrategy theStrategy) {
		super();
		if (theStrategy == null) {
			throw new IllegalArgumentException("The strategy cannot be null");
		}
		this.theStrategy = theStrategy;
	}
	
	/**
	 * Changes the strategy of the ComputerPlayer
	 * uses a data member of the NumberOfSticksStrategy interface
	 * @param newStrategy The strategy that the computer player will now take on
	 */
	public void setStrategy(NumberOfSticksStrategy newStrategy) {
		if (newStrategy == null) {
			throw new IllegalArgumentException("The strategy cannot be null");
		}
		this.theStrategy = newStrategy;
	}
	
	@Override	
	/**
	 * Implements Player's setNumberSticksToTake() to set the number
	 * of sticks to 1.
	 * 
	 * Overrides the method from AbstractPlayer
	 * 
	 * @ensure  sticksOnThisTurn() == 1
	 * 
	 * @see Player#setNumberSticksToTake()
	 */
	public void setNumberSticksToTake() {
		int pileSize = this.getPileForThisTurn().getSticksLeft();
		this.sticksToTake = this.theStrategy.howManySticks(pileSize);
	}
	
	@Override
	/**
	 * Overrides the method from AbstractPlayer
	 * @see Player#takeTurn()
	 */	
	public void takeTurn() {				
		this.getPileForThisTurn().removeSticks(this.sticksToTake);
	}
	
	@Override	
	/**
	 * Overrides the method from AbstractPlayer
	 * @see Player#getSticksOnThisTurn()
	 */
	public int getSticksOnThisTurn() {
		return this.sticksToTake;
	}
	
	/**
	 * Accesses the current strategy the Computer Player has in use
	 * @return the current strategy the Computer Player has in use
	 */
	public NumberOfSticksStrategy getStrategy() {
		return this.theStrategy;
	}

}
