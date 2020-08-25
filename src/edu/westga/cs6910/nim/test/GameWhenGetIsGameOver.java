package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;

/**
 * Tests the isGameOver() of the Game class
 * 
 * @author Jordan Barron
 * @version June 13th 2020
 *
 */
public class GameWhenGetIsGameOver {

	/**
	 * Tests if a Game object initialized (pile size of 7) starts off as not game over
	 */
	@Test
	public void testBeforeGameStartsIsNotOver() {
		HumanPlayer human1 = new HumanPlayer("Alan Turing");
		ComputerPlayer computer1 = new ComputerPlayer();
		Game firstGame = new Game(human1, computer1);
		assertEquals(false , firstGame.isGameOver());
	}
	
	/**
	 * Tests if a Game object initialized (pile size of 7) starts off as not game over
	 * second test
	 */
	@Test
	public void testBeforeGameStartsIsNotOverSecondTest() {
		HumanPlayer human1 = new HumanPlayer("Woz");
		ComputerPlayer computer1 = new ComputerPlayer();
		Game secondGame = new Game(human1, computer1);
		assertEquals(false , secondGame.isGameOver());
	}
	
	/**
	 * Tests if a Game object initialized (pile size of 7) starts off as not game over
	 * third test
	 */
	@Test
	public void testBeforeGameStartsIsNotOverThirdTest() {
		HumanPlayer human1 = new HumanPlayer("Charles Petzold");
		ComputerPlayer computer1 = new ComputerPlayer();
		Game thirdGame = new Game(human1, computer1);
		assertEquals(false , thirdGame.isGameOver());
	}

}
