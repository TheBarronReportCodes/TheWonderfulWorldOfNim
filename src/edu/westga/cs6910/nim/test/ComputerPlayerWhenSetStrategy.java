package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.strategy.CautiousStrategy;
import edu.westga.cs6910.nim.model.strategy.GreedyStrategy;
import edu.westga.cs6910.nim.model.strategy.RandomStrategy;

/**
 * Tests the setStrategy() of the ComputerPlayer class
 * @author Jordan Barron
 * @version June 21st, 2020
 *
 */
public class ComputerPlayerWhenSetStrategy {

	/**
	 * ComputerPlayer should become CautiousStrategy after setStrategy
	 */
	@Test
	public void testComputerPlayerWhenSetStrategyShouldSetToCautiousStrategyObject() {
		CautiousStrategy cautious1 = new CautiousStrategy();
		GreedyStrategy greedy1 = new GreedyStrategy();
		ComputerPlayer computer1 = new ComputerPlayer(cautious1);
		computer1.setStrategy(greedy1);
		computer1.setStrategy(cautious1);
		assertEquals(cautious1, computer1.getStrategy());
	}
	
	/**
	 * ComputerPlayer should become GreedyStrategy after setStrategy
	 */
	@Test
	public void testComputerPlayerWhenSetStrategyShouldSetToGreedyStrategyObject() {
		CautiousStrategy cautious1 = new CautiousStrategy();
		GreedyStrategy greedy1 = new GreedyStrategy();
		ComputerPlayer computer1 = new ComputerPlayer(cautious1);
		computer1.setStrategy(greedy1);
		assertEquals(greedy1, computer1.getStrategy());
	}
	
	/**
	 * ComputerPlayer should become RandomStrategy after setStrategy
	 */
	@Test
	public void testComputerPlayerWhenSetStrategyShouldSetToRandomStrategyObject() {
		CautiousStrategy cautious1 = new CautiousStrategy();
		GreedyStrategy greedy1 = new GreedyStrategy();
		RandomStrategy random1 = new RandomStrategy();
		ComputerPlayer computer1 = new ComputerPlayer(cautious1);
		computer1.setStrategy(greedy1);
		computer1.setStrategy(random1);
		assertEquals(random1, computer1.getStrategy());
	}

}
