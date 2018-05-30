package mainGame;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneTracker
{
	private static Scene scene;
	private static Stage window;
	private static Parent mainMenuview;
	private static Parent characterCreationView;
	private static Parent playMenuView;
	private static Parent levelPickerView;
	private static Parent settingsView;
	
	public static void setWindow(Stage window)
	{
		SceneTracker.window = window;
	}
	
	public static void setScene(Scene scene)
	{
		window.setScene(scene);
	}
	
	public static Parent getMainMenuview() {
		return mainMenuview;
	}

	public static void setMainMenuview(Parent mainMenuview)
	{
		SceneTracker.mainMenuview = mainMenuview;
	}

	public static Parent getCharacterCreationView()
	{
		return characterCreationView;
	}

	public static void setCharacterCreationView(Parent characterCreationView)
	{
		SceneTracker.characterCreationView = characterCreationView;
	}

	public static Parent getPlayMenuView()
	{
		return playMenuView;
	}

	public static void setPlayMenuView(Parent playMenuView)
	{
		SceneTracker.playMenuView = playMenuView;
	}

	public static Parent getLevelPickerView()
	{
		return levelPickerView;
	}

	public static void setLevelPickerView(Parent levelPickerView)
	{
		SceneTracker.levelPickerView = levelPickerView;
	}

	public static Parent getSettingsView()
	{
		return settingsView;
	}

	public static void setSettingsView(Parent settingsView)
	{
		SceneTracker.settingsView = settingsView;
	}

	public static void switchParent(Parent parent)
	{
		scene.setRoot(parent);
	}
}
