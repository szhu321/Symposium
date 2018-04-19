package map;

import java.util.ArrayList;
import java.util.List;

import mainGame.backend.Constants;
import map.Tile.*;
import map.Tile.teleporter.RoomPortManager;
import map.obstacle.Obstacle;
import sprite.item.Item;
import sprite.projectile.Projectile;
import sprite.Sprite;
import sprite.bounds.BoxCollider;
import sprite.character.Character;
import sprite.character.effect.NoEffect;
import sprite.character.player.Player;
import sprite.character.enemy.Enemy;

/**
 * A room of the
 * @author Sheng
 *
 */
public class Room
{
	public static final int DEFAULT_TILE_ROW = 10;
	public static final int DEFUALT_TILE_COLUMN = 10;
	//For now the roomPixWidth and Height does nothing.
	private double roomPixWidth;
	private double roomPixHeight;
	
	private String name = "unnamed";
	
	private Tile[][] tiles;
	private List<Obstacle> obstacles = new ArrayList<Obstacle>();
	private List<Character> characters = new ArrayList<Character>();
	private List<Item> items = new ArrayList<Item>();
	private List<Projectile> projectiles = new ArrayList<Projectile>();
	
	private RoomPortManager teleporterManager;
	
	/**
	 * Creates a clear Room with specified tile number.
	 * @param column - number of columns of tiles.
	 * @param row - number of rows of tiles.
	 */
	public Room(int row, int column)
	{
		obstacles = new ArrayList<Obstacle>();
		roomPixWidth = column * 100;
		roomPixHeight = row * 100;
		
		tiles = new Tile[row][column];
		for(int i = 0; i < tiles.length; i++)
			for(int j = 0; j < tiles[0].length / 2; j++)
				tiles[i][j] = TileDesign.getStoneTileDesignOne(j * 100, i * 100, 100, 100, 0);
		for(int i = 0; i < tiles.length; i++)
			for(int j = tiles[0].length / 2; j < tiles[0].length; j++)
				tiles[i][j] = TileDesign.getMudTileDesignOne(j * 100, i * 100, 100, 100, 0);
	}
	
	/**
	 * Creates a clear Room with 10 rows and 10 columns.
	 */
	public Room()
	{
		this(DEFAULT_TILE_ROW, DEFUALT_TILE_COLUMN);
	}
	
	public Room(Tile[][] tiles)
	{
		this.tiles = tiles;
		roomPixWidth = tiles.length * 100;
		roomPixHeight = tiles[0].length * 100;
	}
	
	//Getters and Setters
	public double getRoomPixHeight() {return roomPixHeight;}
	public double getRoomPixWidth() {return roomPixWidth;}
	public Tile[][] getTiles() {return tiles;}
	public List<Obstacle> getObstacles() {return obstacles;}
	public void setObstacles(List<Obstacle> obstacles) {this.obstacles = obstacles;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public List<Character> getCharacters() {return characters;}
	public void setCharacters(List<Character> characters) {this.characters = characters;}
	public List<Item> getItems() {return items;}
	public void setItems(List<Item> items) {this.items = items;}
	public RoomPortManager getTeleporterManager() {return teleporterManager;}
	public void setTeleporterManager(RoomPortManager teleporterManager) {this.teleporterManager = teleporterManager;}

	public void addProjectile(Projectile projectile)
	{
		projectiles.add(projectile);
		//System.out.println("added");
	}
	
	public List<Projectile> getProjectiles() {return projectiles;}
	
	public void removeProjectile(Projectile projectile)
	{
		projectiles.remove(projectile);
		//System.out.println("removed");
	}
	
	public void addObstacle(Obstacle obs)
	{
		obstacles.add(obs);
	}
	
	public void addCharacter(Character character)
	{
		characters.add(character);
	}
	
	public void removeCharacter(Character character)
	{
		characters.remove(character);
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
	}
	
	public void removeItem(int idx)
	{
		items.remove(idx);
	}
	public void removeItem(Item item)
	{
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
					projectiles.remove(projectile);
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
		for(Tile[] tileArr: tiles)
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
	}
}
