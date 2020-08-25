package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Pile;
import edu.westga.cs6910.nim.model.strategy.CautiousStrategy;
import edu.westga.cs6910.nim.model.strategy.GreedyStrategy;

/**
 * Tests the setNumberSticksToTake() of the ComputerPlayer class
 * 
 * @author Jordan Barron
 * @version June 13th 2020
 *
 */
public class ComputerPlayerWhenSetNumberSticksToTake {

	/**
	 * Tests if a ComputerPlayer object initialized setNumberSticksToTake
	 * returns 1
	 */
	@Test
	public void testWithNewComputerSticksToTakeShouldBe1() {
		CautiousStrategy cautious1 = new CautiousStrategy();
		ComputerPlayer computer1 = new ComputerPlayer(cautious1);
		Pile oneStickPile = new Pile(1);
		computer1.setPileForThisTurn(oneStickPile);
		computer1.setNumberSticksToTake();
		assertEquals(1, computer1.getSticksOnThisTurn());
	}
	
	/**
	 * Tests if a ComputerPlayer object initialized setNumberSticksToTake()
	 * returns 3
	 */
	@Test
	public void testWithNewComputerSticksToTakeShouldBe3() {
		GreedyStrategy greedy1 = new GreedyStrategy();
		ComputerPlayer computer1 = new ComputerPlayer(greedy1);
		Pile tenStickPile = new Pile(10);
		computer1.setPileForThisTurn(tenStickPile);
		computer1.setNumberSticksToTake();
		assertEquals(3, computer1.getSticksOnThisTurn());
	}
	
	/**
	 * Tests if a ComputerPlayer object initialized setNumberSticksToTake() 
	 * returns 2
	 */
	@Test
	public void testWithNewComputerSticksToTakeShouldBe2() {
		GreedyStrategy greedy1 = new GreedyStrategy();
		ComputerPlayer computer1 = new ComputerPlayer(greedy1);
		Pile threeStickPile = new Pile(3);
		computer1.setPileForThisTurn(threeStickPile);
		computer1.setNumberSticksToTake();
		assertEquals(2, computer1.getSticksOnThisTurn());
	}

}
