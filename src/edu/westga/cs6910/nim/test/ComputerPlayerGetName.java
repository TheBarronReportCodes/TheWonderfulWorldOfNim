package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;

/**
 * Tests the getName() of the ComputerPlayer class
 * 
 * @author Jordan Barron
 * @version June 13th 2020
 *
 */
public class ComputerPlayerGetName {

	/**
	 * Tests if a ComputerPlayer object initialized returns Simple Computer
	 * using getName()
	 */
	@Test
	public void testWithNewComputerShouldHaveSimpleComputerTestOne() {
		ComputerPlayer computer1 = new ComputerPlayer();
		assertEquals("Simple computer", computer1.getName());
	}
	
	/**
	 * Tests if a ComputerPlayer object initialized returns Simple Computer
	 * using getName()
	 */
	@Test
	public void testWithNewComputerShouldHaveSimpleComputerTestTwo() {
		ComputerPlayer computer1 = new ComputerPlayer();
		assertEquals("Simple computer", computer1.getName());
	}
	
	/**
	 * Tests if a ComputerPlayer object initialized returns Simple Computer
	 * using getName()
	 */
	@Test
	public void testWithNewComputerShouldHaveSimpleComputerTestThree() {
		ComputerPlayer computer1 = new ComputerPlayer();
		assertEquals("Simple computer", computer1.getName());
	}

}
