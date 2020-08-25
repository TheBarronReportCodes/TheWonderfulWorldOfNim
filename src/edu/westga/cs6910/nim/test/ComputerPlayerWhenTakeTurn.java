package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.HumanPlayer;
import edu.westga.cs6910.nim.model.Pile;
import edu.westga.cs6910.nim.model.strategy.CautiousStrategy;
import edu.westga.cs6910.nim.model.strategy.GreedyStrategy;

/**
 * Tests the takeTurn() of the ComputerPlayer class
 * 
 * @author Jordan Barron
 * @version June 13th 2020
 *
 */
public class ComputerPlayerWhenTakeTurn {

	/**
	 * Tests if a ComputerPlayer object initialized with 1 sticks then 1 stick left after takeTurn
	 */
	@Test
	public void testWithNewComputer1StickPileTakeTurnShouldLeave1Stick() {
		ComputerPlayer computer1 = new ComputerPlayer();
		Pile oneStickPile = new Pile(1);
		computer1.setPileForThisTurn(oneStickPile);
		computer1.takeTurn();
		assertEquals("Pile size: 1", computer1.getPileForThisTurn().toString());
	}
	
	/**
	 * Tests if a ComputerPlayer object initialized with 1 sticks then 0 stick left after takeTurn
	 */
	@Test
	public void testWithNewComputer1StickPileTakeTurnShouldLeave0Stick() {
		CautiousStrategy cautious1 = new CautiousStrategy();
		ComputerPlayer computer1 = new ComputerPlayer(cautious1);
		Pile oneStickPile = new Pile(1);
		computer1.setPileForThisTurn(oneStickPile);
		computer1.setNumberSticksToTake();
		computer1.takeTurn();
		assertEquals("Pile size: 0", computer1.getPileForThisTurn().toString());
	}
	
	/**
	 * Tests if a ComputerPlayer object initialized with 1 sticks then 0 stick left after takeTurn
	 */
	@Test
	public void testWithNewComputer10StickPileTakeTurnShouldLeave7Stick() {
		GreedyStrategy greedy1 = new GreedyStrategy();
		ComputerPlayer computer1 = new ComputerPlayer(greedy1);
		Pile tenStickPile = new Pile(10);
		computer1.setPileForThisTurn(tenStickPile);
		computer1.setNumberSticksToTake();
		computer1.takeTurn();
		assertEquals("Pile size: 7", computer1.getPileForThisTurn().toString());
	}
	
	/**
	 * Tests if a ComputerPlayer object initialized with 400 sticks then 116 stick left after takeTurn
	 */
	@Test
	public void testWithNewComputer400StickPileTakeTurnShouldLeave173Stick() {
		HumanPlayer human1 = new HumanPlayer("Nikola Tesla");
		Pile FourHundredStickPile = new Pile(400);
		human1.setPileForThisTurn(FourHundredStickPile);
		human1.setNumberSticksToTake(284);
		human1.takeTurn();
		assertEquals("Pile size: 116", human1.getPileForThisTurn().toString());
	}
	
	/**
	 * Tests if a ComputerPlayer object initialized with 800 sticks then 305 stick left after takeTurn
	 */
	@Test
	public void testWithNewComputer800StickPileTakeTurnShouldLeave305Stick() {
		HumanPlayer human1 = new HumanPlayer("Nikola Tesla");
		Pile eightHundredStickPile = new Pile(800);
		human1.setPileForThisTurn(eightHundredStickPile);
		human1.setNumberSticksToTake(495);
		human1.takeTurn();
		assertEquals("Pile size: 305", human1.getPileForThisTurn().toString());
	}

}
