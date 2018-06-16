package mainGame.frontend.fxmls;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import mainGame.GameRunner;
import mainGame.backend.GameManager;

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
	
	public void resumeBtnOnclick()
	{
		GameRunner.getGameManager().getPlayingScene().toggleInGameMenu();
	}
	
	public void quitBtnOnclick() throws Exception
	{
		GameRunner.destroyGameManager();
		GameRunner.getSceneTracker().useMenuScene();
		GameRunner.getSceneTracker().switchToMainMenuView();
	}
	
	public void settingsBtnOnclick() throws Exception
	{
		GameRunner.getSceneTracker().useMenuScene();
		GameRunner.getSceneTracker().switchToSettingsView();
	}
	
}
