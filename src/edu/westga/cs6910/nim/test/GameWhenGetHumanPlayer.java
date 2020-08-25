package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;

/**
 * Tests the getHumanPlayer() of the Game class
 * 
 * @author Jordan Barron
 * @version June 13th 2020
 *
 */
public class GameWhenGetHumanPlayer {

	/**
	 * Tests if a Game object initialized (pile size of 7) has the human player of the variable given
	 */
	@Test
	public void testBeforeGameStartsGetHumanPlayerShouldBeHuman1() {
		HumanPlayer human1 = new HumanPlayer("Alan Turing");
		ComputerPlayer computer1 = new ComputerPlayer();
		Game firstGame = new Game(human1, computer1);
		assertEquals(human1, firstGame.getHumanPlayer());
	}
	
	/**
	 * Tests if a Game object initialized (pile size of 7) has the human player of the variable given
	 */
	@Test
	public void testBeforeGameStartsGetHumanPlayerShouldBeHuman2() {
		HumanPlayer human2 = new HumanPlayer("Woz");
		ComputerPlayer computer2 = new ComputerPlayer();
		Game secondGame = new Game(human2, computer2);
		assertEquals(human2, secondGame.getHumanPlayer());
	}
	
	/**
	 * Tests if a Game object initialized (pile size of 7) has the human player of the variable given
	 */
	@Test
	public void testBeforeGameStartsGetHumanPlayerShouldBeHuman3() {
		HumanPlayer human3 = new HumanPlayer("Steve Jobs");
		ComputerPlayer computer3 = new ComputerPlayer();
		Game thirdGame = new Game(human3, computer3);
		assertEquals(human3, thirdGame.getHumanPlayer());
	}

}
