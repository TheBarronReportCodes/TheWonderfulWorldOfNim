package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.Pile;

/**
 * Tests the removeSticks() of the Pile class
 * 
 * @author Jordan Barron
 * @version June 13th 2020
 *
 */
public class PileWhenRemoveSticks {

	/**
	 * Tests if a Pile object initialized with a stick size of 1 and 1 stick removed using removeSticks()
	 * asserts as correct
	 */
	@Test
	public void testWith1StickPileShouldHave0StickLeft1RemoveSticks() {
		Pile oneStickPile = new Pile(1);
		oneStickPile.removeSticks(1);
		assertEquals(0, oneStickPile.getSticksLeft());
	}
	
	/**
	 * Tests if a Pile object initialized with a stick size of 500 and 251 stick removed using removeSticks()
	 * asserts as correct
	 */
	@Test
	public void testWith500StickPileShouldHave249StickLeft251RemoveSticks() {
		Pile fiveHundredStickPile = new Pile(500);
		fiveHundredStickPile.removeSticks(251);
		assertEquals(249, fiveHundredStickPile.getSticksLeft());
	}
	
	/**
	 * Tests if a Pile object initialized with a stick size of 999 and 555 stick removed using removeSticks()
	 * asserts as correct
	 */
	@Test
	public void testWith999StickPileShouldHave444StickLeft555RemoveSticks() {
		Pile nineHundredNinetyNineStickPile = new Pile(999);
		nineHundredNinetyNineStickPile.removeSticks(555);
		assertEquals(444, nineHundredNinetyNineStickPile.getSticksLeft());
	}

}
