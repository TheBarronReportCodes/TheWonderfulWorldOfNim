package edu.westga.cs6910.nim.view;

import edu.westga.cs6910.nim.model.Game;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Defines the panel that displays either the number of sticks left on the
 * pile or the winner if the game is over.
 * 
 * @author CS6910
 * @version Summer 2020
 */
public class StatusPane extends GridPane implements InvalidationListener {
	private Game theGame;
	private Label lblStatus;
	private ComboBox<Integer> cmbPileSizeToSet;
	private Button btnSetPile;
	
	/**
	 * Creates a new status pane that observes the specified game. 
	 * 
	 * @param theGame	the model object from which this pane gets its data
	 * 
	 * @requires 	theGame != null
	 */
	public StatusPane(Game theGame) {
		this.theGame = theGame;
		
		this.theGame.addListener(this);
		
		this.buildPane();
	}

	private void buildPane() {
		this.add(new Label("~~ Game Info ~~"), 0, 0);
		
		this.lblStatus = new Label(this.theGame.toString());
		this.add(this.lblStatus, 0, 1);
		
		this.cmbPileSizeToSet = new ComboBox<Integer>();
		this.setPileSizeToTakeComboBox();
		this.add(this.cmbPileSizeToSet, 0, 2);
		
		this.btnSetPile = new Button("Change");
		this.btnSetPile.setOnAction(new ChangePile());
		this.add(this.btnSetPile, 0, 3);
		
	}

	@Override
	public void invalidated(Observable observable) {
		this.lblStatus.setText(this.theGame.toString());
		
		boolean playerSet = this.theGame.getCurrentPlayer() == this.theGame.getHumanPlayer() 
				|| this.theGame.getCurrentPlayer() == this.theGame.getComputerPlayer();
		
		if (!playerSet) {
			this.setPileSizeToTakeComboBox();
		}
		this.cmbPileSizeToSet.setDisable(playerSet);
		this.btnSetPile.setDisable(playerSet);
		
	}
	
	private void setPileSizeToTakeComboBox() {
		int max = Game.MAX_PILE_SIZE;
		int number;
		for (number = Game.INITIAL_PILE_SIZE; number < max; number++) {
			this.cmbPileSizeToSet.getItems().add(number + 1);
		}	
		
	}
	
	private class ChangePile implements EventHandler<ActionEvent> {
		/* 
		 * Tells the Game to have its current player (i.e., the human Player)
		 * take its turn.	
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void handle(ActionEvent event) {
			if (!StatusPane.this.theGame.isGameOver()) {
				StatusPane.this.theGame.setPile((int) StatusPane.this.cmbPileSizeToSet
						.getValue());
				StatusPane.this.lblStatus.setText(StatusPane.this.theGame.toString());
			}
		}
	}
}
