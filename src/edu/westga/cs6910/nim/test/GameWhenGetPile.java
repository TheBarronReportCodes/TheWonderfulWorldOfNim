package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;

/**
 * Tests the getPile() of the Game class
 * 
 * @author Jordan Barron
 * @version June 13th 2020
 *
 */
public class GameWhenGetPile {

	/**
	 * Tests if a Game object initialized (pile size of 7) has a pile size of 7
	 */
	@Test
	public void testBeforeGameStartsGetPileShouldHave7TestOne() {
		HumanPlayer human1 = new HumanPlayer("Bill Gates");
		ComputerPlayer computer1 = new ComputerPlayer();
		Game firstGame = new Game(human1, computer1);
		assertEquals("Pile size: 7", firstGame.getPile().toString());
	}
	
	/**
	 * Tests if a Game object initialized (pile size of 7) has a pile size of 7
	 */
	@Test
	public void testBeforeGameStartsGetPileShouldHave7TestTwo() {
		HumanPlayer human2 = new HumanPlayer("Linus Torvalds");
		ComputerPlayer computer2 = new ComputerPlayer();
		Game secondGame = new Game(human2, computer2);
		assertEquals("Pile size: 7", secondGame.getPile().toString());
	}
	
	/**
	 * Tests if a Game object initialized (pile size of 7) has a pile size of 7
	 */
	@Test
	public void testBeforeGameStartsGetPileShouldHave7TestThree() {
		HumanPlayer human3 = new HumanPlayer("Ken Thompson");
		ComputerPlayer computer3 = new ComputerPlayer();
		Game thirdGame = new Game(human3, computer3);
		assertEquals("Pile size: 7", thirdGame.getPile().toString());
	}

}
