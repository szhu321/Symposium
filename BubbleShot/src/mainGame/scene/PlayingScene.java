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
	
	private Boolean up = false;
	private Boolean down = false;
	private Boolean left = false;
	private Boolean right = false;
	private Boolean shift = false;
	private double mouseAngle = 0.0;
	
	private double mouseX = 0.0;
	private double mouseY = 0.0;
	
	private Character player;
	
	public PlayingScene(Room room)
	{
		currentRoom = room;
		loadRoom(room);
		scene = new Scene(root);
		for(Character character: room.getCharacters())
			if(character instanceof Player)
				player = character;
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
		List<Obstacle> obstacles = room.getObstacles();
		List<Character> characters = room.getCharacters();
		List<Item> items = room.getItems();
		for(Obstacle obs: obstacles)
			moveArea.getChildren().add(obs.getImgView());
		for(Character character: characters)
			moveArea.getChildren().add(character.getSpriteImageView());
		for(Item item: items)
			moveArea.getChildren().add(item.getSpriteImageView());
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
	
	private void caculateMouseAngleToPlayer()
	{
		double distanceX = mouseX - player.getXLocation() - player.getSpriteImageView().getBoundsInLocal().getWidth()/2;
		double distanceY = mouseY - player.getYLocation() - player.getSpriteImageView().getBoundsInLocal().getHeight()/2;
		mouseAngle = Math.toDegrees(Math.atan(distanceY / distanceX));
		if(distanceY <= 0 && distanceX < 0)
			mouseAngle += 180;
		if(distanceY > 0 && distanceX < 0)
			mouseAngle = 90 + (90 - Math.abs(mouseAngle));
	}
	
	public void setSceneControls()
	{
		scene.setOnKeyPressed(event -> 
		{
			KeyCode code = event.getCode();
			if(code == KeyCode.W)
				up = true;
			if(code == KeyCode.A)
				left = true;
			if(code == KeyCode.S)
				down = true;
			if(code == KeyCode.D)
				right = true;
			if(code == KeyCode.SHIFT)
				shift = true;
		});
		scene.setOnKeyReleased(event -> 
		{
			switch(event.getCode())
			{
				case W: up = false; break;
				case A: left = false; break;
				case S: down = false; break;
				case D: right = false; break;
				case SHIFT: shift = false; break;
			}
		});
		scene.addEventHandler(MouseEvent.ANY, event -> 
		{
			mouseX = event.getX();
			mouseY = event.getY();
		});
	}
}
