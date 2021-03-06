package edu.westga.cs6910.nim.model;

/**
 * HumanPlayer represents a human player in the game Nim.
 * 
 * @author CS6910
 * @version Summer 2020
 */
public class HumanPlayer extends AbstractPlayer {

	/**
	 * Creates a new ComputerPlayer with the specified name.
	 * 
	 * @param name
	 *            this Player's name
	 * 
	 * @requires name != null
	 * @ensure name().equals(name) && sticksRemoved() == 0
	 */
	public HumanPlayer(String name) {
		super(name);
		if (name == null) {
			throw new IllegalArgumentException("Name cannot be null");
		}
	}
}
