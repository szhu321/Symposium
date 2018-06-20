package mainGame.frontend.fxmls;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import mainGame.GameRunner;
import sound.SoundEffects;

public class GameOverViewController implements Initializable
{
	public BorderPane container;
	public GridPane innerCenterContainer;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		container.setPrefHeight(GameRunner.getResolutionHeight());
		container.setPrefWidth(GameRunner.getResolutionWidth());
		innerCenterContainer.setPrefHeight(GameRunner.getResolutionHeight());
		innerCenterContainer.setPrefWidth(GameRunner.getResolutionWidth());
	}
	
	public void mainManuBtnOnClick() throws Exception
	{
		GameRunner.destroyGameManager();
		SoundEffects.MOUSE_CLICK_SOUND.playSound();
		GameRunner.getSceneTracker().useMenuScene();
		GameRunner.getSceneTracker().switchToMainMenuView();
	}
}
