package mainGame.scene;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameSceneTest extends Application
{
	private Stage window;
	
	
	public static void main(String[] args) 
	{
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		window = primaryStage;
		window.setTitle("BubbleSHOT");
		
		//MenuScene menuScene = new MenuScene(window);
		Parent root = FXMLLoader.load(getClass().getResource("CharacterCreationView.fxml"));
		window.setScene(new Scene(root));
		window.show();
		
	}

}
