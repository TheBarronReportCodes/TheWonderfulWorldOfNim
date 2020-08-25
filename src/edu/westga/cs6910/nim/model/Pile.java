package edu.westga.cs6910.nim.model;

/**
 * A pile of sticks for playing Nim.
 * @author CS6910
 * @version Summer 2020
 */
public class Pile {

	private int sticks;

	/**
	 * Creates a new Pile with the specified number of sticks.
	 * @param	sticks	The number of sticks in the Pile
	 * 
	 * @require sticks > 0
	 * @ensure sticksLeft() == sticks
	 */
	public Pile(int sticks) {
		if (sticks < 0) {
			throw new IllegalArgumentException("Pile of sticks cannot be less than 0");
		}
		this.sticks = sticks;
	}
	
	/**
	 * Reduces the number of sticks by the specified amount.
	 * @param	number	The number of sticks to be removed
	 * 
	 * @require number > 0 && number <= this.sticksLeft()
	 * @ensure this.sticksLeft() == sticksLeft() - number
	 */
	public void removeSticks(int number) {
		if (number < 0 || number  > this.getSticksLeft()) {
			throw new IllegalArgumentException("Number of sticks to remove cannot be greater than 0 or greater that the amount of sticks left in the pile");
		}
		this.sticks -= number;
	}
	
	/**
	 * Returns the number of sticks remaining in this Pile.
	 * 
	 * @return the size of this Pile
	 */
	public int getSticksLeft() {
		return this.sticks;
	}

	/**
	 * Returns a String representation of this Pile.
	 * 
	 * @return "Pile size: n", where n is the number of sticks in this Pile
	 */
	public String toString() {
		return "Pile size: " + this.sticks;
	}
}
