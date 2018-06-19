package mainGame.backend;

import java.awt.Event;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import mainGame.GameRunner;
import mainGame.scene.PlayingScene;
import map.Level;
import map.Room;
import map.Tile.Tile;
import map.Tile.TileDesign;
import map.Tile.teleporter.LevelTele;
import map.Tile.teleporter.RoomPortManager;
import map.Tile.teleporter.Teleporter;
import map.Tile.teleporter.TeleporterDesign;
import map.Tile.teleporter.TeleporterPair;
import map.obstacle.Obstacle;
import map.obstacle.Shop;
import myutilities.Camera;
import myutilities.MyMath;
import myutilities.TimeTracker;
import myutilities.TimerManager;
import sprite.character.player.Player;
import sprite.item.Item;
import sprite.item.ammo.Ammo;
import sprite.item.collectable.CoinDesign;
import sprite.item.collectable.InstantCollect;
import sprite.item.potion.Potion;
import sprite.item.weapon.Weapon;
import sprite.character.Character;
import sprite.character.enemy.Boss;
import sprite.character.enemy.Enemy;
import sprite.character.enemy.Spawner;
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
	
	private boolean up = false;
	private boolean down = false;
	private boolean left = false;
	private boolean right = false;
	private boolean shift = false;
	private boolean mouseDownLeft = false;
	private boolean mouseDownRight = false;
	private double mouseAngle = 0.0;
	private boolean isClick = false;
	
	private boolean displayInventory = false;
	
	private double mouseX = 0.0;
	private double mouseY = 0.0;
	private double mouseXUnajusted = 0.0;
	private double mouseYUnajusted = 0.0;
	
	private Teleporter currentTeleporterTracker;
	
	private Controls controls;
	
	public GameManager(Level level, Player player, Stage window, Controls controls)
	{
		this.level = level;
		this.player = player;
		this.level.getCurrentRoom().addCharacter(player);
		playingScene = new PlayingScene(this.level.getCurrentRoom());
		setSceneControls(playingScene.getScene());
		this.window = window;
		this.controls = controls;
		TimerManager.reset();
	}
	
	public void startGame()
	{
		TimeTracker.resetTime();
		setScene(playingScene.getScene());
		KeyFrame keyframe = new KeyFrame(Duration.seconds(1.0/framesPerSec), event -> 
		{
			//Runs in 60FPS
			//long pasttime = System.nanoTime();
			nextFrame(1000.0/framesPerSec);
			//long now = System.nanoTime();
			//System.out.println("totalTime Passed: " + ((now - pasttime ) / 1000000) + " ms.");
			//pasttime = now;
			//System.out.println("\n\n\n");
			//System.out.println(level.allDead());
		});
		TimerManager.addKeyFrameToNewTimeline(keyframe);
	}
	
	public static void setScene(Scene scene)
	{
		window.setScene(scene);
		//window.setHeight(800);
		//window.setWidth(800);
	}
	
	public void changeRoom()
	{
		TimerManager.pauseAll();
		resetKeys();
		if(this.level.getCurrentRoom().isEnemySpawned()==false&&!this.level.getCurrentRoom().isShopRoom())
		{
			this.level.getCurrentRoom().spawnEnemies(this.level.getCurrentRoom().isBossRoom());
			this.level.getCurrentRoom().setEnemySpawned(true);
		}
		playingScene = new PlayingScene(this.level.getCurrentRoom());
		setSceneControls(playingScene.getScene());
		if(window.isFullScreen())
		{
			GameRunner.setScene(playingScene.getScene());
			window.setFullScreenExitHint("");
			window.setFullScreen(true);
		}
		else
		{
			GameRunner.setScene(playingScene.getScene());
		}
		TimerManager.resumeAll();
	}
	
	public void changeLevel(Level level)
	{
		TimerManager.pauseAll();
		resetKeys();
		this.level = level;
		this.level.getCurrentRoom().addCharacter(player);
		//Player.setCurrentLevel(Player.getCurrentLevel() + 1);
		level.getCurrentRoom().getPlayer().setLocalLevel(level.getCurrentRoom().getPlayer().getLocalLevel() + 1);
		playingScene = new PlayingScene(this.level.getCurrentRoom());
		setSceneControls(playingScene.getScene());
		if(window.isFullScreen())
		{
			GameRunner.setScene(playingScene.getScene());
			window.setFullScreenExitHint("");
			window.setFullScreen(true);
		}
		else
		{
			GameRunner.setScene(playingScene.getScene());
		}
		TimerManager.resumeAll();
	}
	
	public void resetKeys()
	{
		up=false;
		down=false;
		left=false;
		right=false;
		shift=false;
		mouseDownLeft=false;
		mouseDownRight=false;
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
		if(mouseDownLeft)
				player.useCurrentItem(Item.WEAPON);
		if(mouseDownRight)
		{
			if(player.getCurrentItem() instanceof Potion || player.getCurrentItem() instanceof Ammo)
			{
				player.useCurrentItem(Item.POTION);
				player.removeCurrentItem();
			}
		}
		manageCharacterDeath();
		runAllCharacterEffects(((double)milliSecond) / 1000);
		playerPickUpItem();
		teleportChecker(((double)milliSecond) / 1000);
		instantCollectableAttract(((double)milliSecond) / 1000);
		updateShield(((double)milliSecond) / 1000);
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
		if(mouseDownLeft)
			//addProjectile(ProjectileDesign.getBulletDesignOne(Projectile.SHOT_BY_PLAYER, player.getXLocation(), player.getYLocation(), player.getFaceAngle(), 10));
			player.useCurrentItem(Item.WEAPON);
		if(mouseDownRight)
		{
			if(player.getCurrentItem() instanceof Potion || player.getCurrentItem() instanceof Ammo)
			{
				player.useCurrentItem(Item.POTION);
				player.removeCurrentItem();
			}
		}
		now = System.nanoTime();
		System.out.println("Time Passed After useing player item: " + (now - pasttime));
		pasttime = now;
		
		manageCharacterDeath();
		now = System.nanoTime();
		System.out.println("Time Passed After managing character death: " + (now - pasttime));
		pasttime = now;
		
		runAllCharacterEffects(((double)milliSecond) / 1000);
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
	
	public void updateShield(double sec)
	{
		if(player.getInventory().getShield() != null)
			player.getInventory().getShield().runShield(sec);
	}
	
	public void updateCameraLocation()
	{
		Player player = level.getCurrentRoom().getPlayer();
		Camera.shiftCamera(player.getXLocation() + player.getWidth() / 2, player.getYLocation() + player.getHeight() / 2, GameRunner.getWindowWidth(), GameRunner.getWindowHeight());
	}
	
	public void runAllCharacterEffects(double sec)
	{
		for(Character c: level.getCurrentRoom().getCharacters())
			c.getEffectManager().runAllEffect(sec);
	}
	
	public void manageCharacterDeath()
	{
		List<Character> characters = level.getCurrentRoom().getCharacters();
		for(int i = characters.size() - 1; i >= 0; i--)
			if(characters.get(i).getCurrentHealth() <= 0)
			{
				if(characters.get(i) instanceof Player)
				{
					//If the Player get killed.
					TimerManager.pauseAll();
					try 
					{
						runPlayerDeathCode();
					} 
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
				else
				{
					//If a enemy Is Killed
/////					playingScene.removeChildFromMoveArea(characters.get(i).getSpriteImageView());
/////					playingScene.removeChildFromMoveArea(((Enemy)characters.get(i)).getWeapon().getSpriteImageView());
/////					playingScene.removeChildFromMoveArea(((Enemy)characters.get(i)).getHealthbar().getCanvas());
					Item droppedItem=((Enemy)characters.get(i)).dropItem(level.getLevelNum());
					if(droppedItem!=null&&((Enemy)characters.get(i)).isCanDropItem())
					{
						if(characters.get(i) instanceof Boss)
							level.getCurrentRoom().scatterItems(CoinDesign.getCoinStack(30), characters.get(i).getXCenter(), characters.get(i).getYCenter());
						else
							level.getCurrentRoom().addItem(droppedItem);
					}
					if(characters.get(i) instanceof Boss)
					{
						Room currentRoom=level.getCurrentRoom();
						Tile[][] allTiles=currentRoom.getTiles();
						for(int q=0;q<allTiles.length;q++)
						{
							for(int r=0;r<allTiles[0].length;r++)
							{			
								currentRoom.setTileAt(r, q, TileDesign.getStoneTileDesignOne(q*100, r*100, 100, 100, 0));
							}
						}				
						level.getCurrentRoom().setTileAt((int)((currentRoom.getRoomPixHeight()/2)/100), (int)((currentRoom.getRoomPixWidth()/2)/100), TeleporterDesign.getLevelTeleporter((currentRoom.getRoomPixHeight()/2)-50, (currentRoom.getRoomPixWidth()/2)-50,0));
					}
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
		{	
			level.getCurrentRoom().setAllEnemyDead(true);
			List<Teleporter> roomPorters = level.getCurrentRoom().getRoomTeleporterManager().getRoomPorters();
			level.getCurrentRoom().getRoomTeleporterManager().activateAllTeleporters();
//			for(Teleporter tele : roomPorters)
//				if(tele.isBossTele())
//					if(level.allDead())
//						level.getCurrentRoom().getRoomTeleporterManager().activateTeleporter(tele);
//					else
//						level.getCurrentRoom().getRoomTeleporterManager().deactivateTeleporter(tele);
		}
	}
	
	private void runPlayerDeathCode() throws Exception
	{
		GameRunner.destroyGameManager();
		GameRunner.getSceneTracker().useMenuScene();
		GameRunner.getSceneTracker().switchToGameOverView();
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
			if(grabbedTile != null && character instanceof Player)
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
	
	public void removeAllProjectiles()
	{
		List<Projectile> projectiles = level.getCurrentRoom().getProjectiles();
		for(int i = projectiles.size() - 1; i >= 0; i--)
		{
			Projectile currentProjectile = projectiles.get(i);
			removeProjectile(currentProjectile);
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
	
	public void instantCollectableAttract(double sec)
	{
		double playerx = player.getXCenter();
		double playery = player.getYCenter();
		for(Item item : level.getCurrentRoom().getItems())
		{
			if(item instanceof InstantCollect)
			{
				double distance = MyMath.distanceBetween(playerx, playery, item.getXCenter(), item.getYCenter());
				if(distance > 150)
					continue;
				double speed = 50;
				if(distance < 110)
					speed = 140;
				if(distance < 70)
					speed = 300;
				double deltax = 0;
				double deltay = 0;
				if(playerx < item.getXCenter() && level.getCurrentRoom().canSpriteMove(item, Constants.MOVE_DIR_LEFT, (speed * sec)))
					deltax = -(speed * sec);
				else if(level.getCurrentRoom().canSpriteMove(item, Constants.MOVE_DIR_RIGHT, (speed * sec)))
					deltax = speed * sec;
				if(playery < item.getYCenter() && level.getCurrentRoom().canSpriteMove(item, Constants.MOVE_DIR_UP, (speed * sec)))
					deltay = -(speed * sec);
				else if(level.getCurrentRoom().canSpriteMove(item, Constants.MOVE_DIR_DOWN, (speed * sec)))
					deltay = speed * sec;
				if(deltax != 0 && deltay != 0)
				{
					deltax *= 1 / Math.sqrt(2);
					deltay *= 1 / Math.sqrt(2);
				}
				item.addXLocation(deltax);
				item.addYLocation(deltay);
			}
		}
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

	public void teleportChecker(double sec)
	{
		Tile[][] teleChecker=level.getCurrentRoom().getTiles();
		for(Character c: level.getCurrentRoom().getCharacters())
			if(c instanceof Enemy)
			{
				level.getCurrentRoom().setAllEnemyDead(false);
				break;
			}
			else
			{
				level.getCurrentRoom().setAllEnemyDead(true);
				//level.getCurrentRoom().getRoomTeleporterManager().activateAllTeleporters();
			}
				
		for(int i=0; i<teleChecker.length;i++)
		{
			for(int s=0;s<teleChecker[0].length;s++)
			{
				if(teleChecker[i][s] instanceof Teleporter)
				{	
					if(teleChecker[i][s].getBoundsOfObject().contains(player.getBoundsOfObject()))
					{
						//System.out.println(((Teleporter)teleChecker[i][s]).isWasUsed());
						//System.out.println("ON"+((Teleporter)teleChecker[i][s]).isPlayerOn());
						List<Teleporter> allTele=this.getLevel().getCurrentRoom().getPortManager().getRoomPorters();
						for(Teleporter t:allTele)
						{	
							if(((Teleporter)teleChecker[i][s]).isWasUsed()==false&&((Teleporter)teleChecker[i][s]).isPlayerOn()==false)
							{
									if(t.getXLocation()/100==s && t.getYLocation()/100==i)
									{
										Teleporter currentTele=t;
										if(!currentTele.equals(currentTeleporterTracker))
										{
											currentTeleporterTracker = currentTele;
											currentTele.resetTimer();
											currentTeleporterTracker.resetTimer();
										}
										if(currentTele.isActivated() && !currentTele.runTimer(sec))
										{
											return;
										}
										if(t instanceof LevelTele)
										{
											changeLevel(((LevelTele)t).nextLevel(level.getLevelNum()+1));
											break;
										}
										//System.out.println(currentTele.getConnectedTeleporter().getId());
										//System.out.println(currentTele.getId());
										int row=currentTele.getConnectedTeleporter().getConnectedRoom().getLevelRow();
										int col=currentTele.getConnectedTeleporter().getConnectedRoom().getLevelCol();
										//System.out.println(row);
										//System.out.println(col);
										if(level.getCurrentRoom().isAllEnemyDead())
										{
											//if(currentTele.)
											currentTele.getConnectedTeleporter().setWasUsed(true);
											currentTele.getConnectedTeleporter().setPlayerOn(true);
											t.setWasUsed(false);
											
											removeAllProjectiles();
											this.level.getCurrentRoom().removeCharacter(player);
											this.level.setCurrentRoom(row, col);
											this.level.getCurrentRoom().addCharacter(player);
											
											player.setXLocation(currentTele.getConnectedTeleporter().getXLocation() + 10);
											player.setYLocation(currentTele.getConnectedTeleporter().getYLocation() + 10);
											changeRoom();
											return;
											//break;
										}	
								}
							}
						}break;
					}
					else
					{
						((Teleporter)teleChecker[i][s]).setPlayerOn(false);
						((Teleporter)teleChecker[i][s]).setWasUsed(false);
					}
				}
			}
		}
		if(currentTeleporterTracker != null)
			currentTeleporterTracker.resetTimer();
	}
	
    public void moveEnemy(double sec)
    {
    	
	    	List<Character> enemies=level.getCurrentRoom().getCharacters();
	    	//boolean spawnEnemy=false;
	    	double circleRadius=0;
	    	for(int i=0; i<enemies.size();i++)
	    		if(enemies.get(i) instanceof Enemy)
	    		{
	    			if(!((Enemy)enemies.get(i)).getSpriteName().equals("ROBOTBOSS")&&!((Enemy)enemies.get(i)).getSpriteName().equals("WIZARDBOSS"))
	    			{
		    				if(!((Enemy)enemies.get(i)).getSpriteName().equals("Base Brian"))
		    				{
		    					circleRadius=((Enemy)enemies.get(i)).getCircleRadius();
		    					if((shift)&&(left||right||up||down))
		    			    		circleRadius+=200;
			    				if(((Enemy)enemies.get(i)).getCircleBoundsOfObject(circleRadius).contains(player.getCircleBoundsOfObject()))
			    					((Enemy)enemies.get(i)).getBrain().action(sec);
			    				else
			    					((Enemy)enemies.get(i)).getBrain().wander(sec);
		    				}
		    				else
		    					((Enemy)enemies.get(i)).getBrain().action(sec);
	    			}
	    			else
	        			((Enemy)enemies.get(i)).getBrain().action(sec);
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
		mouseAngle = MyMath.findAngleBetween(player.getXCenter(), player.getYCenter(), mouseX, mouseY);
//		double distanceX = mouseX - (player.getXLocation() + player.getWidth()/2);
//		double distanceY = mouseY - (player.getYLocation() + player.getHeight()/2);
//		mouseAngle = Math.toDegrees(Math.atan(distanceY / distanceX));
//		if(distanceY <= 0 && distanceX < 0)
//			mouseAngle += 180;
//		else if(distanceY > 0 && distanceX < 0)
//			mouseAngle = 90 + (90 - Math.abs(mouseAngle));
//		else if(distanceX > 0 && distanceY < 0)
//			mouseAngle += 360;
	}
	
	public void playerPickUpItem()
	{
		Item item = level.getCurrentRoom().playerCollisionWithItem(player);
		if(item != null && ((item.isItemPickable() && !player.isInventoryFull()) || item instanceof InstantCollect))
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
			dropItemToRoom(item);
/////			playingScene.addChildToMoveArea(item.getSpriteImageView());
		}
	}
	
	public void playerDropSeceltedItem()
	{
		Item item = player.getInventory().removeSelectedItem();
		if(item != null)
		{
			dropItemToRoom(item);
		}
	}
	
	private void dropItemToRoom(Item item)
	{
		int count = 50;
		int decrement = 10;
		item.setXLocation(player.getXLocation());
		item.setYLocation(player.getYLocation());
		while(count > 0 && !level.getCurrentRoom().spriteCollisionWithObstacle(item))
		{
			item.setXLocation(item.getXLocation() + Math.cos(Math.toRadians(player.getFaceAngle())) * decrement);
			item.setYLocation(item.getYLocation() + Math.sin(Math.toRadians(player.getFaceAngle())) * decrement);
			count -= decrement;
		}
		level.getCurrentRoom().addItem(item);
	}
	
	public void toggleFullScreen()
	{
		if(window.isFullScreen())
			window.setFullScreen(false);
		else
			window.setFullScreen(true);
	}
	
	public void toggleDisInventory()
	{
		if(displayInventory)
		{
			displayInventory = false;
			//TimerManager.resumeAll();
		}
		else
		{
			displayInventory = true;
			//TimerManager.pauseAll();
		}
			
	}
	
	public boolean displayInventory()
	{
		return displayInventory;
	}
	
	public Item checkShopCollision()
	{
		List<Obstacle> allObs=level.getCurrentRoom().getObstacles();
		for(Obstacle o:allObs)
		{
			if(o instanceof Shop && o.getBoundsOfObject(o.getWidth(), o.getHeight()+50).intersect(player.getBoundsOfObject()))
			{
				return ((Shop)o).buyItem(player);
			}
		}
		return null;
	}
	
	public void playerBuyItem()
	{
		Item boughtItem=checkShopCollision();
		if(boughtItem!=null)
		{
			player.addItem(boughtItem);
		}
	}
	
	public void togglePause()
	{
		if(TimerManager.isPaused)
		{
			unPauseGame();
			playingScene.getInGameMenu().setVisible(false);
		}
		else
		{
			pauseGame();
			playingScene.getInGameMenu().setVisible(true);
		}
	}
	
	public double getMouseX()
	{
		return mouseX;
	}

	public double getMouseY() 
	{
		return mouseY;
	}

	public double getMouseXUnajusted() 
	{
		return mouseXUnajusted;
	}

	public double getMouseYUnajusted() 
	{
		return mouseYUnajusted;
	}
	
	/**
	 * Checking to see if the mouse clicked.
	 * Afterwards making isClick false.
	 * @return true if the mouse clicked false otherwise
	 */
	public boolean isClick()
	{
		if(isClick)
		{
			isClick = false;
			return true;
		}
		return false;
	}
	
	public Controls getControls()
	{
		return controls;
	}
	
	public void applyInputControlPressed(String input)
	{
		if(input.equals(controls.getUp().getCurrentControlStr()))
			up = true;
		else if(input.equals(controls.getDown().getCurrentControlStr()))
			down = true;
		else if(input.equals(controls.getRight().getCurrentControlStr()))
			right = true;
		else if(input.equals(controls.getLeft().getCurrentControlStr()))
			left = true;
		else if(input.equals(controls.getSprint().getCurrentControlStr()))
			shift = true;
		else if(input.equals(controls.getHotBar1().getCurrentControlStr()))
			player.setCurrentItemIdx(0);
		else if(input.equals(controls.getHotBar2().getCurrentControlStr()))
			player.setCurrentItemIdx(1);
		else if(input.equals(controls.getHotBar3().getCurrentControlStr()))
			player.setCurrentItemIdx(2);
		else if(input.equals(controls.getHotBar4().getCurrentControlStr()))
			player.setCurrentItemIdx(3);
		else if(input.equals(controls.getHotBar5().getCurrentControlStr()))
			player.setCurrentItemIdx(4);
		else if(input.equals(controls.getHotBar6().getCurrentControlStr()))
			player.setCurrentItemIdx(5);
		else if(input.equals(controls.getDropItem().getCurrentControlStr()))
			playerDropItem();
		else if(input.equals(controls.getInventory().getCurrentControlStr()))
			toggleDisInventory();
		else if(input.equals(controls.getBuyItem().getCurrentControlStr()))
			playerBuyItem();
		else if(input.equals(controls.getPause().getCurrentControlStr()))
			togglePause();
		else if(input.equals(controls.getFullScreen().getCurrentControlStr()))
		{
			window.setFullScreenExitHint("Press F11 to exit full-screen mode");
			toggleFullScreen();
		}	
	}
	
	public void applyInputControlReleased(String input)
	{
		if(input.equals(controls.getUp().getCurrentControlStr()))
			up = false;
		else if(input.equals(controls.getDown().getCurrentControlStr()))
			down = false;
		else if(input.equals(controls.getRight().getCurrentControlStr()))
			right = false;
		else if(input.equals(controls.getLeft().getCurrentControlStr()))
			left = false;
		else if(input.equals(controls.getSprint().getCurrentControlStr()))
			shift = false;
	}
	
	public void setSceneControls(Scene scene)
	{
		scene.setOnKeyPressed(event -> 
		{
			applyInputControlPressed(event.getCode().toString());
			
//			KeyCode code = event.getCode();
//			if(code.toString() == controls.getUp())
//				up = true;
//			if(code.toString() == controls.getLeft())
//				left = true;
//			if(code.toString() == controls.getDown())
//				down = true;
//			if(code.toString() == controls.getRight())
//				right = true;
//			if(code.toString() == controls.getSprint())
//				shift = true;
//			//if(code == KeyCode.E)
//				//playerPickUpItem();
//			if(code == KeyCode.DIGIT1)
//				player.setCurrentItemIdx(0);
//			if(code == KeyCode.DIGIT2)
//				player.setCurrentItemIdx(1);
//			if(code == KeyCode.DIGIT3)
//				player.setCurrentItemIdx(2);
//			if(code == KeyCode.DIGIT4)
//				player.setCurrentItemIdx(3);
//			if(code == KeyCode.DIGIT5)
//				player.setCurrentItemIdx(4);
//			if(code == KeyCode.DIGIT6)
//				player.setCurrentItemIdx(5);
//			if(code.toString() == controls.getDropItem())
//				playerDropItem();
//			if(code == KeyCode.I || code == KeyCode.ESCAPE||code.toString() == controls.getInventory())
//				toggleDisInventory();
//			if(code == KeyCode.F11)
//			{
//				window.setFullScreenExitHint("Press F11 to exit full-screen mode");
//				toggleFullScreen();
//			}
//			if(code.toString() == controls.getBuyItem())
//			{
//				Item boughtItem=checkShopCollision();
//				if(boughtItem!=null)
//				{
//					player.addItem(boughtItem);
//				}
//			}
//			if(code.toString() == controls.getPause())
//			{
//				if(TimerManager.isPaused)
//				{
//					unPauseGame();
//					playingScene.getInGameMenu().setVisible(false);
//				}
//				else
//				{
//					pauseGame();
//					playingScene.getInGameMenu().setVisible(true);
//				}
//			}
			
		});
		scene.setOnKeyReleased(event -> 
		{
			applyInputControlReleased(event.getCode().toString());
//			switch(event.getCode())
//			{
//				case W: up = false; break;
//				case A: left = false; break;
//				case S: down = false; break;
//				case D: right = false; break;
//				case SHIFT: shift = false; break;
//				default: break;
//			}
		});
		scene.addEventHandler(MouseEvent.ANY, event -> 
		{
			mouseXUnajusted = event.getX();
			mouseYUnajusted = event.getY();
		});
		scene.setOnMousePressed(event -> 
		{
			//System.out.println(player.getInventory().getSelectedItem());
			MouseButton button=event.getButton();
			if(player.getInventory().getSelectedItem() != null)
				playerDropSeceltedItem();
			else
			{
				if(button==MouseButton.PRIMARY)
					mouseDownLeft = true;
				if(button==MouseButton.SECONDARY)
					mouseDownRight = true;
				isClick = true;
			}
			//player.getInventory().returnSelectedItem();
			
		});
		scene.setOnMouseReleased(event -> {mouseDownLeft = false ; mouseDownRight = false;});
		scene.setOnScroll(event -> 
		{
			//System.out.println("Deata Y: " + event.getDeltaY());
			//System.out.println("Deata X: " + event.getDeltaX());
			double val;
			if(event.isShiftDown())
				val = event.getDeltaX();
			else
				val = event.getDeltaY();
			if(val < 0)
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
