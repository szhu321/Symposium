package mainGame;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneTracker
{
	private static Scene scene;
	private static Group root;
	private static Stage window;
	
	private static Parent currentView;
	
	private static Parent mainMenuview;
	private static Parent characterCreationView;
	private static Parent playMenuView;
	private static Parent levelPickerView;
	private static Parent settingsView;
	
	public static void initialize(Stage window, Scene scene, Group root)
	{
		SceneTracker.window = window;
		SceneTracker.scene = scene;
		window.setScene(scene);
	}
	
	public static void switchView(Parent view)
	{
		view.setVisible(true);
		currentView.setVisible(false);
		currentView = view;
	}
	
	public static Parent getMainMenuview()
	{
		return mainMenuview;
	}

	public static void setMainMenuview(Parent mainMenuview)
	{
		SceneTracker.mainMenuview = mainMenuview;
		root.getChildren().add(mainMenuview);
	}

	public static Parent getCharacterCreationView()
	{
		return characterCreationView;
	}

	public static void setCharacterCreationView(Parent characterCreationView)
	{
		SceneTracker.characterCreationView = characterCreationView;
		SceneTracker.characterCreationView.setVisible(false);
		root.getChildren().add(SceneTracker.characterCreationView);
	}

	public static Parent getPlayMenuView()
	{
		return playMenuView;
	}

	public static void setPlayMenuView(Parent playMenuView)
	{
		SceneTracker.playMenuView = playMenuView;
		SceneTracker.playMenuView.setVisible(false);
		root.getChildren().add(SceneTracker.playMenuView);
	}

	public static Parent getLevelPickerView()
	{
		return levelPickerView;
	}

	public static void setLevelPickerView(Parent levelPickerView)
	{
		SceneTracker.levelPickerView = levelPickerView;
		SceneTracker.levelPickerView.setVisible(false);
		root.getChildren().add(SceneTracker.levelPickerView);
	}

	public static Parent getSettingsView()
	{
		return settingsView;
	}

	public static void setSettingsView(Parent settingsView)
	{
		SceneTracker.settingsView = settingsView;
		SceneTracker.settingsView.setVisible(false);
		root.getChildren().add(SceneTracker.settingsView);
	}

	public static void switchParent(Parent parent)
	{
		scene.setRoot(parent);
	}

	
}
