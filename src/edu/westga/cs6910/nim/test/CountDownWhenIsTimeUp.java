package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.CountDown;

/**
 * Tests the isTimeUp() of the CountDown class
 * 
 * @author Jordan Barron
 * @version June 28th, 2020
 *
 */
public class CountDownWhenIsTimeUp {

	/**
	 * Tests if a CountDown object initialized has isTimeUp of false
	 */
	@Test
	public void testCountDownShouldHaveIsTimeUpFalse() {
		CountDown countDown1 = new CountDown();
		assertEquals(false, countDown1.isTimeUp());
	}
	
	/**
	 * Tests if a CountDown object after timer ends has isTimeUp of true
	 */
	@Test
	public void testCountDownLowSecondsShouldHaveIsTimeUpTrue() {
		CountDown countDown1 = new CountDown(1);
		countDown1.countTimeDown();
		assertEquals(true, countDown1.isTimeUp());
	}
	
	/**
	 * Tests if a CountDown object after timer ends has isTimeUp of true
	 */
	@Test
	public void testCountDownShouldHaveIsTimeUpTrue() {
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
	 * Tests if a CountDown object after timer stops and new initialization has isTimeUp of false
	 */
	@Test
	public void testCountDownShouldHaveIsTimeUpEndOnFalse() {
		CountDown countDown1 = new CountDown(5);
		countDown1.countTimeDown();
		countDown1.countTimeDown();
		countDown1.countTimeDown();
		countDown1.countTimeDown();
		countDown1.countTimeDown();
		countDown1 = new CountDown();
		assertEquals(false, countDown1.isTimeUp());
	}

}
