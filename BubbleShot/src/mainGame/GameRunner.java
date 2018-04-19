package mainGame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mainGame.backend.GameManager;
import map.LevelDesign;
import sprite.character.player.Player;
import sprite.character.player.PlayerDesign;

/**
 * Run this class to start the Program.
 * @author Sheng
 *
 */
public class GameRunner extends Application
{
	private static Stage window;
	
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
	
	/**
	 * Sets the scene of the game window.
	 * 
	 * @param scene The scene the window will show.
	 */
	public static void setScene(Scene scene)
	{
		window.setScene(scene);
	}
}
