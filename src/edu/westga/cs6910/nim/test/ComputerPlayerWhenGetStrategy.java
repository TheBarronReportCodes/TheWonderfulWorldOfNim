package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.strategy.CautiousStrategy;
import edu.westga.cs6910.nim.model.strategy.GreedyStrategy;
import edu.westga.cs6910.nim.model.strategy.RandomStrategy;

/**
 * Tests the getStrategy() of the ComputerPlayer class
 * @author Jordan Barron
 * @version June 21st, 2020
 *
 */
public class ComputerPlayerWhenGetStrategy {

	/**
	 * ComputerPlayer should be CautiousStrategy after getStrategy
	 */
	@Test
	public void testComputerPlayerWhenGetStrategyShouldReturnCautiousStrategyObject() {
		CautiousStrategy cautious1 = new CautiousStrategy();
		ComputerPlayer computer1 = new ComputerPlayer(cautious1);

		assertEquals(cautious1, computer1.getStrategy());
	}
	
	/**
	 * ComputerPlayer should be GreedyStrategy after getStrategy
	 */
	@Test
	public void testComputerPlayerWhenGetStrategyShouldReturnGreedyStrategyObject() {
		GreedyStrategy greedy1 = new GreedyStrategy();
		ComputerPlayer computer1 = new ComputerPlayer(greedy1);

		assertEquals(greedy1, computer1.getStrategy());
	}
	
	/**
	 * ComputerPlayer should be RandomStrategy after getStrategy
	 */
	@Test
	public void testComputerPlayerWhenGetStrategyShouldReturnRandomStrategyObject() {
		RandomStrategy random1 = new RandomStrategy();
		ComputerPlayer computer1 = new ComputerPlayer(random1);

		assertEquals(random1, computer1.getStrategy());
	}

}
