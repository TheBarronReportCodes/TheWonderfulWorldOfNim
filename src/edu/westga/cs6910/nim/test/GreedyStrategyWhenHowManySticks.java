package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.Pile;
import edu.westga.cs6910.nim.model.strategy.GreedyStrategy;

/**
 * Tests the howManySticks() of the Greedy Strategy class
 * 
 * @author Jordan Barron
 * @version June 21st 2020
 *
 */
public class GreedyStrategyWhenHowManySticks {

	/**
	 * Tests that 1 is returned as How Many Sticks from pile size 1 
	 */
	@Test
	public void testGreedyStrategyWhenHowManySticksPileSize1ShouldBe0() {
		Pile oneStickPile = new Pile(1);
		GreedyStrategy greedy1 = new GreedyStrategy();
		assertEquals(1, greedy1.howManySticks(oneStickPile.getSticksLeft()));
	}
	
	/**
	 * Tests that 3 is returned as How Many Sticks from pile size 10 
	 */
	@Test
	public void testGreedyStrategyWhenHowManySticksPileSize10ShouldBe3() {
		Pile tenStickPile = new Pile(10);
		GreedyStrategy greedy1 = new GreedyStrategy();
		assertEquals(3, greedy1.howManySticks(tenStickPile.getSticksLeft()));
	}
	
	/**
	 * Tests that 3 is returned as How Many Sticks from pile size 10 
	 * that is reduced to 4
	 */
	@Test
	public void testGreedyStrategyWhenHowManySticksPileSize10ChangeToPileSize4ShouldBe3() {
		Pile tenStickPile = new Pile(10);
		tenStickPile.removeSticks(6);
		GreedyStrategy greedy1 = new GreedyStrategy();
		assertEquals(3, greedy1.howManySticks(tenStickPile.getSticksLeft()));
	}
	
	/**
	 * Tests that 2 is returned as How Many Sticks from pile size 10 
	 * that is reduced to 3
	 */
	@Test
	public void testGreedyStrategyWhenHowManySticksPileSize10ChangeToPileSize3ShouldBe2() {
		Pile tenStickPile = new Pile(10);
		tenStickPile.removeSticks(6);
		tenStickPile.removeSticks(1);
		GreedyStrategy greedy1 = new GreedyStrategy();
		assertEquals(2, greedy1.howManySticks(tenStickPile.getSticksLeft()));
	}
	
	/**
	 * Tests that 1 is returned as How Many Sticks from pile size 10 
	 * that is reduced to 2
	 */
	@Test
	public void testGreedyStrategyWhenHowManySticksPileSize10ChangeToPileSize2ShouldBe1() {
		Pile tenStickPile = new Pile(10);
		tenStickPile.removeSticks(6);
		tenStickPile.removeSticks(1);
		tenStickPile.removeSticks(1);
		GreedyStrategy greedy1 = new GreedyStrategy();
		assertEquals(1, greedy1.howManySticks(tenStickPile.getSticksLeft()));
	}

}
