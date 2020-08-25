package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.HumanPlayer;
import edu.westga.cs6910.nim.model.Pile;

/**
 * Tests the setPileForThisTurn() of the HumanPlayer class
 * 
 * @author Jordan Barron
 * @version June 13th 2020
 *
 */
public class HumanPlayerWhenSetPileForThisTurn {

	/**
	 * Tests if a ComputerPlayer object initialized setPileForThisTurn(1)
	 * should return 1
	 */
	@Test
	public void testHumanPlayerSetPileForThisTurn1ShouldProduce1() {
		HumanPlayer human1 = new HumanPlayer("Nikola Tesla");
		Pile oneStickPile = new Pile(1);
		human1.setPileForThisTurn(oneStickPile);
		assertEquals("Pile size: 1", human1.getPileForThisTurn().toString()); 
	}
	
	/**
	 * Tests if a ComputerPlayer object initialized setPileForThisTurn(123)
	 * should return 123
	 */
	@Test
	public void testHumanPlayerSetPileForThisTurn1ShouldProduce123() {
		HumanPlayer human1 = new HumanPlayer("Nikola Tesla");
		Pile oneHundredTwentyThreeStickPile = new Pile(123);
		human1.setPileForThisTurn(oneHundredTwentyThreeStickPile);
		assertEquals("Pile size: 123", human1.getPileForThisTurn().toString()); 
	}
	
	/**
	 * Tests if a ComputerPlayer object initialized setPileForThisTurn(444) then setPileForThisTurn(555)
	 * should return 555
	 */
	@Test
	public void testHumanPlayerSetPileForThisTurn444Then555ShouldProduce555() {
		HumanPlayer human1 = new HumanPlayer("Nikola Tesla");
		Pile fourHundredFortyFourStickPile = new Pile(444);
		human1.setPileForThisTurn(fourHundredFortyFourStickPile);
		Pile fiveHundredFiftyFiveStickPile = new Pile(555);
		human1.setPileForThisTurn(fiveHundredFiftyFiveStickPile);
		assertEquals("Pile size: 555", human1.getPileForThisTurn().toString()); 
	}

}
