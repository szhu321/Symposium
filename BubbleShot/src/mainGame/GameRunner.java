package mainGame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mainGame.scene.PlayingScene;

public class GameRunner extends Application
{
	private Stage window;
	private Scene scene;
	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		window = primaryStage;
		PlayingScene playScene = new PlayingScene(null);
	}
}
