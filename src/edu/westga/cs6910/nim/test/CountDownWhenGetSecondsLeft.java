package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.CountDown;

/**
 * Tests the getSecondsLeft of the CountDown class
 * 
 * @author Jordan Barron
 * @version June 28th, 2020
 *
 */
public class CountDownWhenGetSecondsLeft {
	/**
	 * Tests if a CountDown object initialized has getSecondsLeft of 15
	 */
	@Test
	public void testCountDownShouldHaveGetTheSecondsLeft5() {
		CountDown countDown1 = new CountDown();
		assertEquals(15, countDown1.getTheSecondsLeft());
	}
	
	/**
	 * Tests if a CountDown object when countTimeDown() has getSecondsLeft of 10
	 */
	@Test
	public void testCountDownShouldHaveGetTheSecondsLeft10() {
		CountDown countDown1 = new CountDown();
		countDown1.countTimeDown();
		countDown1.countTimeDown();
		countDown1.countTimeDown();
		countDown1.countTimeDown();
		countDown1.countTimeDown();
		assertEquals(10, countDown1.getTheSecondsLeft());
	}
	
	/**
	 * Tests if a CountDown object initialized has getSecondsLeft of 0
	 */
	@Test
	public void testCountDownShouldHaveGetTheSecondsLeft0() {
		CountDown countDown1 = new CountDown();
		countDown1.countTimeDown();
		countDown1.countTimeDown();
		countDown1.countTimeDown();
		countDown1.countTimeDown();
		countDown1.countTimeDown();
		countDown1.countTimeDown();
		countDown1.countTimeDown();
		countDown1.countTimeDown();
		countDown1.countTimeDown();
		countDown1.countTimeDown();
		countDown1.countTimeDown();
		countDown1.countTimeDown();
		countDown1.countTimeDown();
		countDown1.countTimeDown();
		countDown1.countTimeDown();
		assertEquals(0, countDown1.getTheSecondsLeft());
	}

}
