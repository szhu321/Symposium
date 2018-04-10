package mainGame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mainGame.scene.PlayingScene;
import map.Room;
import map.RoomDesign;
import map.Tile.Tile;
import map.obstacle.StoneWall;
import sprite.character.player.PlayerDesign;

public class GameRunner extends Application
{
	private Stage window;
	private PlayingScene playScene;
	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		window = primaryStage;
		window.setTitle("Little Boy");
		
		
		playScene = new PlayingScene(RoomDesign.getRoomDesignOne(PlayerDesign.getSimpleStarterPlayer("Player1")));
		
		
		
		
		window.setScene(playScene.getScene());
		window.show();
		
		
		AnimationTimer animation = new AnimationTimer()
		{
			@Override
			public void handle(long systime)
			{
				playScene.updateCharacterLocation();
			}
		};
		animation.start();
	}
}
