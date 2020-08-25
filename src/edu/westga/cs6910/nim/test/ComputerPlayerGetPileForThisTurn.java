package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Pile;

/**
 * Tests the getPileForThisTurn() of the ComputerPlayer class
 * 
 * @author Jordan Barron
 * @version June 13th 2020
 *
 */
public class ComputerPlayerGetPileForThisTurn {

	/**
	 * Tests if a ComputerPlayer object initialized returns Pile Size: 1
	 * using getPileForThisTurn()
	 */
	@Test
	public void testWithNewComputerGetPileShouldHavePileSize1() {
		ComputerPlayer computer1 = new ComputerPlayer();
		Pile oneStickPile = new Pile(1);
		computer1.setPileForThisTurn(oneStickPile);
		assertEquals("Pile size: 1", computer1.getPileForThisTurn().toString());
	}
	
	/**
	 * Tests if a ComputerPlayer object initialized returns Pile Size: 773
	 * using getPileForThisTurn()
	 */
	@Test
	public void testWithNewComputerGetPileShouldHavePileSize773() {
		ComputerPlayer computer1 = new ComputerPlayer();
		Pile sevenHundredSeventyThreeStickPile = new Pile(773);
		computer1.setPileForThisTurn(sevenHundredSeventyThreeStickPile);
		assertEquals("Pile size: 773", computer1.getPileForThisTurn().toString());
	}
	
	/**
	 * Tests if a ComputerPlayer object initialized returns Pile Size: 560 in the end
	 * using getPileForThisTurn()
	 */
	@Test
	public void testWithNewComputerGetPileShouldHavePileSize560() {
		ComputerPlayer computer1 = new ComputerPlayer();
		Pile fourHundredTwoStickPile = new Pile(402);
		computer1.setPileForThisTurn(fourHundredTwoStickPile);
		Pile fiveHundredSixtyStickPile = new Pile(560);
		computer1.setPileForThisTurn(fiveHundredSixtyStickPile);
		assertEquals("Pile size: 560", computer1.getPileForThisTurn().toString());
	}

}
