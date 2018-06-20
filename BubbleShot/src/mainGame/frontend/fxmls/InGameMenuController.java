package mainGame.frontend.fxmls;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import mainGame.GameRunner;
import mainGame.backend.GameManager;
import sound.BackgroundSound;
import sound.SoundEffects;

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
		SoundEffects.MOUSE_CLICK_SOUND.playSound();
		GameRunner.getGameManager().getPlayingScene().toggleInGameMenu();
	}
	
	public void quitBtnOnclick() throws Exception
	{
		GameRunner.destroyGameManager();
		SoundEffects.MOUSE_CLICK_SOUND.playSound();
		GameRunner.getSceneTracker().useMenuScene();
		GameRunner.getSceneTracker().switchToMainMenuView();
		BackgroundSound.stopAllBackgroundMusic();
	}
	
	public void settingsBtnOnclick() throws Exception
	{
		SoundEffects.MOUSE_CLICK_SOUND.playSound();
		GameRunner.getSceneTracker().useMenuScene();
		GameRunner.getSceneTracker().switchToSettingsView();
	}
	
}
