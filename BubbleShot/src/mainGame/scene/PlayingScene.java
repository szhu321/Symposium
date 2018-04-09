package mainGame.scene;

import java.util.List;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import map.Room;
import map.Tile.Tile;
import map.obstacle.Obstacle;
import sprite.item.Item;
import sprite.character.Character;

public class PlayingScene
{
	private Scene scene;
	private Group root;
	private GridPane tilesDis;
	private BorderPane headUpDis;
	private Group moveArea;
	private Room currentRoom;
	
	public PlayingScene(Room room)
	{
		currentRoom = room;
		loadRoom(room);
		scene = new Scene(root);
	}
	
	public void loadRoom(Room room)
	{
		root = new Group();
		loadTiles(room.getTiles());
		loadMoveArea(room);
		loadHeadsUpDis();
		root.getChildren().addAll(tilesDis, moveArea, headUpDis);
	}
	
	public void loadTiles(Tile[][] tiles)
	{
		tilesDis = new GridPane();
		for(int i = 0; i < tiles.length; i++)
			for(int j = 0; j < tiles[0].length; j++)
				tilesDis.add(tiles[i][j].getImageView(), j, i);
	}
	
	public void loadMoveArea(Room room)
	{
		moveArea = new Group();
		List<Obstacle> obstacle = room.getObstacles();
		List<Character> character = room.getCharacters();
		List<Item> items = room.getItems();
		for(Obstacle obs: obstacle)
			moveArea.getChildren().add(obs.getImgView());
	}
	
	public void updateCharacterLocation()
	{
		List<Character> characters = currentRoom.getCharacters();
		for(int i = 0; i < characters.size(); i++)
		{
			Character currentChar = characters.get(i);
			//incomplete;
		}
	}
	
	
	public void loadHeadsUpDis()
	{
		headUpDis = new BorderPane();
	}
	
	public Scene getScene()
	{
		return scene;
	}
	
	public Room getCurrentRoom()
	{
		return currentRoom;
	}
	
	public void setCurrentRoom(Room room)
	{
		currentRoom = room;
	}
}
