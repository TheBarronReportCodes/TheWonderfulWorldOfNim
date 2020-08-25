package edu.westga.cs6910.nim.view;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.CountDown;
import edu.westga.cs6910.nim.model.Game;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

/**
 * Defines the panel that lets the user tell the computer player to
 * take its turn and that displays the number of sticks the computer
 * player took on its turn.
 * This class was started by CS6910
 * 
 * @author Jordan Barron
 * @version June 6th, 2020
 * 
 */
public class ComputerPane extends GridPane implements InvalidationListener {
	private Game theGame;
	private Label lblNumberTaken;
	private ComputerPlayer theComputer;
	private Button btnTakeTurn;
	private CountDown theCountDown;
	private Timeline animation;

	/**
	 * Creates a new ComputerPane that observes the specified game. 
	 * 
	 * @param theGame	the model object from which this pane gets its data
	 * 
	 * @requires 	theGame != null
	 */
	public ComputerPane(Game theGame) {
		this.theGame = theGame;
		
		this.theGame.addListener(this);
		
		this.theComputer = this.theGame.getComputerPlayer();
		this.theCountDown = new CountDown();
		
		this.buildPane();
	}
	
	/**
	 * Creates the pane that serves as the view of the human to computer player interface
	 */
	private void buildPane() {
		this.add(new Label("~~" + this.theComputer.getName() + "~~"), 0, 0);
		
		this.add(new Label("Number of sticks taken: "), 0, 1);
		this.lblNumberTaken = new Label("" + this.theComputer.getSticksOnThisTurn());
		this.add(this.lblNumberTaken, 1, 1);
		
		this.btnTakeTurn = new Button("Take Turn");
		this.btnTakeTurn.setOnAction(new TakeTurnListener());
	}

	@Override
	public void invalidated(Observable arg0) {
		if (this.theGame.isGameOver()) {
			this.displayNumberOfStickTakenOnComputersTurn();
			this.setDisable(true);
			return;
		}
		
		boolean myTurn = this.theGame.getCurrentPlayer() == theComputer;
		
		if (myTurn) {
			this.startTimer();
		}
		
		if (!myTurn) {
			this.displayNumberOfStickTakenOnComputersTurn();
		} 
		this.setDisable(!myTurn);

	}
	
	/**
	 * Starts the CountDown
	 */
	private void startTimer() {
		this.theCountDown = new CountDown(2);
		this.animation = new Timeline(new KeyFrame(Duration.seconds(1), 
				new CountDownListener()));
		this.animation.setCycleCount(Timeline.INDEFINITE);
		this.animation.play();
	}
	
	/**
	 * updates to the GUI the amount of sticks that the computer has taken on it's turn
	 */
	private void displayNumberOfStickTakenOnComputersTurn() {
		this.lblNumberTaken.setText("" + this.theComputer.getSticksOnThisTurn());
	}
	
	private class CountDownListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			ComputerPane.this.theCountDown.countTimeDown();
			if (ComputerPane.this.theCountDown.isTimeUp()) {
				ComputerPane.this.btnTakeTurn.fire();
			}
		}
	}

	/* 
	 * Defines the listener for takeTurnButton.
	 */
	private class TakeTurnListener implements EventHandler<ActionEvent> {

		/* 
		 * Tells the Game to have its current player (i.e., the computer player)
		 * take its turn.	
		 * 
		 * @see javafx.event.EventHandler#handle(T-extends-javafx.event.Event)
		 */
		@Override
		public void handle(ActionEvent arg0) {
			if (!ComputerPane.this.theGame.isGameOver()) {
				ComputerPane.this.animation.stop();
				ComputerPane.this.theComputer.setPileForThisTurn(ComputerPane.this.theGame.getPile());
				ComputerPane.this.theComputer.setNumberSticksToTake();
				ComputerPane.this.theGame.play();
			}
		}
	}
}
