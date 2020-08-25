package edu.westga.cs6910.nim.view;

import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.strategy.CautiousStrategy;
import edu.westga.cs6910.nim.model.strategy.GreedyStrategy;
import edu.westga.cs6910.nim.model.strategy.RandomStrategy;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;

/**
 * Defines the panel that displays the Menu where the file and strategy settings will be controlled
 * 
 * @author Jordan Barron
 * @version June 19th, 2020
 *
 */
public class MenuPane extends GridPane {
	private NimPane theNimPane;
	private Game theGame;
	
	/**
	 * Creates a MenuPane that will be displayed on the NimPane
	 * @param theNimPane The pane that the MenuPane will be set to the top of
	 * @param theGame The Data for the pane
	 */
	public MenuPane(NimPane theNimPane, Game theGame) {
		if (theNimPane == null) {
			throw new IllegalArgumentException("The NimPane Object cannot be null");
		}
		if (theGame == null) {
			throw new IllegalArgumentException("The Game Object cannot be null");
		}
		this.theNimPane = theNimPane;
		this.theGame = theGame;
		this.buildPane();
	}

	/**
	 * Builds the MenuPane that will be displayed on the NimPane
	 * @param primaryStage 
	 */
	private void buildPane() {
		MenuBar menuBar = this.getMenuBar();

		Menu fileMenu = this.getMenu(0);
		Menu strategyMenu = this.getMenu(1);
		
		fileMenu.getItems().addAll(this.getMenuItem(0));
		strategyMenu.getItems().addAll(this.getMenuItem(1), this.getMenuItem(2), this.getMenuItem(3));
		menuBar.getMenus().addAll(fileMenu, strategyMenu);
		
		this.add(menuBar, 0, 0);
	}
	
	/**
	 * creates the menuBar for the pane
	 * @return Returns the menuBar with a set width
	 */
	private MenuBar getMenuBar() {
		MenuBar menuBar = new MenuBar();
		menuBar.prefWidthProperty().bind(this.theNimPane.widthProperty());
		return menuBar;
	}
	
	/**
	 * creates the menu for the pane
	 * @param index the location of a specific menu
	 * @return Returns the menu with its name
	 */
	private Menu getMenu(int index) {
		Menu[] theMenus = new Menu[2];
		
		if (index < 0) {
			throw new IllegalArgumentException("index less than 0 does not exist");
		}	
		if (index > theMenus.length - 1) {
			throw new IllegalArgumentException("index greater than array length does not exist");
		}		
		
		for (int current = 0; current < theMenus.length; current++) {
			theMenus[current] = new Menu();
			theMenus[current].setMnemonicParsing(true);
		}
		theMenus[0].setText("_File");
		theMenus[1].setText("_Strategy");
		
		return theMenus[index];
	}
	
	/**
	 * creates the menuItems for the pane
	 * @param index the location of a specific menuItem
	 * @return Returns the menuItem with its name
	 */
	private MenuItem getMenuItem(int index) {
		MenuItem[] theMenuItems = new MenuItem[4];
		
		if (index < 0) {
			throw new IllegalArgumentException("index less than 0 does not exist");
		}	
		if (index > theMenuItems.length - 1) {
			throw new IllegalArgumentException("index greater than array length does not exist");
		}
		
		theMenuItems[0] = this.getExitMenuItem();
		theMenuItems[1] = this.getCautiousMenuItem();
		theMenuItems[2] = this.getGreedyMenuItem();
		theMenuItems[3] = this.getRandomMenuItem();
	
		return theMenuItems[index];
	}
	
	private MenuItem getExitMenuItem() {
		MenuItem exitItem = new MenuItem();
		
		exitItem.setMnemonicParsing(true);
		exitItem.setText("E_xit");
		exitItem.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN));
		
		exitItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.exit(0);
			}	
		});
		return exitItem;
	}
	
	private MenuItem getCautiousMenuItem() {
		MenuItem cautiousItem = new MenuItem();
		
		cautiousItem.setMnemonicParsing(true);
		cautiousItem.setText("_Cautious");
		
		cautiousItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				MenuPane.this.theGame.getComputerPlayer().setStrategy(new CautiousStrategy());
			}
		});
		return cautiousItem;
		
	}
	
	private MenuItem getGreedyMenuItem() {
		MenuItem greedyItem = new MenuItem();

		greedyItem.setMnemonicParsing(true);
		greedyItem.setText("_Greedy");
		
		greedyItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				MenuPane.this.theGame.getComputerPlayer().setStrategy(new GreedyStrategy());
			}
		});
		return greedyItem;
		
	}
	
	private MenuItem getRandomMenuItem() {
		MenuItem randomItem = new MenuItem();
		
		randomItem.setMnemonicParsing(true);
		randomItem.setText("_Random");
		
		randomItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				MenuPane.this.theGame.getComputerPlayer().setStrategy(new RandomStrategy());
			}
		});
		return randomItem;
	}
	
}
