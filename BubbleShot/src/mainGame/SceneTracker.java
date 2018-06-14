package mainGame;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SceneTracker
{
	private Scene scene;
	private Group root;
	private Stage window;
	
	public SceneTracker(Stage window)
	{
		this.window = window;
		root = new Group();
		scene = new Scene(root);
		scene.getStylesheets().add("mainGame/frontend/fxmls/button.css");
		this.window.setScene(scene);
	}
	
	public void useMenuScene()
	{
		window.setScene(scene);
	}
	
	public void switchToMainMenuView() throws Exception
	{
		root.getChildren().setAll((BorderPane)FXMLLoader.load(getClass().getResource("/mainGame/frontend/fxmls/MainMenuView.fxml")));
	}
	
	public void switchToPlayMenuView() throws Exception
	{
		root.getChildren().setAll((BorderPane)FXMLLoader.load(getClass().getResource("/mainGame/frontend/fxmls/PlayMenuView.fxml")));
	}
	
	public void switchToCharacterCreationView() throws Exception
	{
		root.getChildren().setAll((BorderPane)FXMLLoader.load(getClass().getResource("/mainGame/frontend/fxmls/CharacterCreationView.fxml")));
	}
	
	public void switchToLevelPickerView() throws Exception
	{
		root.getChildren().setAll((GridPane)FXMLLoader.load(getClass().getResource("/mainGame/frontend/fxmls/LevelPickerView.fxml")));
	}
	
	public void switchToSettingsView() throws Exception
	{
		root.getChildren().setAll((BorderPane)FXMLLoader.load(getClass().getResource("/mainGame/frontend/fxmls/SettingsView.fxml")));
	}
	
	public void switchToControlsView() throws Exception
	{
		root.getChildren().setAll((BorderPane)FXMLLoader.load(getClass().getResource("/mainGame/frontend/fxmls/ControlsView.fxml")));
	}
	
	public void switchToGraphicsView() throws Exception
	{
		root.getChildren().setAll((BorderPane)FXMLLoader.load(getClass().getResource("/mainGame/frontend/fxmls/GraphicsView.fxml")));
	}
}
