package mainGame;

import javafx.application.Application;
import javafx.stage.Stage;
import mainGame.backend.GameManager;
import map.LevelDesign;
import sprite.character.player.Player;
import sprite.character.player.PlayerDesign;

public class GameRunner extends Application
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
		window.setTitle("Little Boy");
		
		
		Player player = PlayerDesign.getSimpleStarterPlayer("Joy");
		GameManager gameManager = new GameManager(LevelDesign.getLevelDesignOne(player), player);
		gameManager.startGame();
		
		window.setScene(gameManager.getPlayingScene().getScene());
		window.show();
	}
}
