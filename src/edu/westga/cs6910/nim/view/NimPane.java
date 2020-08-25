package edu.westga.cs6910.nim.view;

import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;


/**
 * Defines a GUI for the 1-pile Nim game.
 * This class was started by CS6910
 * 
 * @author Jordan Barron
 * @version June 6th, 2020
 * 
 */
public class NimPane extends BorderPane {
	private Game theGame;
	private BorderPane pnContent;
	private HumanPane pnHumanPlayer;
	private ComputerPane pnComputerPlayer;
	private StatusPane pnGameInfo;
	private MenuPane pnMenuPane;
	private Pane pnChooseFirstPlayer;
	
	/**
	 * Creates a pane object to provide the view for the specified
	 * Game model object.
	 * 
	 * @param theGame	the domain model object representing the Nim game
	 * 
	 * @requires theGame != null
	 * @ensures	 the pane is displayed properly
	 */
	public NimPane(Game theGame) {
		this.theGame = theGame;
		
		this.pnContent = new BorderPane();
		
		this.addFirstPlayerChooserPane(theGame);		
		
		this.addHumanPlayerInfoPane(theGame);
		
		this.addStatusInfoPane(theGame);
		
		this.addComputerPlayerInfoPane(theGame);

		this.setCenter(this.pnContent);
		
		this.addMenuPane(theGame);
	}

	/**
	 * View of the section of the overall pane that displays the first player choice
	 * @param theGame the domain model object representing the Nim game
	 */
	private void addFirstPlayerChooserPane(Game theGame) {
		HBox topBox = new HBox();
		topBox.getStyleClass().add("pane-border");	
		this.pnChooseFirstPlayer = new NewGamePane(theGame);
		topBox.getChildren().add(this.pnChooseFirstPlayer);
		this.pnContent.setTop(topBox);
	}
	
	/**
	 * View of the section of the overall pane that displays information on the human player
	 * @param theGame the domain model object representing the Nim game
	 */
	private void addHumanPlayerInfoPane(Game theGame) {
		HBox humanBox = new HBox();
		humanBox.getStyleClass().add("pane-border");		
		this.pnHumanPlayer = new HumanPane(theGame);
		humanBox.getChildren().add(this.pnHumanPlayer);
		this.pnContent.setLeft(humanBox);
	}
	
	/**
	 * View of the section of the overall pane that displays information on the current status of the game
	 * @param theGame the domain model object representing the Nim game
	 */
	private void addStatusInfoPane(Game theGame) {
		HBox statusBox = new HBox();
		statusBox.getStyleClass().add("pane-border");
		this.pnGameInfo = new StatusPane(theGame);
		statusBox.getChildren().add(this.pnGameInfo);
		this.pnContent.setCenter(statusBox);
	}
	
	/**
	 * View of the section of the overall pane that displays information on the computer player
	 * @param theGame the domain model object representing the Nim game
	 */
	private void addComputerPlayerInfoPane(Game theGame) {
		HBox computerBox = new HBox();
		computerBox.getStyleClass().add("pane-border");
		this.pnComputerPlayer = new ComputerPane(theGame);
		computerBox.getChildren().add(this.pnComputerPlayer);
		this.pnContent.setRight(computerBox);
	}
	
	/**
	 * Adds the menuPane which contains the menuBar to the top of the NimPane
	 */
	private void addMenuPane(Game theGame) {
		HBox menuBox = new HBox();
		this.pnMenuPane = new MenuPane(this, theGame);
		menuBox.getChildren().addAll(this.pnMenuPane);
		menuBox.prefWidthProperty().bind(this.widthProperty());
		this.setTop(menuBox);
	}

	/*
	 * Defines the panel in which the user selects which Player plays first.
	 */
	private final class NewGamePane extends GridPane {
		private RadioButton radHumanPlayer;
		private RadioButton radComputerPlayer;
		
		private Game theGame;
		private Player theHuman;
		private Player theComputer;

		private NewGamePane(Game theGame) {
			this.theGame = theGame;
			
			this.theHuman = this.theGame.getHumanPlayer();
			this.theComputer = this.theGame.getComputerPlayer();
			
			this.buildPane();
		}
		
		/**
		 * Creates the pane that serves as the view of the human to computer player interface
		 */
		private void buildPane() {
			this.setHgap(20);
			
			this.radHumanPlayer = new RadioButton(this.theHuman.getName() + " first");	
			this.radHumanPlayer.setOnAction(new HumanFirstListener());
			
			this.radComputerPlayer = new RadioButton(this.theComputer.getName() + " first");
			this.radComputerPlayer.setOnAction(new ComputerFirstListener());
			
			RadioButton randomPlayer = new RadioButton("Coin Flip");
			randomPlayer.setOnAction(new RandomSelect());
			
			ToggleGroup togglePlayerButton = new ToggleGroup();
			this.radHumanPlayer.setToggleGroup(togglePlayerButton);
			this.radComputerPlayer.setToggleGroup(togglePlayerButton);
			randomPlayer.setToggleGroup(togglePlayerButton);
			
			HBox humanButtonBox = new HBox();
			humanButtonBox.getChildren().add(this.radHumanPlayer);
			this.add(humanButtonBox, 1, 0);
			HBox computerButtonBox = new HBox();
			computerButtonBox.getChildren().add(this.radComputerPlayer);
			this.add(computerButtonBox, 2, 0);
			HBox randomSelectBox = new HBox();
			randomSelectBox.getChildren().add(randomPlayer);
			this.add(randomSelectBox, 3, 0);
		}
		
		/* 
		 * Defines the listener for computer player first button.
		 */		
		private class ComputerFirstListener implements EventHandler<ActionEvent> {
			@Override
			/** 
			 * Enables the ComputerPlayerPanel and starts a new game. 
			 * Event handler for a click in the computerPlayerButton.
			 */
			public void handle(ActionEvent arg0) {
				NimPane.this.pnComputerPlayer.setDisable(false);
				NimPane.this.pnChooseFirstPlayer.setDisable(true);
				NimPane.this.theGame.startNewGame(NewGamePane.this.theComputer);
			}
		}

		
		/* 
		 * Defines the listener for human player first button.
		 */	
		private class HumanFirstListener implements EventHandler<ActionEvent> {
			/* 
			 * Sets up user interface and starts a new game. 
			 * Event handler for a click in the human player button.
			 */
			@Override
			public void handle(ActionEvent event) {
				NimPane.this.pnChooseFirstPlayer.setDisable(true);
				NimPane.this.pnHumanPlayer.setDisable(false);
				NimPane.this.theGame.startNewGame(NewGamePane.this.theHuman);
			}
		}
		
		/**
		 * Defines the player who goes first 
		 * @author Jordan Barron
		 * @version June 28th 2020
		 *
		 */
		private class RandomSelect implements EventHandler<ActionEvent> {
			/**
			 * Randomly selects which player will go first
			 */
			@Override
			public void handle(ActionEvent arg0) {
				int random = (int) (Math.random() * 100) + 1;
				if (random > 50) {
					NewGamePane.this.radHumanPlayer.fire();
				} 
				NewGamePane.this.radComputerPlayer.fire();
			}
		}
	}
}
