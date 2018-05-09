package map;

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
import sprite.projectile.Projectile;
import sprite.Sprite;
import sprite.bounds.BoxCollider;
import sprite.character.Character;
import sprite.character.effect.NoEffect;
import sprite.character.player.Player;
import sprite.character.enemy.Enemy;

/**
 * The room is the backend information hub of the game. It stores 
 * almost all of the objects seen on the screen. It also contains mathods
 * for collision checks between those objects.
 */
public class Room
{
	public static final int DEFAULT_TILE_ROW = 10;
	public static final int DEFUALT_TILE_COLUMN = 10;
	//For now the roomPixWidth and Height does nothing.
	private double roomPixWidth;
	private double roomPixHeight;
	
	private int currentRow;
	private int currentCol;
	
	private boolean isExplored = false;
	
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
	
	public List<Item> getItems() {return items;}
	
	public RoomPortManager getRoomTeleporterManager() {return roomTeleporterManager;}
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
			characterBounds.setY(characterBounds.getY() - distance);
		}
		if(direction.equals(Constants.MOVE_DIR_DOWN))
		{
			characterBounds.setY(characterBounds.getY() + distance);
		}
		if(direction.equals(Constants.MOVE_DIR_LEFT))
		{
			characterBounds.setX(characterBounds.getX() - distance);
		}
		if(direction.equals(Constants.MOVE_DIR_RIGHT))
		{
			characterBounds.setX(characterBounds.getX() + distance);
		}
		for(Obstacle obs : obstacles)
		{
			if(obs.getBoundsOfObject().intersect(characterBounds))
				return false;
			if(character instanceof Player)
			{
				for(Character chara : characters)
				{
					if(chara instanceof Enemy && chara.getBoundsOfObject().intersect(characterBounds))
					{
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
			return true; 
		}
		//if projectileHitPlayer
		Player player = getPlayer();
		//if player collide with projectile and projectile isnt shot by player.
		if(player.getBoundsOfObject().intersect(projectile.getBoundsOfObject()) && !projectile.getBulletOwner().equals(Projectile.SHOT_BY_PLAYER))
		{
			//System.out.println("Collide With player");
			player.setCurrentHealth(player.getCurrentHealth() - projectile.getDamage());
			//projectiles.remove(projectile);
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
					//projectiles.remove(projectile);
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean spriteCollisionWithObstacle(Sprite sprite)
	{
		for(Obstacle obstacle: obstacles)
		{
			if(obstacle.getBoundsOfObject().intersect(sprite.getBoundsOfObject()))
				return true;
		}
		return false;
	}
	
	public Item characterCollisionWithItem(Character character)
	{
		for(Item item : items)
			if(item.getBoundsOfObject().intersect(character.getBoundsOfObject()))
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
}
