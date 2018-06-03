package mainGame.frontend.fxmls;

import javafx.scene.control.Button;
import mainGame.GameRunner;
import mainGame.SceneTracker;

public class MainMenuController
{
	public Button playBtn;
	public Button mapEditorBtn;
	public Button settingsBtn;
	public Button quitBtn;
	
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
