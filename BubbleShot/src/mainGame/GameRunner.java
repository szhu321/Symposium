package mainGame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mainGame.scene.PlayingScene;
import map.Room;
import map.Tile.Tile;
import map.obstacle.StoneWall;

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
		
		Room room = new Room();
		room.addObstacle(new StoneWall(50, 1000,0,0));
		room.addObstacle(new StoneWall(50, 1000,950,0));
		room.addObstacle(new StoneWall(1000, 50,0,0));
		room.addObstacle(new StoneWall(1000, 50,0,950));
		room.addObstacle(new StoneWall(200,200,200,200));
		room.addObstacle(new StoneWall(200,200,200,600));
		room.addObstacle(new StoneWall(200,200,600,600));
		room.addObstacle(new StoneWall(200,200,600,200));
		
		PlayingScene playScene = new PlayingScene(room);
		window.setScene(playScene.getScene());
		window.show();
	}
}
