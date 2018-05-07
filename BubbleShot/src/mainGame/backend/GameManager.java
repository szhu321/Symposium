package mainGame.backend;

import java.util.List;

import javafx.animation.KeyFrame;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import mainGame.GameRunner;
import mainGame.scene.PlayingScene;
import map.Level;
import map.Room;
import map.Tile.Tile;
import map.Tile.teleporter.RoomPortManager;
import map.Tile.teleporter.Teleporter;
import map.Tile.teleporter.TeleporterPair;
import myutilities.Camera;
import myutilities.TimeTracker;
import myutilities.TimerManager;
import sprite.character.player.Player;
import sprite.item.Item;
import sprite.item.potion.Potion;
import sprite.character.Character;
import sprite.character.enemy.Enemy;
import sprite.character.enemy.ai.AI;
import sprite.projectile.LinearProjectile;
import sprite.projectile.Projectile;
import sprite.projectile.ProjectileDesign;

/**
 * The game manager will run a level of the game. 
 * Creating the game manager requires a level and a player.
 * The player can be from past levels.
 * Calling the startGame method starts the animation loop.
 */
public class GameManager
{
	private Level level;
	private Player player;
	private PlayingScene playingScene;
	private static Stage window;
	private int framesPerSec = 60;
	
	private Boolean up = false;
	private Boolean down = false;
	private Boolean left = false;
	private Boolean right = false;
	private Boolean shift = false;
	private Boolean mouseDown = false;
	private double mouseAngle = 0.0;
	
	private double mouseX = 0.0;
	private double mouseY = 0.0;
	private double mouseXUnajusted = 0.0;
	private double mouseYUnajusted = 0.0;
	
	
	public GameManager(Level level, Player player)
	{
		this.level = level;
		this.player = player;
		playingScene = new PlayingScene(this.level.getCurrentRoom());
		setSceneControls(playingScene.getScene());
	}
	
	public void startGame(Stage window)
	{
		TimeTracker.resetTime();
		KeyFrame keyframe = new KeyFrame(Duration.seconds(1.0/framesPerSec), event -> 
		{
			//Runs in 60FPS
			//long pasttime = System.nanoTime();
			nextFrame(1000.0/framesPerSec);
			//long now = System.nanoTime();
			//System.out.println("totalTime Passed: " + ((now - pasttime ) / 1000000) + " ms.");
			//pasttime = now;
			//System.out.println("\n\n\n");
		});
		TimerManager.addKeyFrameToNewTimeline(keyframe);
		this.window = window;
		setScene(playingScene.getScene());
	}
	
	public static void setScene(Scene scene)
	{
		window.setScene(scene);
	}
	
	public void changeRoom()
	{
		TimerManager.pauseAll();
		resetKeys();
		playingScene = new PlayingScene(this.level.getCurrentRoom());
		setSceneControls(playingScene.getScene());
		GameRunner.setScene(playingScene.getScene());
		TimerManager.resumeAll();
	}
	
	public void resetKeys()
	{
		up=false;
		down=false;
		left=false;
		right=false;
		shift=false;
	}
	
	/**
	 * Runs the next frame;
	 * @param second - the time passed since the last frame.
	 */
	public void nextFrame(double milliSecond)
	{
		movePlayer(((double)milliSecond) / 1000);
		moveEnemy(((double)milliSecond) / 1000);
		coolDownAllWeapons(((double)milliSecond) / 1000);
		updateCameraLocation();
		calculateMouseAngleToPlayer();
		readjustMousePosDueToCameraMovement();
		player.setFaceAngle(mouseAngle);
		checkCharacterCollisionWithTile();
		updateProjectileLocation((double) milliSecond);
		checkProjectileCollision();
		if(mouseDown)
		{
			player.useCurrentItem(Item.WEAPON);
		}
		manageCharacterDeath();
		runAllCharacterEffects();
		playingScene.updateAllLocation();
	}
	
	public void nextFrame2(long milliSecond)
	{
		long pasttime = System.nanoTime();
		//System.out.println(((double)milliSecond) / 1000);
		movePlayer(((double)milliSecond) / 1000);
		long now = System.nanoTime();
		System.out.println("Time Passed After Moving Player: " + (now - pasttime));
		pasttime = now;
		
		moveEnemy(((double)milliSecond) / 1000);
		now = System.nanoTime();
		System.out.println("Time Passed After Moving Enemy: " + (now - pasttime));
		pasttime = now;
		
		coolDownAllWeapons(((double)milliSecond) / 1000);
		now = System.nanoTime();
		System.out.println("Time Passed After Cool Weapon: " + (now - pasttime));
		pasttime = now;
		
		updateCameraLocation();
		now = System.nanoTime();
		System.out.println("Time Passed After UpdateCamera: " + (now - pasttime));
		pasttime = now;
		
		calculateMouseAngleToPlayer();
		now = System.nanoTime();
		System.out.println("Time Passed After Mouse to Player angle: " + (now - pasttime));
		pasttime = now;
		
		readjustMousePosDueToCameraMovement();
		now = System.nanoTime();
		System.out.println("Time Passed After Mouse to Player angle fix: " + (now - pasttime));
		pasttime = now;
		
		player.setFaceAngle(mouseAngle);
		now = System.nanoTime();
		System.out.println("Time Passed After setting player faceAngle: " + (now - pasttime));
		pasttime = now;
		
		checkCharacterCollisionWithTile();
		now = System.nanoTime();
		System.out.println("Time Passed After character collision with tile: " + (now - pasttime));
		pasttime = now;
		
		updateProjectileLocation((double) milliSecond);
		now = System.nanoTime();
		System.out.println("Time Passed After update projectile location: " + (now - pasttime));
		pasttime = now;
		
		checkProjectileCollision();
		now = System.nanoTime();
		System.out.println("Time Passed After check projectile collision: " + (now - pasttime));
		pasttime = now;
		
		//System.out.println("Frame rate: " + 1/(((double)milliSecond) / 1000));
		if(mouseDown)
		{
			//addProjectile(ProjectileDesign.getBulletDesignOne(Projectile.SHOT_BY_PLAYER, player.getXLocation(), player.getYLocation(), player.getFaceAngle(), 10));
			player.useCurrentItem(Item.WEAPON);
		}
		now = System.nanoTime();
		System.out.println("Time Passed After useing player item: " + (now - pasttime));
		pasttime = now;
		
		manageCharacterDeath();
		now = System.nanoTime();
		System.out.println("Time Passed After managing character death: " + (now - pasttime));
		pasttime = now;
		
		runAllCharacterEffects();
		now = System.nanoTime();
		System.out.println("Time Passed After character effect run: " + (now - pasttime));
		pasttime = now;
		
		playingScene.updateAllLocation();
		now = System.nanoTime();
		System.out.println("Time Passed After update front end: " + (now - pasttime));
		pasttime = now;
		
		
		
		
		/*if(!level.getCurrentRoom().getProjectiles().isEmpty())
		{
			System.out.println("player angle: " + player.getfaceAngle());
			System.out.println("x: " + level.getCurrentRoom().getProjectiles().get(0).getXLocation());
			System.out.println("y: " + level.getCurrentRoom().getProjectiles().get(0).getYLocation());
		}*/
		
	}
	
	public void updateCameraLocation()
	{
		Player player = level.getCurrentRoom().getPlayer();
		Camera.shiftCamera(player.getXLocation() + player.getWidth() / 2, player.getYLocation() + player.getHeight() / 2, GameRunner.getWindowWidth(), GameRunner.getWindowHeight());
	}
	
	public void runAllCharacterEffects()
	{
		for(Character c: level.getCurrentRoom().getCharacters())
			c.getEffectManager().runAllEffect();
	}
	
	public void manageCharacterDeath()
	{
		List<Character> characters = level.getCurrentRoom().getCharacters();
		for(int i = characters.size() - 1; i >= 0; i--)
			if(characters.get(i).getCurrentHealth() <= 0)
			{
				if(characters.get(i) instanceof Player)
				{
					TimerManager.pauseAll();
				}
				else
				{
/////					playingScene.removeChildFromMoveArea(characters.get(i).getSpriteImageView());
/////					playingScene.removeChildFromMoveArea(((Enemy)characters.get(i)).getWeapon().getSpriteImageView());
/////					playingScene.removeChildFromMoveArea(((Enemy)characters.get(i)).getHealthbar().getCanvas());
					level.getCurrentRoom().removeCharacter(characters.get(i));
				}
			}
		//Checks to see if any enemy are still alive
		boolean isEnemyAlive = false;
		for(Character character : characters)
		{
			if(character instanceof Enemy)
			{
				isEnemyAlive = true;
				break;
			}
		}
		if(!isEnemyAlive)
			level.getCurrentRoom().getRoomTeleporterManager().activateAllTeleporters();
	}
	
	private void readjustMousePosDueToCameraMovement()
	{
		mouseX = mouseXUnajusted - Camera.getxCoord();
		mouseY = mouseYUnajusted - Camera.getyCoord();
	}
	
	public void checkCharacterCollisionWithTile()
	{
		List<Character> characters= level.getCurrentRoom().getCharacters();
		for(Character character: characters)
		{
			Tile grabbedTile = level.getCurrentRoom().characterCollisionWithTile(character);
			//System.out.println(grabbedTile);
			if(grabbedTile != null)
				character.getEffectManager().addEffect(grabbedTile.getEffects());
		}
	}
	
	public void coolDownAllWeapons(double sec)
	{
		List<Character> characters= level.getCurrentRoom().getCharacters();
		for(Character character : characters)
			character.coolDownWeapons(sec);
	}

	public void checkProjectileCollision()
	{
		List<Projectile> projectiles = level.getCurrentRoom().getProjectiles();
		for(int i = projectiles.size() - 1; i >= 0; i--)
		{
			Projectile currentProjectile = projectiles.get(i);
			if(level.getCurrentRoom().projectileCollide(currentProjectile))
			{
				removeProjectile(currentProjectile);
			}
		}
	}
	
	public void addProjectile(Projectile projectile)
	{
		level.getCurrentRoom().addProjectile(projectile);
/////		playingScene.addProjectileToArea(projectile.getSpriteImageView());
	}
	
	public void updateProjectileLocation(double millisecond)
	{
		List<Projectile> projectiles = level.getCurrentRoom().getProjectiles();
		for(int i = projectiles.size() - 1; i >= 0; i--)
		{
			projectiles.get(i).updateLocation(millisecond);
			if(((LinearProjectile)projectiles.get(i)).getTravelPath().getDistanceTraveled() > projectiles.get(i).getRange())
				removeProjectile(projectiles.get(i));
		}
	}
	
	public void removeProjectile(Projectile projectile)
	{
		level.getCurrentRoom().removeProjectile(projectile);
/////		playingScene.removeProjectileFromArea(projectile.getSpriteImageView());
	}
	
	public void movePlayer(double sec)
	{
		double deltaX = 0;
		double deltaY = 0;
		double changeAmount = player.getSpeed() * sec;
		Room currentRoom = level.getCurrentRoom();
		if(shift)
			changeAmount *= 1.2;
		if(left && currentRoom.canCharacterMove(player, Constants.MOVE_DIR_LEFT, changeAmount))
			deltaX -= changeAmount;
		if(right && currentRoom.canCharacterMove(player, Constants.MOVE_DIR_RIGHT, changeAmount))
			deltaX += changeAmount;
		if(up && currentRoom.canCharacterMove(player, Constants.MOVE_DIR_UP, changeAmount))
			deltaY -= changeAmount;
		if(down && currentRoom.canCharacterMove(player, Constants.MOVE_DIR_DOWN, changeAmount))
			deltaY += changeAmount;
		if(deltaX != 0 && deltaY != 0)
		{
			deltaX *= 1 / Math.sqrt(2);
			deltaY *= 1 / Math.sqrt(2);
		}
		player.addXLocation(deltaX);
		player.addYLocation(deltaY);
	}

    public void moveEnemy(double sec)
    {
    	List<Character> enemies=level.getCurrentRoom().getCharacters();
    	for(Character e:enemies)
    		if(e instanceof Enemy)
    		{
    			((Enemy)e).getBrain().move(sec, level);
    			calculateEnemyAngleToPlayer((Enemy)e);
    			((Enemy)e).useCurrentItem(Item.WEAPON);
    		}
   	}
    
	public void pauseGame()
	{
		TimerManager.pauseAll();
		TimerManager.isPaused = true;
	}
	
	public void unPauseGame()
	{
		TimeTracker.resetTime();
		TimerManager.resumeAll();
		TimerManager.isPaused = false;
	}
	
	public Level getLevel()
	{
		return level;
	}
	
	public PlayingScene getPlayingScene()
	{
		return playingScene;
	}
	
	private void calculateMouseAngleToPlayer()
	{
		double distanceX = mouseX - (player.getXLocation() + player.getWidth()/2);
		double distanceY = mouseY - (player.getYLocation() + player.getHeight()/2);
		mouseAngle = Math.toDegrees(Math.atan(distanceY / distanceX));
		if(distanceY <= 0 && distanceX < 0)
			mouseAngle += 180;
		else if(distanceY > 0 && distanceX < 0)
			mouseAngle = 90 + (90 - Math.abs(mouseAngle));
		else if(distanceX > 0 && distanceY < 0)
			mouseAngle += 360;
	}
	private void calculateEnemyAngleToPlayer(Enemy enemy)
	{
		double distanceX = (player.getXLocation()+(player.getWidth()/2)) - enemy.getXLocation() - enemy.getWidth()/2;
		double distanceY = (player.getYLocation()+(player.getHeight()/2)) - enemy.getYLocation() - enemy.getHeight()/2;
		double enemyAngle = Math.toDegrees(Math.atan(distanceY / distanceX));
		if(distanceY <= 0 && distanceX < 0)
			enemyAngle += 180;
		else if(distanceY > 0 && distanceX < 0)
			enemyAngle = 90 + (90 - Math.abs(enemyAngle));
		else if(distanceX > 0 && distanceY < 0)
			enemyAngle += 360;
		enemy.setFaceAngle(enemyAngle);
	}
	
	public void playerPickUpItem()
	{
		Item item = level.getCurrentRoom().characterCollisionWithItem(player);
		if(item != null && !player.isInventoryFull())
		{
			level.getCurrentRoom().removeItem(item);
/////			playingScene.removeChildFromMoveArea(item.getSpriteImageView());
			player.addItem(item);
		}
	}
	
	public void playerDropItem()
	{
		Item item = player.removeCurrentItem();
		if(item != null)
		{
			item.setXLocation(player.getXLocation());
			item.setYLocation(player.getYLocation());
			level.getCurrentRoom().addItem(item);
/////			playingScene.addChildToMoveArea(item.getSpriteImageView());
		}
	}
	
	public void setSceneControls(Scene scene)
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
			if(code == KeyCode.E)
				playerPickUpItem();
			if(code == KeyCode.DIGIT1)
				player.setCurrentItemIdx(0);
			if(code == KeyCode.DIGIT2)
				player.setCurrentItemIdx(1);
			if(code == KeyCode.DIGIT3)
				player.setCurrentItemIdx(2);
			if(code == KeyCode.DIGIT4)
				player.setCurrentItemIdx(3);
			if(code == KeyCode.DIGIT5)
				player.setCurrentItemIdx(4);
			if(code == KeyCode.DIGIT6)
				player.setCurrentItemIdx(5);
			if(code == KeyCode.G)
				playerDropItem();
			if(code == KeyCode.F)
			{
				if(player.getCurrentItem() instanceof Potion)
				{
					player.useCurrentItem(Item.POTION);
					player.removeCurrentItem();
				}
			}
			if(code == KeyCode.P)
			{
				if(TimerManager.isPaused)
					unPauseGame();
				else
					pauseGame();
			}
			if(code==KeyCode.T)
			{
				boolean enemiesAlive=false;
				Tile[][] teleChecker=level.getCurrentRoom().getTiles();
				for(Character c: level.getCurrentRoom().getCharacters())
					if(c instanceof Enemy)
					{
						enemiesAlive=true;
						break;
					}
				
				for(int i=0; i<teleChecker.length;i++)
				{
					for(int s=0;s<teleChecker[0].length;s++)
					{
						if(teleChecker[i][s] instanceof Teleporter && teleChecker[i][s].getBoundsOfObject().contains(player.getBoundsOfObject()))
						{	
							List<Teleporter> allTele=this.getLevel().getCurrentRoom().getPortManager().getRoomPorters();
							for(Teleporter t:allTele)
							{
								if(t.getXLocation()/100==s && t.getYLocation()/100==i)
								{
									Teleporter currentTele=t;
									//System.out.println(currentTele.getConnectedTeleporter().getId());
									//System.out.println(currentTele.getId());
									int row=currentTele.getConnectedTeleporter().getConnectedRoom().getLevelRow();
									int col=currentTele.getConnectedTeleporter().getConnectedRoom().getLevelCol();
									//System.out.println(row);
									//System.out.println(col);
									if(!enemiesAlive)
									{
										this.level.setCurrentRoom(row, col);
										player.setXLocation(currentTele.getConnectedTeleporter().getXLocation() + 10);
										player.setYLocation(currentTele.getConnectedTeleporter().getYLocation() + 10);
										changeRoom();
										break;
									}
									break;
								}							
							}
							break;
						}
					}
				}
			}
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
				default: break;
			}
		});
		scene.addEventHandler(MouseEvent.ANY, event -> 
		{
			mouseXUnajusted = event.getX();
			mouseYUnajusted = event.getY();
		});
		scene.setOnMousePressed(event -> mouseDown = true);
		scene.setOnMouseReleased(event -> mouseDown = false);
		scene.setOnScroll(event -> 
		{
			if(event.getDeltaY() > 0)
			{
				player.setCurrentItemIdx((player.getCurrentItemIdx() + 1) % 6);
			}
			else
			{
				if(player.getCurrentItemIdx() - 1 < 0)
					player.setCurrentItemIdx(5);
				else
					player.setCurrentItemIdx(player.getCurrentItemIdx() - 1);
			}
		});
	}
}
