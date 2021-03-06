package edu.westga.cs6910.nim.model;

/**
 * AbstractPlayer defines the unimplemented and implemented methods that will
 * be used by the HumanPlayer and ComputerPlayer class
 * 
 * @author Jordan Barron
 * @version June 6th, 2020
 *
 */
public abstract class AbstractPlayer implements Player {
	private static final String NAME = "Simple computer";
	private String name;
	private int sticksToTake;
	private Pile thePile;
	
	/**
	 * Constructor used to represent the Simple Computer player
	 * 0 parameter constructor
	 */
	public AbstractPlayer() {
		this.name = NAME;
		this.sticksToTake = 0;
	}
	
	/**
	 * Constructor used to represent the Human player
	 * 1 parameter constructor
	 * @param name The name of the player
	 */
	public AbstractPlayer(String name) {
		this.name = name;
		this.sticksToTake = 0;
	}
	
	@Override
	/**
	 * @see Player#takeTurn()
	 */	
	public void takeTurn() {				
		this.thePile.removeSticks(this.sticksToTake);
	}
	
	@Override
	/**
	 * @see Player#setPileForThisTurn(Pile)
	 */	
	public void setPileForThisTurn(Pile aPile) {
		this.thePile = aPile;
	}
	
	@Override
	/**
	 * Implements Player's setNumberSticksToTake(int), but is not
	 * normally called by clients objects. Instead, clients usually
	 * call the 0-parameter version.
	 * 
	 * @see Player#setNumberSticksToTake(int)
	 */
	public void setNumberSticksToTake(int number) {
		this.sticksToTake = number;
	}
	
	@Override	
	/**
	 * Implements Player's setNumberSticksToTake() to set the number
	 * of sticks to 1.
	 * 
	 * @ensure  sticksOnThisTurn() == 1
	 * 
	 * @see Player#setNumberSticksToTake()
	 */
	public void setNumberSticksToTake() {
		this.sticksToTake = 1;
	}
	
	@Override	
	/**
	 * @see Player#getName()
	 */
	public String getName() {
		return this.name;
	}
	
	@Override	
	/**
	 * @see Player#getSticksOnThisTurn()
	 */
	public int getSticksOnThisTurn() {
		return this.sticksToTake;
	}
	
	@Override	
	/**
	 * @see Player#getPileForThisTurn()
	 */
	public Pile getPileForThisTurn() {
		return this.thePile;
	}
}
