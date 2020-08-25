package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.HumanPlayer;
import edu.westga.cs6910.nim.model.Pile;

/**
 * Tests the takeTurn() of the HumanPlayer class
 * 
 * @author Jordan Barron
 * @version June 13th 2020
 *
 */
public class HumanPlayerWhenTakeTurn {

	/**
	 * Tests if a HumanPlayer object initialized with 1 sticks then 1 stick left after takeTurn
	 */
	@Test
	public void testWithNewHuman1StickPileTakeTurnShouldLeave1Stick() {
		HumanPlayer human1 = new HumanPlayer("Nikola Tesla");
		Pile oneStickPile = new Pile(1);
		human1.setPileForThisTurn(oneStickPile);
		human1.takeTurn();
		assertEquals("Pile size: 1", human1.getPileForThisTurn().toString());
	}
	
	/**
	 * Tests if a HumanPlayer object initialized with 1 sticks then 0 stick left after takeTurn
	 */
	@Test
	public void testWithNewHuman1StickPileTakeTurnShouldLeave0Stick() {
		HumanPlayer human1 = new HumanPlayer("Nikola Tesla");
		Pile oneStickPile = new Pile(1);
		human1.setPileForThisTurn(oneStickPile);
		human1.setNumberSticksToTake();
		human1.takeTurn();
		assertEquals("Pile size: 0", human1.getPileForThisTurn().toString());
	}
	
	/**
	 * Tests if a HumanPlayer object initialized with 400 sticks then 277 stick left after takeTurn
	 */
	@Test
	public void testWithNewHuman400StickPileTakeTurnShouldLeave277Stick() {
		HumanPlayer human1 = new HumanPlayer("Nikola Tesla");
		Pile FourHundredStickPile = new Pile(400);
		human1.setPileForThisTurn(FourHundredStickPile);
		human1.setNumberSticksToTake(123);
		human1.takeTurn();
		assertEquals("Pile size: 277", human1.getPileForThisTurn().toString());
	}
	
	/**
	 * Tests if a HumanPlayer object initialized with 800 sticks then 554 stick left after takeTurn
	 */
	@Test
	public void testWithNewHuman800StickPileTakeTurnShouldLeave554Stick() {
		HumanPlayer human1 = new HumanPlayer("Nikola Tesla");
		Pile eightHundredStickPile = new Pile(800);
		human1.setPileForThisTurn(eightHundredStickPile);
		human1.setNumberSticksToTake(246);
		human1.takeTurn();
		assertEquals("Pile size: 554", human1.getPileForThisTurn().toString());
	}

}
