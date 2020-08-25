package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.Pile;

/**
 * Tests the getStickLeft() of the Pile class
 * 
 * @author Jordan Barron
 * @version June 13th 2020
 *
 */
public class PileGetSticksLeft {

	/**
	 * Tests if a Pile object initialized with a stick size of 1 is asserted as correct when
	 * using getStickLeft()
	 */
	@Test
	public void testWith1StickPileShouldHave1StickLeft() {
		Pile oneStickPile = new Pile(1);
		assertEquals(1, oneStickPile.getSticksLeft());
	}
	
	/**
	 * Tests if a Pile object initialized with a stick size of 452 is asserted as correct when
	 * using getStickLeft()
	 */
	@Test
	public void testWith452StickPileShouldHave452StickLeft() {
		Pile fourHundredFiftyTwoStickPile = new Pile(452);
		assertEquals(452, fourHundredFiftyTwoStickPile.getSticksLeft());
	}
	
	/**
	 * Tests if a Pile object initialized with a stick size of 999 is asserted as correct when
	 * using getStickLeft()
	 */
	@Test
	public void testWith999StickPileShouldHave999StickLeft() {
		Pile nineHundredNinetyNineStickPile = new Pile(999);
		assertEquals(999, nineHundredNinetyNineStickPile.getSticksLeft());
	}

}
