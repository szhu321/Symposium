package mainGame.frontend;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class InGameMenuView
{
	private Group menu;
	
	private VBox mainView;
	private VBox settingsView;
	private VBox controlsView;
	private GridPane saveGameView;
	private GridPane loadGameView;
	
	private Button loadGameBtn;
	private Button saveGameBtn;
	private Button settingsBtn;
	private Button controlsBtn;
	
	private Node currentVisibleView;
	
	public InGameMenuView()
	{
		menu = new Group();
		loadSettingsView();
		loadControlsView();
		loadLoadGameView();
		loadSaveGameView();
		loadMainView();
		loadStartVisibility();
		menu.getChildren().addAll(mainView, settingsView, controlsView, saveGameView, loadGameView);
	}
	
	
	
	private void loadStartVisibility()
	{
		settingsView.setVisible(false);
		controlsView.setVisible(false);
		saveGameView.setVisible(false);
		loadGameView.setVisible(false);
		currentVisibleView = mainView;
	}
	
	private void swapView(Node view)
	{
		currentVisibleView.setVisible(false);
		view.setVisible(true);
		currentVisibleView = view;
	}


	private void loadMainView() 
	{
		mainView = new VBox(20);
		mainView.getChildren().addAll(saveGameBtn, loadGameBtn, settingsBtn, controlsBtn);
	}


	private void loadSaveGameView()
	{
		saveGameView = new GridPane();
		saveGameBtn = new Button("Save Game");
		saveGameBtn.setOnMouseClicked(event -> swapView(saveGameView));
		
		
		
		
		
		
		addReturnBtn(saveGameView);
	}


	private void loadLoadGameView() 
	{
		loadGameView = new GridPane();
		loadGameBtn = new Button("Load Game");
		loadGameBtn.setOnMouseClicked(event -> swapView(loadGameView));
		
		
		
		
		addReturnBtn(loadGameView);
	}


	private void loadControlsView() 
	{
		controlsView = new VBox(5);
		controlsBtn = new Button("Controls");
		controlsBtn.setOnMouseClicked(event -> swapView(controlsView));
		
		
		
		
		
		addReturnBtn(controlsView);
	}


	private void loadSettingsView() 
	{
		settingsView = new VBox(10);
		settingsBtn = new Button("Settings");
		settingsBtn.setOnMouseClicked(event -> swapView(settingsView));
		
		
		
		
		addReturnBtn(settingsView);
	}

	public void addReturnBtn(Pane pane)
	{
		Button returnBtn = new Button("Back");
		returnBtn.setOnMouseClicked(event -> swapView(mainView));
		pane.getChildren().add(returnBtn);
	}

	public Group getMenu()
	{
		return menu;
	}
	
	
}
