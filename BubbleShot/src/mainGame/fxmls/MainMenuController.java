package mainGame.fxmls;

import javafx.scene.control.Button;
import mainGame.SceneTracker;

public class MainMenuController
{
	public Button playBtn;
	public Button mapEditorBtn;
	public Button settingsBtn;
	public Button quitBtn;
	
	public void playBtnOnclick()
	{
		SceneTracker.switchParent(SceneTracker.getPlayMenuView());
	}
	
	public void mapEditorBtnOnclick()
	{
		
	}
	
	public void settingsBtnOnclick()
	{
		
	}
	
	public void quitBtnOnclick()
	{
		
	}
}
