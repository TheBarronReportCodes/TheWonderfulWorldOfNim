package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.Pile;

/**
 * Tests the toString() of the Pile class
 * 
 * @author Jordan Barron
 * @version June 13th 2020
 * 
 *
 */
public class PileWhenCreatePile {

	/**
	 * Tests if a Pile object initialized with a stick size of 1 is asserted as correct
	 */
	@Test
	public void testShouldProducePileWith1Stick() {
		Pile oneStickPile = new Pile(1);
		assertEquals("Pile size: 1", oneStickPile.toString());
	}
	
	/**
	 * Tests if a Pile object initialized with a stick size of 99 is asserted as correct
	 */
	@Test
	public void testShouldProducePileWith99Sticks() {
		Pile ninetyNineStickPile = new Pile(99);
		assertEquals("Pile size: 99", ninetyNineStickPile.toString());
	}
	
	/**
	 * Tests if a Pile object initialized with a stick size of 134 is asserted as correct
	 */
	@Test
	public void testShouldProducePileWith134Sticks() {
		Pile oneHundredThirtyFourStickPile = new Pile(134);
		assertEquals("Pile size: 134", oneHundredThirtyFourStickPile.toString());
	}

}
