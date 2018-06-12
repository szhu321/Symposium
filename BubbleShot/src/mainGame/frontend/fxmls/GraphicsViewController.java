package mainGame.frontend.fxmls;

import mainGame.GameRunner;

public class GraphicsViewController
{
	public void backBtnOnclick() throws Exception
	{
		GameRunner.getSceneTracker().switchToSettingsView();
	}
}
