package map;

import java.util.ArrayList;
import java.util.List;

import map.Tile.*;
import map.Tile.teleporter.RoomPortManager;
import map.obstacle.Obstacle;
import sprite.item.Item;
import sprite.character.Character;

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
	private List<Obstacle> obstacles;
	private List<Character> characters;
	private List<Item> items;
	
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
			for(int j = 0; j < tiles[0].length; j++)
				tiles[i][j] = new GrassTile2();
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
		obstacles = new ArrayList<Obstacle>();
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
		
	}
}
