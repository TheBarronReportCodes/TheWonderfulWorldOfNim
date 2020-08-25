package edu.westga.cs6910.nim.model.strategy;

/**
 * A computerPlayer strategy that takes a conservative approach
 * 
 * @author Jordan Barron
 * @version June 20th 2020
 *
 */
public class CautiousStrategy implements NumberOfSticksStrategy {
	/**
	 * Sets the strategy for the computer to take from the Pile cautiously
	 * @precondition pileSize cannot be less than 0
	 * @precondition @return must be between 0 and pileSize
	 */
	@Override
	public int howManySticks(int pileSize) {
		if (pileSize < 0) {
			throw new IllegalArgumentException("Pile size cannot be less than 0");
		}
		return 1;
	}

}
