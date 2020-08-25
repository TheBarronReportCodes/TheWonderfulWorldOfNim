package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.Pile;
import edu.westga.cs6910.nim.model.strategy.CautiousStrategy;

/**
 * Tests the howManySticks() of the Cautious Strategy class
 * 
 * @author Jordan Barron
 * @version June 21st 2020
 *
 */
public class CautiousStrategyWhenHowManySticks {

	/**
	 * Tests that 1 is returned as How Many Sticks from pile size 1
	 */
	@Test
	public void testCautiousStrategyWhenHowManySticksPileSize1ShouldBe1() {
		Pile oneStickPile = new Pile(1);
		CautiousStrategy cautious1 = new CautiousStrategy();
		assertEquals(1, cautious1.howManySticks(oneStickPile.getSticksLeft()));
	}
	
	/**
	 * Tests that 1 is returned as How Many Sticks from pile size 10 
	 * that is reduced to 5
	 */
	@Test
	public void testCautiousStrategyWhenHowManySticksPileSize10ShouldBe1() {
		Pile tenStickPile = new Pile(10);
		CautiousStrategy cautious1 = new CautiousStrategy();
		tenStickPile.removeSticks(5);
		assertEquals(1, cautious1.howManySticks(tenStickPile.getSticksLeft()));
	}
	
	/**
	 * Tests that 1 is returned as How Many Sticks from pile size 10 
	 * that is reduced to 1
	 */
	@Test
	public void testCautiousStrategyWhenHowManySticksPileSize100ShouldBe1() {
		Pile oneHundredStickPile = new Pile(100);
		CautiousStrategy cautious1 = new CautiousStrategy();
		oneHundredStickPile.removeSticks(44);
		oneHundredStickPile.removeSticks(55);
		assertEquals(1, cautious1.howManySticks(oneHundredStickPile.getSticksLeft()));
	}

}
