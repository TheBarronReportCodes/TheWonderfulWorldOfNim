package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;

/**
 * Tests the getComputerPlayer() of the Game class
 * 
 * @author Jordan Barron
 * @version June 13th 2020
 *
 */
public class GameWhenGetComputerPlayer {
	
	/**
	 * Tests if a Game object initialized (pile size of 7) has the computer player of the variable given
	 */
	@Test
	public void testBeforeGameStartsGetComputerPlayerShouldBeComputer1() {
		HumanPlayer human1 = new HumanPlayer("Nikola Tesla");
		ComputerPlayer computer1 = new ComputerPlayer();
		Game firstGame = new Game(human1, computer1);
		assertEquals(computer1, firstGame.getComputerPlayer());
	}
	
	/**
	 * Tests if a Game object initialized (pile size of 7) has the human player of the variable given
	 */
	@Test
	public void testBeforeGameStartsGetComputerPlayerShouldBeComputer2() {
		HumanPlayer human2 = new HumanPlayer("Andy Hertzfeld");
		ComputerPlayer computer2 = new ComputerPlayer();
		Game secondGame = new Game(human2, computer2);
		assertEquals(computer2, secondGame.getComputerPlayer());
	}
	
	/**
	 * Tests if a Game object initialized (pile size of 7) has the human player of the variable given
	 */
	@Test
	public void testBeforeGameStartsGetComputerPlayerShouldBeComputer3() {
		HumanPlayer human3 = new HumanPlayer("Jerry Lawson");
		ComputerPlayer computer3 = new ComputerPlayer();
		Game thirdGame = new Game(human3, computer3);
		assertEquals(computer3, thirdGame.getComputerPlayer());
	}

}
