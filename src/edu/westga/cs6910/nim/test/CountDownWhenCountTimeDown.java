package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.CountDown;

/**
 * Tests the countTimeDown() of the CountDown class
 * 
 * @author Jordan Barron
 * @version June 28 2020
 *
 */
public class CountDownWhenCountTimeDown {

	/**
	 * Tests if a CountDown object when countTimeDown() to 1 has isTimeUp false
	 */
	@Test
	public void testCountDownWhenStopShouldHaveIsTimeUpFalse() {
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
		assertEquals(false, countDown1.isTimeUp());
	}
	
	/**
	 * Tests if a CountDown object when countTimeDown() to 0 has isTimeUp true
	 */
	@Test
	public void testCountDownWhenStopShouldHaveIsTimeUpTrue() {
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
		assertEquals(true, countDown1.isTimeUp());
	}
	
	/**
	 * Tests if a CountDown object when countTimeDown(7) to 1 has seconds left of 1
	 */
	@Test
	public void testCountDownWhenStopShouldHaveSecondsLeft1() {
		CountDown countDown1 = new CountDown(7);
		countDown1.countTimeDown();
		countDown1.countTimeDown();
		countDown1.countTimeDown();
		countDown1.countTimeDown();
		countDown1.countTimeDown();
		countDown1.countTimeDown();
		assertEquals(1, countDown1.getTheSecondsLeft());
	}
	
	/**
	 * Tests if a CountDown object when countTimeDown(5) to 0 has seconds left of 0
	 */
	@Test
	public void testCountDownWhenStopShouldHaveSecondsLeft0() {
		CountDown countDown1 = new CountDown(5);
		countDown1.countTimeDown();
		countDown1.countTimeDown();
		countDown1.countTimeDown();
		countDown1.countTimeDown();
		countDown1.countTimeDown();
		assertEquals(0, countDown1.getTheSecondsLeft());
	}
}
