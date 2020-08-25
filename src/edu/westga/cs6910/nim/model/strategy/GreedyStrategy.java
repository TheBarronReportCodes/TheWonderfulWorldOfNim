package edu.westga.cs6910.nim.model.strategy;

import edu.westga.cs6910.nim.model.Game;

/**
 * A computerPlayer strategy that takes a greedy approach
 * 
 * @author Jordan Barron
 * @version June 21st 2020
 *
 */
public class GreedyStrategy implements NumberOfSticksStrategy {
	/**
	 * Sets the strategy for the computer to take from the Pile greedy
	 * @precondition pileSize cannot be less than 0
	 * @precondition @return must be between 0 and pileSize
	 * @precondition If greedyStrategy is left with 1 stick it must still play greedy and take last stick
	 */
	@Override
	public int howManySticks(int pileSize) {
		if (pileSize < 0) {
			throw new IllegalArgumentException("Pile size cannot be less than 0");
		}
		if (pileSize == 1) {
			return 1;
		}
		int max = Math.min(pileSize - 1, Game.MAX_STICKS_PER_TURN);
		return max;
	}

}
