package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.HumanPlayer;

/**
 * Tests the getSticksOnThisTurn() of the HumanPlayer class
 * 
 * @author Jordan Barron
 * @version June 14th 2020
 *
 */
public class HumanPlayerGetSticksOnThisTurn {

	/**
	 * Tests if a HumanPlayer object initialized returns 0
	 * using getSticksOnThisTurn
	 */
	@Test
	public void testWithNewHumanShouldHave0SticksOnThisTurnTestOne() {
		HumanPlayer human1 = new HumanPlayer("Nikola Tesla");
		assertEquals(0, human1.getSticksOnThisTurn()); 
	}
	
	/**
	 * Tests if a HumanPlayer object initialized returns 331
	 * using getSticksOnThisTurn
	 */
	@Test
	public void testWithNewHumanShouldHave331Sticks() {
		HumanPlayer human1 = new HumanPlayer("Nikola Tesla");
		human1.setNumberSticksToTake(331);
		assertEquals(331, human1.getSticksOnThisTurn()); 
	}
	
	/**
	 * Tests if a HumanPlayer object initialized returns 484 in the end
	 * using getSticksOnThisTurn
	 */
	@Test
	public void testWithNewHumanShouldHave484SticksInTheEnd() {
		HumanPlayer human1 = new HumanPlayer("Nikola Tesla");
		human1.setNumberSticksToTake(32);
		human1.setNumberSticksToTake(484);
		assertEquals(484, human1.getSticksOnThisTurn()); 
	}

}
