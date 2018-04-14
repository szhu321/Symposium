package mainGame.scene;

import java.util.List;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import map.Room;
import map.Tile.Tile;
import map.obstacle.Obstacle;
import sprite.item.Item;
import sprite.projectile.Projectile;
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
		List<Projectile> projectiles = currentRoom.getProjectiles();
		for(Character character: characters)
			moveArea.getChildren().add(character.getSpriteImageView());
		for(Item item: items)
			moveArea.getChildren().add(item.getSpriteImageView());
		for(Projectile projectile: projectiles)
			moveArea.getChildren().add(projectile.getSpriteImageView());
		for(Obstacle obs: obstacles)
			moveArea.getChildren().add(obs.getImgView());
	}
	
	public void removeChildFromMoveArea(ImageView imageView)
	{
		moveArea.getChildren().remove(imageView);
		System.out.println("removed");
	}
	
	public void addChildToMoveArea(ImageView imageView)
	{
		moveArea.getChildren().add(imageView);
		System.out.println("added");
	}
	
	public void updateProjectileLocation()
	{
		List<Projectile> projectiles = currentRoom.getProjectiles();
		for(Projectile projectile: projectiles)
		{
			projectile.getSpriteImageView().setTranslateX(projectile.getXLocation());
			projectile.getSpriteImageView().setTranslateY(projectile.getYLocation());
			projectile.getSpriteImageView().setRotate(projectile.getFaceAngle());
		}
	}
	
	public void updateItemLocation()
	{
		List<Item> items = currentRoom.getItems();
		for(Item item: items)
		{
			item.getSpriteImageView().setTranslateX(item.getXLocation());
			item.getSpriteImageView().setTranslateY(item.getYLocation());
		}
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
	
	public void updateAllLocation()
	{
		updateCharacterLocation();
		updateItemLocation();
		updateProjectileLocation();
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
