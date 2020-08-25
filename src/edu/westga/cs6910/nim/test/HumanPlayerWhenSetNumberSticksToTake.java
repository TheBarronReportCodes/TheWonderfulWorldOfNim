package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.HumanPlayer;

/**
 * Tests the setNumberSticksToTake() of the HumanPlayer class
 * 
 * @author Jordan Barron
 * @version June 13th 2020
 *
 */
public class HumanPlayerWhenSetNumberSticksToTake {

	/**
	 * Tests if a HumanPlayer object initialized setNumberSticksToTake
	 * returns 1
	 */
	@Test
	public void testWithNewHumanSticksToTakeShouldBe1() {
		HumanPlayer human1 = new HumanPlayer("Nikola Tesla");
		human1.setNumberSticksToTake();
		assertEquals(1, human1.getSticksOnThisTurn()); 
	}
	
	/**
	 * Tests if a HumanPlayer object initialized setNumberSticksToTake(654)
	 * returns 654
	 */
	@Test
	public void testWithNewHumanSticksToTake654ShouldBe654() {
		HumanPlayer human1 = new HumanPlayer("Nikola Tesla");
		human1.setNumberSticksToTake(654);
		assertEquals(654, human1.getSticksOnThisTurn()); 
	}
	
	/**
	 * Tests if a HumanPlayer object initialized setNumberSticksToTake(456)
	 * returns 456
	 */
	@Test
	public void testWithNewHumanSticksToTake456ShouldBe456() {
		HumanPlayer human1 = new HumanPlayer("Nikola Tesla");
		human1.setNumberSticksToTake(456);
		assertEquals(456, human1.getSticksOnThisTurn()); 
	}

}
