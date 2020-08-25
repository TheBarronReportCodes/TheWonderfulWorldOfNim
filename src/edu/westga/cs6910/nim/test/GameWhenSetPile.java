package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;

/**
 * Tests the setPile() of the Game class
 * 
 * @author Jordan Barron
 * @version June 28th, 2020
 *
 */
public class GameWhenSetPile {

	/**
	 * Tests if a Game object initialized (pile size of 7) can be changed to another size (8)
	 */
	@Test
	public void testBeforeGameStartsShouldSetPileFrom7To8() {
		HumanPlayer human1 = new HumanPlayer("Bill Gates");
		ComputerPlayer computer1 = new ComputerPlayer();
		Game firstGame = new Game(human1, computer1);
		firstGame.setPile(8);
		assertEquals(8, firstGame.getSticksLeft());
	}
	
	/**
	 * Tests if a Game object initialized (pile size of 7) can be changed to another size (To 15 then 25)
	 */
	@Test
	public void testBeforeGameStartsShouldSetPileFrom7To25() {
		HumanPlayer human1 = new HumanPlayer("Bill Gates");
		ComputerPlayer computer1 = new ComputerPlayer();
		Game firstGame = new Game(human1, computer1);
		firstGame.setPile(15);
		firstGame.setPile(25);
		assertEquals(25, firstGame.getSticksLeft());
	}
	
	/**
	 * Tests if a Game object initialized (pile size of 7) can be changed to another size (To 30 to 49 to 50)
	 */
	@Test
	public void testBeforeGameStartsShouldSetPileFrom7To50() {
		HumanPlayer human1 = new HumanPlayer("Bill Gates");
		ComputerPlayer computer1 = new ComputerPlayer();
		Game firstGame = new Game(human1, computer1);
		assertEquals(7, firstGame.getSticksLeft());
		firstGame.setPile(30);
		firstGame.setPile(49);
		firstGame.setPile(50);
		assertEquals(50, firstGame.getSticksLeft());
	}

}
