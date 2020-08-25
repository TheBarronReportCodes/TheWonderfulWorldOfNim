package edu.westga.cs6910.nim.model;

/**
 * Represents a countDown timer
 * 
 * @author Jordan Barron
 * @version June 28th 2020
 *
 */
public class CountDown {
	private int theSecondsLeft;
	private boolean isTimeUp;
	
	/**
	 * Creates the CountDown clock beginning with the set number of seconds
	 */
	public CountDown() {
		this.theSecondsLeft = 15;
		this.isTimeUp = false;
	}
	
	/**
	 * Creates the CountDown clock beginning with the set number of seconds
	 * @param seconds a set number of seconds for the countdown
	 */
	public CountDown(int seconds) {
		this();
		if (seconds < 1) {
			throw new IllegalArgumentException("Cannot have counter equal to or below 0");
		}
		this.theSecondsLeft = seconds;
	}
	
	/**
	 * begins the timer in which the task will be run
	 */
	public void countTimeDown() {
		this.theSecondsLeft--;
		if (this.theSecondsLeft <= 0) {
			this.isTimeUp = true;
		}
	}
	
	/**
	 * returns whether the countDown time is up or not
	 * @return Returns if time is up or not
	 */
	public boolean isTimeUp() {
		return this.isTimeUp;
	}

	/**
	 * Returns the number of seconds left in the countDown
	 * @return Returns the number of seconds left
	 */
	public int getTheSecondsLeft() {
		return this.theSecondsLeft;
	}
	
	/**
	 * Returns a String representing the timer
	 * 
	 * @return a String representation of the timer
	 */
	@Override
	public String toString() {
		String result = "Timer: " + this.getTheSecondsLeft() + " seconds";
		return result;
	}
}
