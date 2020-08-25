package edu.westga.cs6910.nim.model.strategy;

import edu.westga.cs6910.nim.model.Game;

/**
 * A computerPlayer strategy that takes a random approach
 * 
 * @author Jordan Barron
 * @version June 21st 2020
 *
 */
public class RandomStrategy implements NumberOfSticksStrategy {
	/**
	 * Sets the strategy for the computer to take from the Pile randomly
	 * @precondition pileSize cannot be less than 0
	 * @precondition @return must be between 0 and pileSize
	 */
	@Override
	public int howManySticks(int pileSize) {
		if (pileSize < 0) {
			throw new IllegalArgumentException("Pile size cannot be less than 0");
		}
		
		if (pileSize <= Game.MAX_STICKS_PER_TURN) {
			int max = pileSize - 1;
			int min = 1;
			int range = max - min + 1;
			int random = (int) (Math.random() * range) + min;
			return random;	
		} else {
			int max = Game.MAX_STICKS_PER_TURN;
			int min = 1;
			int range = max - min + 1;
			int random = (int) (Math.random() * range) + min;
			return random;
		}
	}

}
