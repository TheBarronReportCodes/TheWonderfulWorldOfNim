package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.strategy.CautiousStrategy;
import edu.westga.cs6910.nim.model.strategy.GreedyStrategy;
import edu.westga.cs6910.nim.model.strategy.RandomStrategy;
/**
 * Tests the getSticksOnThisTurn() of the ComputerPlayer class
 * 
 * @author Jordan Barron
 * @version June 14th 2020
 *
 */
public class ComputerPlayerGetSticksOnThisTurn {
	
	/**
	 * Tests if a ComputerPlayer object initialized returns 0
	 * using getSticksOnThisTurn
	 */
	@Test
	public void testWithNewComputerCautiousStrategyShouldHave0SticksOnThisTurnTestOne() {
		CautiousStrategy cautious1 = new CautiousStrategy();
		ComputerPlayer computer1 = new ComputerPlayer(cautious1);
		assertEquals(0, computer1.getSticksOnThisTurn());
	}
	
	/**
	 * Tests if a ComputerPlayer object initialized returns 398
	 * using getSticksOnThisTurn
	 */
	@Test
	public void testWithNewComputerGreedyStrategyShouldHave0SticksOnThisTurnTestTwo() {
		GreedyStrategy greedy1 = new GreedyStrategy();
		ComputerPlayer computer1 = new ComputerPlayer(greedy1);
		assertEquals(0, computer1.getSticksOnThisTurn());
	}
	
	/**
	 * Tests if a ComputerPlayer object initialized returns 419 in the end
	 * using getSticksOnThisTurn
	 */
	@Test
	public void testWithNewComputerRandomStrategyShouldHave0SticksOnThisTurnTestThree() {
		RandomStrategy random1 = new RandomStrategy();
		ComputerPlayer computer1 = new ComputerPlayer(random1);
		assertEquals(0, computer1.getSticksOnThisTurn());
	}

}
