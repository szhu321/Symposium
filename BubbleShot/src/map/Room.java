package map;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import mainGame.backend.Constants;
import map.Tile.*;
import map.Tile.teleporter.RoomPortManager;
import map.Tile.teleporter.Teleporter;
import map.obstacle.Obstacle;
import map.obstacle.StoneWall;
import myutilities.MyMath;
import sprite.item.Item;
import sprite.projectile.BouncingProjectile;
import sprite.projectile.CollisionDetection;
import sprite.projectile.PenetrationBullet;
import sprite.projectile.Projectile;
import sprite.Sprite;
import sprite.bounds.BoxCollider;
import sprite.character.Character;
import sprite.character.effect.BlindEffect;
import sprite.character.effect.HealthEffect;
import sprite.character.effect.NoEffect;
import sprite.character.player.Player;
import sprite.character.enemy.Boss;
import sprite.character.enemy.Enemy;
import sprite.character.enemy.EnemyDesign;

/**
 * The room is the backend information hub of the game. It stores 
 * almost all of the objects seen on the screen. It also contains mathods
 * for collision checks between those objects.
 */
public class Room implements Serializable
{
	private static final long serialVersionUID = -6377950154664530429L;
	
	public static final int DEFAULT_TILE_ROW = 10;
	public static final int DEFUALT_TILE_COLUMN = 10;
	//For now the roomPixWidth and Height does nothing.
	private double roomPixWidth;
	private double roomPixHeight;
	
	private int currentRow;
	private int currentCol;
	
	private boolean isExplored = false;
	private boolean allEnemyDead=false;
	private boolean enemySpawned=false;
	private boolean isBossRoom=false;
	private boolean isShopRoom=false;

	private String name = "unnamed";
	
	/**
	 * Tiles that the rooms floor consists of.
	 */
	private Tile[][] tiles;
	
	/**
	 * Obstacles are barriers that characters and projectiles can't cross.
	 */
	private List<Obstacle> obstacles = new ArrayList<Obstacle>();
	
	/**
	 * List of characters in this room.
	 */
	private List<Character> characters = new ArrayList<Character>();
	
	/**
	 * List of items in this room.
	 */
	private List<Item> items = new ArrayList<Item>();
	
	/**
	 * The projectiles currently active in this room.
	 */
	private List<Projectile> projectiles = new ArrayList<Projectile>();
	
	
	
	private RoomPortManager roomTeleporterManager = new RoomPortManager();
	
	/**
	 * Creates a clear Room with specified tile number.
	 * @param column - number of columns of tiles.
	 * @param row - number of rows of tiles.
	 */
	public Room(int row, int column)
	{
		roomPixWidth = column * 100;
		roomPixHeight = row * 100;
		
		tiles = new Tile[row][column];
		for(int i = 0; i < tiles.length; i++)
			for(int j = 0; j < tiles[0].length; j++)
				tiles[i][j] = TileDesign.getStoneTileDesignOne(j * 100, i * 100, 100, 100, 0);
		//for(int i = 0; i < tiles.length; i++)
		//	for(int j = tiles[0].length / 2; j < tiles[0].length; j++)
		//		tiles[i][j] = TileDesign.getMudTileDesignOne(j * 100, i * 100, 100, 100, 0);
		addBorderToRoom();
	}
	
	/**
	 * Creates a clear Room with 10 rows and 10 columns.
	 */
	public Room()
	{
		this(DEFAULT_TILE_ROW, DEFUALT_TILE_COLUMN);
	}
	
	/**
	 * Creates a room with the specified tiles
	 * @param tiles The tile configuration that the room will consists of.
	 */
	public Room(Tile[][] tiles)
	{
		this.tiles = tiles;
		roomPixWidth = tiles[0].length * 100;
		roomPixHeight = tiles.length * 100;
		addBorderToRoom();
	}
	
	public void setTileAt(int row, int col, Teleporter tile)
	{
		if(!(tiles[row][col] instanceof Teleporter) && tile instanceof Teleporter)
		{
			tiles[row][col] = tile;
			roomTeleporterManager.getRoomPorters().add(tile);
		}
		else
		{
			tiles[row][col] = tile;
		}
	}
	
	public void setTileAt(int row, int col, Tile tile)
	{
		if(!(tiles[row][col] instanceof Teleporter))
		{
			tiles[row][col] = tile;
		}
	}
	
	public void addBorderToRoom()
	{
		//Top
		addObstacle(new StoneWall(roomPixWidth, 100, 0, 0, 0));
		//Bottom
		addObstacle(new StoneWall(roomPixWidth, 100, 0, roomPixHeight - 100, 0));
		//left
		addObstacle(new StoneWall(100, roomPixHeight - 200, 0 , 100, 0));
		//right
		addObstacle(new StoneWall(100, roomPixHeight - 200, roomPixWidth - 100, 100, 0));
	}
	
	//Getters and Setters
	public void setLevelRow(int row) {currentRow=row;}
	public void setLevelCol(int col) {currentCol=col;}
	public int getLevelRow() {return currentRow;}
	public int getLevelCol() {return currentCol;}
	public double getRoomPixHeight() {return roomPixHeight;}
	public double getRoomPixWidth() {return roomPixWidth;}
	public Tile[][] getTiles() {return tiles;}
	public List<Obstacle> getObstacles() {return obstacles;}
	public void setObstacles(List<Obstacle> obstacles) {this.obstacles = obstacles;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public List<Character> getCharacters() {return characters;}
	public RoomPortManager getPortManager() {return roomTeleporterManager;}
	public boolean isEnemySpawned() {return enemySpawned;}
	public void setEnemySpawned(boolean enemySpawned) {	this.enemySpawned = enemySpawned;}
	
	public List<Item> getItems() {return items;}
	
	public RoomPortManager getRoomTeleporterManager() {return roomTeleporterManager;}
	public boolean isShopRoom() {
		return isShopRoom;
	}

	public void setShopRoom(boolean isShopRoom) {
		this.isShopRoom = isShopRoom;
	}

	public void setTeleporterManager(RoomPortManager teleporterManager) {this.roomTeleporterManager = teleporterManager;}
	
	/**
	 * 
	 * @return has this room been explored yet. In other words has the player
	 * step into this room yet.
	 */
	public boolean isExplored()
	{
		return isExplored;
	}
	
	/**
	 * Passes in a list of characters the room will start with.
	 * This is usually used in RoomDesign.java when creating new room
	 * designs.
	 * @param characters Characters setted.
	 */
	public void setCharacters(List<Character> characters) 
	{
		this.characters = characters;
		for(Character character: this.characters)
			character.setCurrentRoom(this);
	}
	
	/**
	 * Passes in a list of items the room will start with.
	 * This is usually called in RoomDesign.java.
	 * @param items Items setted.
	 */
	public void setItems(List<Item> items) 
	{
		this.items = items;
		for(Item item: this.items)
			item.setCurrentRoom(this);
	}
	
	/**
	 * When ever a gun fires a new projectile will be added to the room
	 * 
	 * @param projectile The projectile that will be added to the room.
	 */
	public void addProjectile(Projectile projectile)
	{
		projectile.setCurrentRoom(this);
		projectiles.add(0,projectile);
		//System.out.println("added");
	}
	
	public void scatterItems(Item[] items, double x, double y)
	{
		List<Item> itemList = new ArrayList<Item>();
		for(int i = 0; i < items.length; i++)
			if(items[i] != null)
				itemList.add(items[i]);
		this.scatterItems(itemList, x, y);
	}
	
	public void scatterItems(List<Item> items, double x, double y)
	{
		for(int i = 0; i < items.size(); i++)
		{
			Item item = items.get(i);
			if(item == null)
				continue;
			item.setXLocation(x);
			item.setYLocation(y);
			int angle = MyMath.getRandomInteger(0, 359);
			int distance = MyMath.getRandomInteger(5, 50);
			int decrement = 10;
			while(distance > 0 && !spriteCollisionWithObstacle(item))
			{
				item.setXLocation(item.getXLocation() + Math.cos(Math.toRadians(angle)) * decrement);
				item.setYLocation(item.getYLocation() + Math.sin(Math.toRadians(angle)) * decrement);
				distance -= decrement;
			}
			addItem(item);
		}
	}
	
	public void movePlayerWithObsChecker(Character character, double addX, double addY)
	{
		double angle = Math.toDegrees(Math.atan(addX / addY));
		if(addY <= 0 && addX < 0)
			angle += 180;
		else if(addY > 0 && addX < 0)
			angle = 90 + (90 - Math.abs(angle));
		else if(addX > 0 && addY < 0)
			angle += 360;
		
		//System.out.println(angle);
		double distance = Math.sqrt(Math.pow(addX, 2) + Math.pow(addY, 2));
		double decrement = 5;
		while(distance > 0 && !spriteCollisionWithObstacle(character))
		{
			character.setXLocation(character.getXLocation() + Math.cos(Math.toRadians(angle)) * decrement);
			character.setYLocation(character.getYLocation() + Math.sin(Math.toRadians(angle)) * decrement);
			distance -= decrement;
		}
		character.setXLocation(character.getXLocation() - Math.cos(Math.toRadians(angle)) * decrement);
		character.setYLocation(character.getYLocation() - Math.sin(Math.toRadians(angle)) * decrement);
	}
	
	public List<Projectile> getProjectiles() {return projectiles;}
	
	public void removeProjectile(Projectile projectile)
	{
		//long pasttime = System.nanoTime();
		projectile.setCurrentRoom(null);
		projectiles.remove(projectile);
		//long now = System.nanoTime();
		//System.out.println("TimePassed removing from room: " + (now - pasttime));
		//System.out.println("removed");
	}
	
	public Tile getTileAt(double x, double y)
	{
		return tiles[(int) (y / 100)][(int) (x / 100)];
	}
	
	public void addObstacle(Obstacle obs)
	{
		obs.setXLocation(MyMath.round(obs.getXLocation(), 2));
		obs.setYLocation(MyMath.round(obs.getYLocation(), 2));
		obs.setWidth(MyMath.round(obs.getWidth(), 2));
		obs.setHeight(MyMath.round(obs.getHeight(), 2));
		obstacles.add(obs);
	}
	
	public void addCharacter(Character character)
	{
		if(character == null)
			return;
		characters.add(character);
		character.setCurrentRoom(this);
		//if(character instanceof Player)
			//isExplored = true;
	}
	
	public void setIsExplored(boolean t)
	{
		isExplored = t;
	}
	
	public void removeCharacter(Character character)
	{
		characters.remove(character);
		character.setCurrentRoom(null);
	}
	
	public void removeObstacle(Obstacle obs)
	{
		if(obstacles.contains(obs))
			obstacles.remove(obs);
	}
	public void removeObstacle(int idx)
	{
		if(idx >= 0 && idx < obstacles.size())
			obstacles.remove(idx);
	}
	
	public void addItem(Item item) 
	{
		items.add(item);
		item.setCurrentRoom(this);
	}
	
	public void removeItem(Item item)
	{
		item.setCurrentRoom(null);
		items.remove(item);
	}
	
	public Player getPlayer()
	{
		Player player = null;
		for(Character character : characters)
			if(character instanceof Player)
				player = (Player) character;
		return player;
	}
	
	public boolean canCharacterMove(Character character, String direction, double distance)
	{
		BoxCollider characterBounds = character.getBoundsOfObject();
		if(direction.equals(Constants.MOVE_DIR_UP))
		{
			characterBounds.setY(characterBounds.getY() - (distance * 1.2));
		}
		if(direction.equals(Constants.MOVE_DIR_DOWN))
		{
			characterBounds.setY(characterBounds.getY() + (distance * 1.2));
		}
		if(direction.equals(Constants.MOVE_DIR_LEFT))
		{
			characterBounds.setX(characterBounds.getX() - (distance * 1.2));
		}
		if(direction.equals(Constants.MOVE_DIR_RIGHT))
		{
			characterBounds.setX(characterBounds.getX() + (distance * 1.2));
		}
		for(Obstacle obs : obstacles)
		{
			if(character instanceof Player)
			{
				for(Character chara : characters)
				{
					if(chara instanceof Enemy && chara.getBoundsOfObject().intersect(characterBounds))
					{
						return false;
					}
					
				}
				if(obs.getBoundsOfObject().contains(characterBounds))
				{
					double distanceX = character.getXCenter() - getRoomPixWidth()/2;
					double distanceY = character.getYCenter() - getRoomPixHeight()/2;
					double angle = Math.toDegrees(Math.atan(distanceY / distanceX));
					if(distanceY <= 0 && distanceX < 0)
						angle += 180;
					else if(distanceY > 0 && distanceX < 0)
						angle = 90 + (90 - Math.abs(angle));
					else if(distanceX > 0 && distanceY < 0)
						angle += 360;
					System.out.println(angle);
					if(angle>=0&&angle<=90)
					{
						character.addXLocation(100);
						character.addYLocation(100);
					}
					else if(angle>=90&&angle<=180)
					{
						character.addXLocation(-100);
						character.addYLocation(100);
					}
					else if(angle>=180&&angle<=270)
					{
						character.addXLocation(-100);
						character.addYLocation(-100);							
					}
					else if(angle>=270&&angle<=360)
					{
						character.addXLocation(100);
						character.addYLocation(-100);
					}
					return false;			
				}
			}
			if(!(character.getSpriteName().equals("Ghost Brian")))
			{
				if(obs.getBoundsOfObject().intersect(characterBounds))
					return false;
			}
			if(character instanceof Boss)
			{
				for(Character chara : characters)
				{
					if(chara instanceof Player && chara.getBoundsOfObject().intersect(characterBounds))
					{
						double distanceX = chara.getXCenter() - character.getXCenter();
						double distanceY = chara.getYCenter() - character.getYCenter();
						double angle = Math.toDegrees(Math.atan(distanceY / distanceX));
						if(distanceY <= 0 && distanceX < 0)
							angle += 180;
						else if(distanceY > 0 && distanceX < 0)
							angle = 90 + (90 - Math.abs(angle));
						else if(distanceX > 0 && distanceY < 0)
							angle += 360;
						//System.out.println(angle);
						if(angle>=0&&angle<=90)
						{
							movePlayerWithObsChecker(chara, 50, 50);
							//chara.addXLocation(50);
							//chara.addYLocation(50);
						}
						else if(angle>=90&&angle<=180)
						{
							movePlayerWithObsChecker(chara, -50, 50);
							//chara.addXLocation(-50);
							//chara.addYLocation(50);
						}
						else if(angle>=180&&angle<=270)
						{
							movePlayerWithObsChecker(chara, -50, -50);
							//chara.addXLocation(-50);
							//chara.addYLocation(-50);							
						}
						else if(angle>=270&&angle<=360)
						{
							movePlayerWithObsChecker(chara, 50, -50);
							//chara.addXLocation(50);
							//chara.addYLocation(-50);
						}
						
						((Player)chara).setCurrentHealth(((Player)chara).getCurrentHealth()-1);
						return false;
					}
				}
			}
			if(character instanceof Enemy)
			{
				for(Character chara : characters)
				{
					if(chara instanceof Player && chara.getBoundsOfObject().intersect(characterBounds))
					{
						
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public boolean projectileCollide(Projectile projectile)
	{
		if(spriteCollisionWithObstacle(projectile))
		{
			//System.out.println("Collide With Obstacle");
			if(projectile instanceof BouncingProjectile)
			{
				if(((BouncingProjectile) projectile).isDown())
					return true;
				((BouncingProjectile) projectile).getTravelPath().addDistanceTraveled(((BouncingProjectile) projectile).getTravelPath().getDistanceTraveled());
				return false;
			}
			return true; 
		}
		//if projectileHitPlayer
		Player player = getPlayer();
		//if player collide with projectile and projectile isnt shot by player.
		if(/*CollisionDetection.collides(projectile, player)*/player.getBoundsOfObject().intersect(projectile.getBoundsOfObject()) && !projectile.getBulletOwner().equals(Projectile.SHOT_BY_PLAYER))
		{
			//System.out.println("Collide With player");
			player.setCurrentHealth(player.getCurrentHealth() - projectile.getDamage());
			if(projectile.getSpriteName().equals("Fire Ball"))
				player.getEffectManager().addEffect(HealthEffect.LAVA_TILE_EFFECT);
			if(projectile.getSpriteName().equals("Dark Ball"))
				player.getEffectManager().addEffect(BlindEffect.BLINDNESS_EFFECT);
			projectiles.remove(projectile);
		
			return true;
		}
		//if enemy collide with player projectile
		if(projectile.getBulletOwner().equals(Projectile.SHOT_BY_PLAYER))
		{
			for(Character character : characters)
			{
				if(character instanceof Enemy && projectile.getBoundsOfObject().intersect(character.getBoundsOfObject()))
				{
					//System.out.println("Collide With enemy");
					character.setCurrentHealth(character.getCurrentHealth() - projectile.getDamage());
					((Enemy)character).addCircleRadius(50);
					if(projectile instanceof PenetrationBullet && !((PenetrationBullet)projectile).isDown(character))
						return false;
					//projectiles.remove(projectile);
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean canSpriteMove(Sprite sprite, String direction, double distance)
	{
		BoxCollider characterBounds = sprite.getBoundsOfObject();
		if(direction.equals(Constants.MOVE_DIR_UP))
		{
			characterBounds.setY(characterBounds.getY() - (distance * 1.2));
		}
		if(direction.equals(Constants.MOVE_DIR_DOWN))
		{
			characterBounds.setY(characterBounds.getY() + (distance * 1.2));
		}
		if(direction.equals(Constants.MOVE_DIR_LEFT))
		{
			characterBounds.setX(characterBounds.getX() - (distance * 1.2));
		}
		if(direction.equals(Constants.MOVE_DIR_RIGHT))
		{
			characterBounds.setX(characterBounds.getX() + (distance * 1.2));
		}
		for(Obstacle obs : obstacles)
		{
			if(obs.getBoundsOfObject().intersect(characterBounds))
				return false;
		}
		return true;
	}
	
	public boolean spriteCollisionWithObstacle(Sprite sprite)
	{
		for(Obstacle obstacle: obstacles)
		{
			if(obstacle.getBoundsOfObject().intersect(sprite.getBoundsOfObject()))
			{
				if(sprite instanceof BouncingProjectile)
					checkEdgeBounceProjectileCollision(obstacle, (BouncingProjectile)sprite);
				return true;
			}
		}
		return false;
	}
	
	private void checkEdgeBounceProjectileCollision(Obstacle obs, BouncingProjectile bp)
	{
		if(bp.getBoundsOfObject().intersect(new BoxCollider(obs.getXLocation(), obs.getYLocation(), 1, obs.getHeight(), 0)))
		{
			bp.setHitSide(BouncingProjectile.HIT_LEFT_EDGE);
		}
		if(bp.getBoundsOfObject().intersect(new BoxCollider(obs.getXLocation() + 1, obs.getYLocation(), obs.getWidth() - 1, 1, 0)))
		{
			bp.setHitSide(BouncingProjectile.HIT_TOP_EDGE);
		}
		if(bp.getBoundsOfObject().intersect(new BoxCollider(obs.getXLocation() + obs.getWidth(), obs.getYLocation(), 1, obs.getHeight(), 0)))
		{
			bp.setHitSide(BouncingProjectile.HIT_RIGHT_EDGE);
		}
		if(bp.getBoundsOfObject().intersect(new BoxCollider(obs.getXLocation() + 1, obs.getYLocation() + obs.getHeight(), obs.getWidth() - 1, 1, 0)))
		{
			bp.setHitSide(BouncingProjectile.HIT_BOTTOM_EDGE);
		}
		//System.out.println(bp.getHitSide());
	}
	
	public Item characterCollisionWithItem(Character character)
	{
		for(Item item : items)
			if(item.getBoundsOfObject().intersect(character.getBoundsOfObject()))
				return item;
		return null;
	}
	
	public Item playerCollisionWithItem(Player player)
	{
		for(Item item : items)
			if(item.getCircleBoundsOfObject().intersect(player.getCircleBoundsOfObject()))
				return item;
		return null;
	}
	
	public Tile characterCollisionWithTile(Character character)
	{
		/*for(Tile[] tileArr: tiles)
		{
			for(Tile tile: tileArr)
			{
				//System.out.println(character.getBoundsOfObject());
				//System.out.println(tile.getBoundsOfObject());
				if(character.getBoundsOfObject().intersect(tile.getBoundsOfObject()) && !(tile.getEffects() instanceof NoEffect))
					return tile;
			}
		}
		return null;
		*/
		return getTileAt(character.getXCenter(), character.getYCenter());
	}
	/**
	 * Spawn enemies in a room
	 * @param BossRoom checks if the room is a boss room
	 */
	public void spawnEnemies(Boolean BossRoom)
	{
		if(!BossRoom)
		{
			//All tiles in the current room
			int[][] spawnTile=new int[tiles.length][tiles[0].length];
			//Random amount of enemies 
			int amountEnemies= MyMath.getRandomInteger((Player.getCurrentLevel() - 1)*1 + 1, (Player.getCurrentLevel() - 1)*1 + 2);
			if(amountEnemies > 20)
				amountEnemies = 20;
			//System.out.println("AMOUNT ENEMIES: "+amountEnemies);
			
			//Get Current X and Y tile of player
			int playerTileX=(int) ((this.characterCollisionWithTile(this.getPlayer()).getXLocation())/100);
			int playerTileY=(int) ((this.characterCollisionWithTile(this.getPlayer()).getYLocation())/100);
			
			//System.out.println(amountEnemies);
			
			//Makes a random enemy
			int randomType=0;
			String enemyType="";
			int randomX=0;
			int randomY=0;
			
			//Makes a map of which tile is enemies able to spawn on
			for(int i=0;i<tiles.length;i++)
			{
				for(int s=0;s<tiles[0].length;s++)
				{			
					spawnTile[i][s]=1;
					for(int q=0;q<obstacles.size();q++)
					{
						if(tiles[i][s].getBoundsOfObject().intersect(obstacles.get(q).getBoundsOfObject()))
						{	
							spawnTile[i][s]=0;				
						}			
					}			
				}
			}	
			//Enemies are not allowed to spawn near the player
			spawnTile[playerTileY][playerTileX]=2;			
			spawnTile[playerTileY-1][playerTileX-1]=0;
			spawnTile[playerTileY-1][playerTileX]=0;
			spawnTile[playerTileY-1][playerTileX+1]=0;
			spawnTile[playerTileY][playerTileX-1]=0;
			spawnTile[playerTileY][playerTileX+1]=0;
			spawnTile[playerTileY+1][playerTileX-1]=0;
			spawnTile[playerTileY+1][playerTileX]=0;
			spawnTile[playerTileY+1][playerTileX+1]=0;
			
			//Place the enemies
			while(amountEnemies > 0)
			{
				//If the location is unavailable find a new location
				if(spawnTile[randomY][randomX]==0||spawnTile[randomY][randomX]==2)
				{
					randomX=(int)(Math.random()*spawnTile[0].length);
					randomY=(int)(Math.random()*spawnTile.length);
				}
				else
				{
					randomType=(int)(Math.random()*7)+1;
					this.addCharacter(EnemyDesign.getRandomDesign(tiles[randomY][randomX].getXCenter(),tiles[randomY][randomX].getYCenter(),this.getPlayer(),randomType, Player.getCurrentLevel()));
					//spawnTile[randomY][randomX]=0;
					randomX=(int)(Math.random()*spawnTile[0].length);
					randomY=(int)(Math.random()*spawnTile.length);
					amountEnemies--;
				}
		//	System.out.println("AMOUNT ENEMIES: "+amountEnemies);
			}
		}
		else
		{
			//Place boss in boss room
			int randBoss=MyMath.getRandomInteger(1, 3);
			if(randBoss==1)
				this.addCharacter(EnemyDesign.getBossDesignOne(this.roomPixHeight/2,this.roomPixWidth/2,this.getPlayer(),Player.getCurrentLevel()));
			if(randBoss==2)
				this.addCharacter(EnemyDesign.getBossDesignTwo(this.roomPixHeight/2,this.roomPixWidth/2,this.getPlayer(),Player.getCurrentLevel()));
			if(randBoss==3)
				this.addCharacter(EnemyDesign.getBossDesignThree(this.roomPixHeight/2-50,this.roomPixWidth/2-50,this.getPlayer(),Player.getCurrentLevel()));
			//System.out.println(Player.getCurrentLevel());
		}
		
		/*debugger
		for(int i=0;i<spawnTile.length;i++)
		{
			String name="";
			for(int s=0;s<spawnTile[0].length;s++)
			{
				name+=" "+spawnTile[i][s];
			}
			System.out.println(name);
		}
		System.out.println();
		*/
	}

	public boolean isBossRoom() {
		return isBossRoom;
	}
	public void setBossRoom(boolean isBossRoom) {
		this.isBossRoom = isBossRoom;
	}

	public boolean isAllEnemyDead() {
		return allEnemyDead;
	}

	public void setAllEnemyDead(boolean allEnemyDead) {
		this.allEnemyDead = allEnemyDead;
	}
}
