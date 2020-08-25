package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Pile;

/**
 * Tests the setPileForThisTurn() of the ComputerPlayer class
 * 
 * @author Jordan Barron
 * @version June 13th 2020
 *
 */
public class ComputerPlayerWhenSetPileForThisTurn {

	/**
	 * Tests if a ComputerPlayer object initialized setPileForThisTurn(1)
	 * should return 1
	 */
	@Test
	public void testComputerPlayerSetPileForThisTurn1ShouldProduce1() {
		ComputerPlayer computer1 = new ComputerPlayer();
		Pile oneStickPile = new Pile(1);
		computer1.setPileForThisTurn(oneStickPile);
		assertEquals("Pile size: 1", computer1.getPileForThisTurn().toString());
	}
	
	/**
	 * Tests if a ComputerPlayer object initialized setPileForThisTurn(99)
	 * should return 99
	 */
	@Test
	public void testComputerPlayerSetPileForThisTurn99ShouldProduce99() {
		ComputerPlayer computer1 = new ComputerPlayer();
		Pile ninetyNineStickPile = new Pile(99);
		computer1.setPileForThisTurn(ninetyNineStickPile);
		assertEquals("Pile size: 99", computer1.getPileForThisTurn().toString());
	}

	/**
	 * Tests if a ComputerPlayer object initialized setPileForThisTurn(888) then setPileForThisTurn(833)
	 * should return 833
	 */
	@Test
	public void testComputerPlayerSetPileForThisTurn888Then833ShouldProduce833() {
		ComputerPlayer computer1 = new ComputerPlayer();
		Pile eightHundredEightyEightStickPile = new Pile(888);
		computer1.setPileForThisTurn(eightHundredEightyEightStickPile);
		Pile eightHundredThirtythreeStickPile = new Pile(833);
		computer1.setPileForThisTurn(eightHundredThirtythreeStickPile);
		assertEquals("Pile size: 833", computer1.getPileForThisTurn().toString());
	}


}
