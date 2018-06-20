package mainGame.frontend.fxmls;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import mainGame.GameRunner;
import mainGame.SceneTracker;

public class MainMenuController implements Initializable
{
	public BorderPane container;
	
	public MediaView backgroundVid;
	
	public Button playBtn;
	public Button mapEditorBtn;
	public Button settingsBtn;
	public Button quitBtn;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		container.setPrefHeight(GameRunner.getResolutionHeight());
		container.setPrefWidth(GameRunner.getResolutionWidth());
		
		MediaPlayer mp = new MediaPlayer(new Media(new File("resources/background/MainMenuBackgroundVid.mp4").toURI().toString()));
		mp.setAutoPlay(true);
		mp.setCycleCount(Integer.MAX_VALUE);
	//	backgroundVid.setFitHeight(GameRunner.getResolutionHeight());
		//backgroundVid.setFitWidth(GameRunner.getResolutionHeight());
		backgroundVid.setMediaPlayer(mp);
	}
	
	public void playBtnOnclick() throws Exception
	{
		GameRunner.getSceneTracker().switchToPlayMenuView();
	}
	
//	public void mapEditorBtnOnclick()
//	{
//		
//	}
	
	public void settingsBtnOnclick() throws Exception
	{
		GameRunner.getSceneTracker().switchToSettingsView();
	}
	
	public void quitBtnOnclick()
	{
		GameRunner.getWindow().close();
	}

	
}
