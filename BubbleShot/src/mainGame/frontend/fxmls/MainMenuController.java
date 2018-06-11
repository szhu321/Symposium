package mainGame.frontend.fxmls;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import mainGame.GameRunner;
import mainGame.SceneTracker;

public class MainMenuController implements Initializable
{
	public BorderPane container;
	
	public Button playBtn;
	public Button mapEditorBtn;
	public Button settingsBtn;
	public Button quitBtn;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		container.setPrefHeight(GameRunner.getResolutionHeight());
		container.setPrefWidth(GameRunner.getResolutionWidth());
	}
	
	public void playBtnOnclick() throws Exception
	{
		GameRunner.getSceneTracker().switchToPlayMenuView();
	}
	
	public void mapEditorBtnOnclick()
	{
		
	}
	
	public void settingsBtnOnclick()
	{
		
	}
	
	public void quitBtnOnclick()
	{
		GameRunner.getWindow().close();
	}

	
}
