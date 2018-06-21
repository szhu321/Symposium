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
import sound.SoundEffects;

public class MainMenuController implements Initializable
{
	public BorderPane container;
	public MediaView backgroundVid;
	public Button playBtn;
	public Button mapEditorBtn;
	public Button settingsBtn;
	public Button quitBtn;
	
	private MediaPlayer mp;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		container.setPrefHeight(GameRunner.getResolutionHeight());
		container.setPrefWidth(GameRunner.getResolutionWidth());
		mp = SoundEffects.MENU_BACKGROUND_VID;
		mp.setAutoPlay(true);
		mp.setCycleCount(Integer.MAX_VALUE);
		backgroundVid.setMediaPlayer(mp);
	}
	
	public void loadGameBtnOnclick() throws Exception
	{
		GameRunner.getSceneTracker().switchToPlayMenuView();
		SoundEffects.MENU_SELECT_SOUND.playSound();
	}
	
	public void newGameBtnOnclick() throws Exception
	{
		GameRunner.getSceneTracker().switchToCharacterCreationView();
		SoundEffects.MENU_SELECT_SOUND.playSound();
	}
	
	public void settingsBtnOnclick() throws Exception
	{
		GameRunner.getSceneTracker().switchToSettingsView();
		SoundEffects.MENU_SELECT_SOUND.playSound();
	}
	
	public void quitBtnOnclick()
	{
		GameRunner.getWindow().close();
		SoundEffects.MENU_SELECT_SOUND.playSound();
	}

	
}
