package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.HumanPlayer;
import edu.westga.cs6910.nim.model.Pile;

/**
 * Tests the getPileForThisTurn() of the HumanPlayer class
 * 
 * @author Jordan Barron
 * @version June 13th 2020
 *
 */
public class HumanPlayerGetPileForThisTurn {

	/**
	 * Tests if a HumanPlayer object initialized returns pile size: 1
	 * using getPileForThisTurn()
	 */
	@Test
	public void testWithNewHumanGetPileShouldHavePileSize1() {
		HumanPlayer human1 = new HumanPlayer("Nikola Tesla");
		Pile oneStickPile = new Pile(1);
		human1.setPileForThisTurn(oneStickPile);
		assertEquals("Pile size: 1", human1.getPileForThisTurn().toString()); 
	}
	
	/**
	 * Tests if a HumanPlayer object initialized returns pile size: 291
	 * using getPileForThisTurn()
	 */
	@Test
	public void testWithNewHumanGetPileShouldHavePileSize291() {
		HumanPlayer human1 = new HumanPlayer("Nikola Tesla");
		Pile twoHundredNinetyOneStickPile = new Pile(291);
		human1.setPileForThisTurn(twoHundredNinetyOneStickPile);
		assertEquals("Pile size: 291", human1.getPileForThisTurn().toString()); 
	}
	
	/**
	 * Tests if a HumanPlayer object initialized returns pile size: 401 in the end
	 * using getPileForThisTurn()
	 */
	@Test
	public void testWithNewHumanGetPileShouldHavePileSize401() {
		HumanPlayer human1 = new HumanPlayer("Nikola Tesla");
		Pile threeHundredStickPile = new Pile(300);
		human1.setPileForThisTurn(threeHundredStickPile);
		Pile fourHundredOneStickPile = new Pile(401);
		human1.setPileForThisTurn(fourHundredOneStickPile);
		assertEquals("Pile size: 401", human1.getPileForThisTurn().toString()); 
	}

}
