package mainGame.scene;

import javafx.application.Application;
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
		
		MenuScene menuScene = new MenuScene(window);
		
		window.show();
		
	}

}
