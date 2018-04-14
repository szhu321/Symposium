package mainGame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mainGame.backend.GameManager;
import mainGame.scene.PlayingScene;
import map.LevelDesign;
import map.Room;
import map.RoomDesign;
import map.Tile.Tile;
import map.obstacle.StoneWall;
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
