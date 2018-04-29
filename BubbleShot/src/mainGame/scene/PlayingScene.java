package mainGame.scene;

import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import mainGame.GameRunner;
import mainGame.frontend.HealthBar;
import javafx.scene.transform.Scale;
import map.Room;
import map.Tile.Tile;
import map.obstacle.Obstacle;
import myutilities.Camera;
import myutilities.TimeTracker;
import myutilities.TimerManager;
import sprite.item.Item;
import sprite.projectile.Projectile;
import sprite.character.Character;
import sprite.character.enemy.Enemy;
import sprite.character.player.Player;

/**
 * This is the front end of the game.
 * a new playing scene needs to be created when changing rooms.
 * This playing scene requires an update manually whenever the 
 * backend is updated. 
 * For instance when a projectile is added to the room. That projectile's
 * imageView need to be added to the playing scene by calling the 
 * addChildToMoveArea() method. The opposite is true.
 */
public class PlayingScene
{
	private Scene scene;
	private Group root;
	private Group tilesDis;
	private BorderPane headUpDis;
	private Group moveArea;
	private Room currentRoom;
	
	private Text playerHealthDis;
	private HealthBar healthbar;
	private Text playerAmmoDis;
	private Text playerScoreDis;
	private ImageView[] playerInventoryDis;
	
	private ImageView playerHoldItemDis;
	
	private HBox topHealthBox;
	
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
		tilesDis = new Group();
		for(int i = 0; i < tiles.length; i++)
			for(int j = 0; j < tiles[0].length; j++)
				tilesDis.getChildren().add(tiles[i][j].getSpriteImageView());
		updateTileLocation();
	}
	
	public void updateTileLocation()
	{
		Tile[][] tiles = currentRoom.getTiles();
		for(Tile[] tileArr: tiles)
		{
			for(Tile tile : tileArr)
			{
				tile.getSpriteImageView().setTranslateX(tile.getXLocation());
				tile.getSpriteImageView().setTranslateY(tile.getYLocation());
				tile.getSpriteImageView().setRotate(tile.getFaceAngle());
			}
		}
	}
	
	public void loadMoveArea()
	{
		moveArea = new Group();
		List<Obstacle> obstacles = currentRoom.getObstacles();
		List<Character> characters = currentRoom.getCharacters();
		List<Item> items = currentRoom.getItems();
		List<Projectile> projectiles = currentRoom.getProjectiles();
		for(Item item: items)
			moveArea.getChildren().add(item.getSpriteImageView());
		for(Character character: characters)
		{
			moveArea.getChildren().add(character.getSpriteImageView());
			if(character instanceof Enemy)
			{
				moveArea.getChildren().add(((Enemy) character).getWeapon().getSpriteImageView());
			}
		}
			
		for(Projectile projectile: projectiles)
			moveArea.getChildren().add(projectile.getSpriteImageView());
		for(Obstacle obs: obstacles)
			moveArea.getChildren().add(obs.getSpriteImageView());
		playerHoldItemDis = new ImageView();
		playerHoldItemDis.getTransforms().add(new Scale(.5,.5));
		moveArea.getChildren().add(playerHoldItemDis);
		loadEnemyHealthBar();
	}
	
	private void loadEnemyHealthBar()
	{
		List<Character> characters = currentRoom.getCharacters();
		for(int i = 0; i < characters.size(); i++)
		{
			Character currentChar = characters.get(i);
			if(currentChar instanceof Enemy)
			{
				moveArea.getChildren().add(((Enemy) currentChar).getHealthbar().getCanvas());
			}
		}
	}
	
	private GridPane getInventoryDisGUI()
	{
		GridPane bottomBox = new GridPane();
		bottomBox.setAlignment(Pos.BOTTOM_CENTER);
		bottomBox.setHgap(20);
		playerInventoryDis = new ImageView[currentRoom.getPlayer().getInventory().length];
		for(int i = 0; i < currentRoom.getPlayer().getInventory().length; i++)
		{
			StackPane stack = new StackPane();
			playerInventoryDis[i] = new ImageView();
			Text text = new Text("" + (i + 1));
			text.setFont(new Font(22));
			playerInventoryDis[i].getTransforms().add(new Scale(.83333,.83333));
			stack.getChildren().add(new ImageView(new Image("file:resources/other/blankInventorySlot.png", 60, 60, false, false)));
			stack.getChildren().add(text);
			stack.getChildren().add(playerInventoryDis[i]);
			stack.setAlignment(text, Pos.BOTTOM_RIGHT);
			bottomBox.add(stack, i, 0);
		}
		bottomBox.setStyle("-fx-background-color: #2257B4; -fx-background-radius: 20px;");
		return bottomBox;
	}
	
	public void loadHeadsUpDis()
	{
		headUpDis = new BorderPane();
		HBox topBox = new HBox(20);
		topBox.setPadding(new Insets(10, 10, 10, 10));
		
		playerHealthDis = new Text();
		playerAmmoDis = new Text();
		playerScoreDis = new Text();
		
		/*
		topHealthBox = new HBox(5);
		topHealthBox.setPrefWidth(200);
		topHealthBox.setStyle("-fx-background-color: #66ff33");
		HBox bottomHealthBox = new HBox(5);
		bottomHealthBox.setPrefWidth(200);
		bottomHealthBox.setStyle("-fx-background-color: #000000");
		StackPane healthBoxContainer = new StackPane();
		healthBoxContainer.getChildren().addAll(bottomHealthBox, topHealthBox);
		*/
	
		Button pauseBtn = new Button("Pause");
		pauseBtn.setOnMousePressed(event -> 
		{
			if(TimerManager.isPaused)
			{
				TimeTracker.resetTime();
				TimerManager.resumeAll();
				TimerManager.isPaused = false;
			}
			else
			{
				TimerManager.pauseAll();
				TimerManager.isPaused = true;
			}
		});
		
		healthbar = new HealthBar(400, 50, currentRoom.getPlayer().getDefaultHealth());
		
		topBox.getChildren().addAll(playerHealthDis, healthbar.getCanvas(), /*healthBoxContainer*/ playerAmmoDis, playerScoreDis, pauseBtn);
		topBox.setStyle("-fx-font-size: 15pt; -fx-background-color: #2257B4;");
		headUpDis.setTop(topBox);
		headUpDis.setBottom(getInventoryDisGUI());
		updateHeadUpDis();
	}
	
	public void updateHeadUpDis()
	{
		Player player = currentRoom.getPlayer();
		playerHealthDis.setText("Health: " + player.getCurrentHealth());
		healthbar.updateCanvas(player.getCurrentHealth());
		//topHealthBox.setPrefWidth(200 - ((20 - player.getCurrentHealth()) * 10));
		playerAmmoDis.setText("Ammo: " + player.getCurrentAmmo());
		playerScoreDis.setText("Score: " + player.getScore());
		for(int i = 0; i < player.getInventory().length; i++)
		{
			if(player.getInventory()[i] != null)
				playerInventoryDis[i].setImage(player.getInventory()[i].getSpriteImage());
			else
				playerInventoryDis[i].setImage(null);
			if(player.getCurrentItemIdx() == i)
			{
				//playerInventoryDis[i].setScaleX(1);
				playerInventoryDis[i].getTransforms().set(0, new Scale(1,1));
			}
			else
			{
				//playerInventoryDis[i].setScaleX(.83333);
				playerInventoryDis[i].getTransforms().set(0, new Scale(.83333,.83333));
			}
				
		}
		headUpDis.setMinHeight(GameRunner.getWindowHeight() - 65);
	}
	
	public void removeChildFromMoveArea(Node node)
	{
		moveArea.getChildren().remove(node);
		//System.out.println("removed");
	}
	
	public void addChildToMoveArea(Node node)
	{
		moveArea.getChildren().add(node);
		//System.out.println("added");
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
			item.getSpriteImageView().setRotate(item.getFaceAngle());
		}
	}
	
	public void updateObstacleLocation()
	{
		List<Obstacle> obstacles = currentRoom.getObstacles();
		for(Obstacle obs: obstacles)
		{
			obs.getSpriteImageView().setTranslateX(obs.getXLocation());
			obs.getSpriteImageView().setTranslateY(obs.getYLocation());
			obs.getSpriteImageView().setRotate(obs.getFaceAngle());
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
			currentChar.getSpriteImageView().setRotate(currentChar.getFaceAngle());
			if(currentChar instanceof Enemy)
			{
				((Enemy) currentChar).getWeapon().getSpriteImageView().setImage(((Enemy)currentChar).getWeapon().getSpriteImage());
				((Enemy) currentChar).getWeapon().getSpriteImageView().setTranslateX(currentChar.getXLocation() + currentChar.getWidth() / 2);
				((Enemy) currentChar).getWeapon().getSpriteImageView().setTranslateY(currentChar.getYLocation() + currentChar.getHeight() / 2);
				((Enemy) currentChar).getHealthbar().getCanvas().setTranslateX(currentChar.getXLocation() - 5);
				((Enemy) currentChar).getHealthbar().getCanvas().setTranslateY(currentChar.getYLocation() - 10);
			}
		}
	}
	
	public void updatePlayerHoldItem()
	{
		Player player = currentRoom.getPlayer();
		//System.out.println(player.getCurrentItemIdx());
		//System.out.println(player.getCurrentItem());
		if(player.getCurrentItem() == null)
			playerHoldItemDis.setImage(null);
		else
		{
			playerHoldItemDis.setImage(player.getCurrentItem().getSpriteImage());
			playerHoldItemDis.setTranslateX(player.getXLocation() + player.getWidth() / 2);
			playerHoldItemDis.setTranslateY(player.getYLocation() + player.getHeight() / 2);
			
		}
	}	
	
	public void updateCameraLocation()
	{
		
		moveArea.getTransforms().clear();
		tilesDis.getTransforms().clear();
		moveArea.getTransforms().add(new Translate(Camera.getxCoord(), Camera.getyCoord()));
		tilesDis.getTransforms().add(new Translate(Camera.getxCoord(), Camera.getyCoord()));
	}
	
	public void updateAllLocation()
	{
		updateCharacterLocation();
		updatePlayerHoldItem();
		updateItemLocation();
		updateProjectileLocation();
		updateObstacleLocation();
		updateHeadUpDis();
		updateCameraLocation();
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
