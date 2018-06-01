package mainGame.fxmls;

import mainGame.GameRunner;
import mainGame.SceneTracker;

public class PlayMenuController
{
	public void backBtnOnclick() throws Exception
	{
		GameRunner.getSceneTracker().switchToMainMenuView();
	}
	
	public void createCharacterBtnOnclick() throws Exception
	{
		GameRunner.getSceneTracker().switchToCharacterCreationView();
	}
	
	public void chooseLevelBtnOnclick() throws Exception
	{
		GameRunner.getSceneTracker().switchToLevelPickerView();
	}
	
	public void startBtnOnclick()
	{
		
	}
}
