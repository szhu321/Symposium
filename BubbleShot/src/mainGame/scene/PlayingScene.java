package mainGame.scene;

import java.util.List;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import map.Room;
import map.Tile.Tile;
import map.obstacle.Obstacle;
import sprite.item.Item;
import sprite.character.Character;
import sprite.character.player.Player;

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
		loadRoom();
		scene = new Scene(root);
	}
	
	public void loadRoom()
	{
		root = new Group();
		loadTiles(currentRoom.getTiles());
		loadMoveArea();
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
	
	public void loadMoveArea()
	{
		moveArea = new Group();
		List<Obstacle> obstacles = currentRoom.getObstacles();
		List<Character> characters = currentRoom.getCharacters();
		List<Item> items = currentRoom.getItems();
		for(Character character: characters)
			moveArea.getChildren().add(character.getSpriteImageView());
		for(Item item: items)
			moveArea.getChildren().add(item.getSpriteImageView());
		for(Obstacle obs: obstacles)
			moveArea.getChildren().add(obs.getImgView());
	}
	
	public void updateCharacterLocation()
	{
		List<Character> characters = currentRoom.getCharacters();
		for(int i = 0; i < characters.size(); i++)
		{
			Character currentChar = characters.get(i);
			currentChar.getSpriteImageView().setTranslateX(currentChar.getXLocation());
			currentChar.getSpriteImageView().setTranslateY(currentChar.getYLocation());
			currentChar.getSpriteImageView().setRotate(currentChar.getfaceAngle());
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
