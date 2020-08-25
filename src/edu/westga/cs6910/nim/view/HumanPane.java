package edu.westga.cs6910.nim.view;

import edu.westga.cs6910.nim.model.CountDown;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

/**
 * Defines the panel that lets the user indicate the number of sticks
 * to take from the pile and to take the turn as well as the timer the user has to select a stick
 * 
 * @author CS6910
 * @version Summer 2020
 */
public class HumanPane extends GridPane implements InvalidationListener {
	private ComboBox<Integer> cmbNumberToTake;
	private Button btnTakeSticks;
	private Label lblCountDown;
	private Timeline animation;
	
	private HumanPlayer theHuman;
	private Game theGame;
	private CountDown theCountDown;

	/**
	 * Creates a new HumanPane that observes the specified game. 
	 * 
	 * @param theGame	the model object from which this pane gets its data
	 * 
	 * @requires 	theGame != null
	 */
	public HumanPane(Game theGame) {
		this.theGame = theGame;
		this.theGame.addListener(this);
		
		this.theHuman = this.theGame.getHumanPlayer();
		this.theCountDown = new CountDown();
		
		this.buildPane();
	}
	
	private void buildPane() {
		this.add(new Label("~~ " + this.theHuman.getName() + " ~~"), 0, 0);
		
		this.add(new Label("Number of sticks to take: "), 0, 1);
		
		this.cmbNumberToTake = new ComboBox<Integer>();
		this.cmbNumberToTake.getItems().addAll(1, 2, 3);
		this.add(this.cmbNumberToTake, 1, 1);

		this.btnTakeSticks = new Button("Take Sticks");
		this.btnTakeSticks.setOnAction(new TakeTurnListener());
		this.add(this.btnTakeSticks, 3, 1);
		
		this.lblCountDown = new Label(this.theCountDown.toString());
		this.add(this.lblCountDown, 0, 2);
	}

	@Override
	public void invalidated(Observable observable) {
		if (this.theGame.isGameOver()) {
			this.setDisable(true);
			return;
		}
		
		boolean myTurn = this.theGame.getCurrentPlayer() == theHuman;
		
		if (myTurn) {
			this.resetNumberToTakeComboBox();
			this.startTimer();
		}

		this.setDisable(!myTurn);
	}

	/**
	 *  Clears the numbers in the combo box, then adds back in all the
	 *  valid numbers so the user can't try to take more sticks than allowed.
	 */
	private void resetNumberToTakeComboBox() {	
		this.cmbNumberToTake.getItems().clear();
		
		int max = Math.min(this.theGame.getSticksLeft() - 1, Game.MAX_STICKS_PER_TURN);
		for (int number = 0; number < max; number++) {
			this.cmbNumberToTake.getItems().add(number + 1);
		}	
		this.cmbNumberToTake.setValue(1);
	}
	
	/**
	 * Starts the CountDown
	 */
	private void startTimer() {
		this.theCountDown = new CountDown();
		this.animation = new Timeline(new KeyFrame(Duration.seconds(1), 
				new CountDownListener()));
		this.animation.setCycleCount(Timeline.INDEFINITE);
		this.animation.play();
	}
	
	private class CountDownListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			HumanPane.this.theCountDown.countTimeDown();
			HumanPane.this.lblCountDown.setText(HumanPane.this.theCountDown.toString());
			if (HumanPane.this.theCountDown.isTimeUp()) {
				HumanPane.this.btnTakeSticks.fire();
			}
		}
	}

	private class TakeTurnListener implements EventHandler<ActionEvent> {
		/* 
		 * Tells the Game to have its current player (i.e., the human Player)
		 * take its turn.	
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void handle(ActionEvent event) {
			if (!HumanPane.this.theGame.isGameOver()) {
				HumanPane.this.animation.stop();
				HumanPane.this.theHuman.setPileForThisTurn(HumanPane.this.theGame.getPile());
				HumanPane.this.theHuman.setNumberSticksToTake((int) HumanPane.this.cmbNumberToTake
						.getValue());
				HumanPane.this.theGame.play();
			}
		}
	}
}
