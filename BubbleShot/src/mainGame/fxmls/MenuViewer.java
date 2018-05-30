package mainGame.fxmls;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import map.Level;
import sprite.character.player.Player;

public class MenuViewer extends Application
{
	private Stage window;
	private Scene scene;
	
	private Parent mainMenu;
	private Parent characterCreation;
	private Parent playMenu;
	
	private Player player;
	private Level level;
	
	public static void main(String[] args) 
	{
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		window = primaryStage;
		window.setTitle("Menu");
		
		mainMenu = FXMLLoader.load(getClass().getResource("MainMenuView.fxml"));
		characterCreation = FXMLLoader.load(getClass().getResource("CharacterCreationView.fxml"));
		playMenu = FXMLLoader.load(getClass().getResource("PlayMenuView.fxml"));
		
		scene = new Scene(playMenu, 700, 500);
		window.setScene(scene);
		window.show();
		
	}

}
