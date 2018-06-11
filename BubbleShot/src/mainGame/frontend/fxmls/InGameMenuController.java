package mainGame.frontend.fxmls;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import mainGame.GameRunner;

public class InGameMenuController 
{
	public Group menu;
	
	public VBox mainView;
	public VBox settingsView;
	public VBox controlsView;
	public VBox saveGameView;
	public VBox loadGameView;
	
	public Button settingsBtn;
	public Button controlsBtn;
	
	
	public void quitBtnOnclick() throws Exception
	{
		GameRunner.getSceneTracker().useScene();
		GameRunner.getSceneTracker().switchToMainMenuView();
	}
	
	public void controlsBtnOnclick()
	{
		
	}
	
}
