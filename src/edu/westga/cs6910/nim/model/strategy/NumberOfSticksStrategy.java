package edu.westga.cs6910.nim.model.strategy;

/**
 * Defines the common interface for all the game-play algorithms for the 1 Pile version of Num
 * @author Jordan Barron
 * @version June 20th 2020
 *
 */
public interface NumberOfSticksStrategy {
	/**
	 * Set a specified number of sticks to be taken from the pile
	 * @return Returns a number of sticks to take that must be between 0 and the size of the pile
	 * @param pileSize the maximum size of the pile from which sticks can be taken
	 * 
	 * @requires pileSize > 0 
	 * @requires sticks taken must be > 0 && <= pileSize
	 */
	int howManySticks(int pileSize);

}
