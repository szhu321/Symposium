package mainGame.frontend.fxmls;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import mainGame.GameRunner;
import mainGame.SceneTracker;

public class SettingsViewController implements Initializable
{
	public BorderPane container;
	public Button controlBtn;
	public Button graphicsBtn;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		container.setPrefHeight(GameRunner.getResolutionHeight());
		container.setPrefWidth(GameRunner.getResolutionWidth());
	}
	
	public void soundBtnOnclick() throws Exception
	{
		GameRunner.getSceneTracker().swtichToSoundView();
	}
	
	public void controlBtnOnclick() throws Exception
	{
		GameRunner.getSceneTracker().switchToControlsView();
	}
	
	public void graphicsBtnOnclick() throws Exception
	{
		GameRunner.getSceneTracker().switchToGraphicsView();
	}
	
	public void backBtnOnclick() throws Exception
	{
		if(GameRunner.getGameManager() == null)
			GameRunner.getSceneTracker().switchToMainMenuView();
		else
			GameRunner.setScene(GameRunner.getGameManager().getPlayingScene().getScene());
	}
	
}
