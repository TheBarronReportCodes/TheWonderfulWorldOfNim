package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.HumanPlayer;

/**
 * Tests the getName() of the HumanPlayer class
 * 
 * @author Jordan Barron
 * @version June 13th 2020
 *
 */
public class HumanPlayerGetName {

	/**
	 * Tests if a HumanPlayer object initialized returns Nikola Tesla
	 * using getName()
	 */
	@Test
	public void testWithNewHumanShouldHaveNikolaTesla() {
		HumanPlayer human1 = new HumanPlayer("Nikola Tesla");
		assertEquals("Nikola Tesla", human1.getName()); 
	}
	
	/**
	 * Tests if a HumanPlayer object initialized returns Alan Turing
	 * using getName()
	 */
	@Test
	public void testWithNewHumanShouldHaveAlanTuring() {
		HumanPlayer human1 = new HumanPlayer("Alan Turing");
		assertEquals("Alan Turing", human1.getName()); 
	}
	
	/**
	 * Tests if a HumanPlayer object initialized returns Jerry Lawson
	 * using getName()
	 */
	@Test
	public void testWithNewHumanShouldHaveJerryLawson() {
		HumanPlayer human1 = new HumanPlayer("Jerry Lawson");
		assertEquals("Jerry Lawson", human1.getName()); 
	}

}
