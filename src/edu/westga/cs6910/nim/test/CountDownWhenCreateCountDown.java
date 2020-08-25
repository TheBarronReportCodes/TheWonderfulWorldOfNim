package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.CountDown;

/**
 * Tests the constructor of the CountDown class
 * 
 * @author Jordan Barron
 * @version June 28th, 2020
 *
 */
public class CountDownWhenCreateCountDown {

	/**
	 * Tests if a CountDown object initialized has phrase Timer: 15 seconds
	 */
	@Test
	public void testCountDownShouldHaveTimer15seconds() {
		CountDown countDown1 = new CountDown();
		assertEquals("Timer: 15 seconds", countDown1.toString());
	}
	
	/**
	 * Tests if a CountDown object initialized has phrase Timer: 15 seconds
	 */
	@Test
	public void testCountDownShouldHaveTimer10secondsTestTwo() {
		CountDown countDown1 = new CountDown(10);
		assertEquals("Timer: 10 seconds", countDown1.toString());
	}
	
	/**
	 * Tests if a CountDown object initialized has phrase Timer: 15 seconds
	 */
	@Test
	public void testCountDownShouldHaveTimer5secondsTestThree() {
		CountDown countDown1 = new CountDown(5);
		assertEquals("Timer: 5 seconds", countDown1.toString());
	}

}
