package map;

import java.util.ArrayList;
import java.util.List;

import map.Tile.*;
import map.obstacle.Obstacle;

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
	private Tile[][] tiles;
	
	private List<Obstacle> obstacles;
	
	
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
	
	public double getRoomPixHeight() {return roomPixHeight;}
	public double getRoomPixWidth() {return roomPixWidth;}
	public Tile[][] getTiles() {return tiles;}
	public List<Obstacle> getObstacles() {return obstacles;}
	public void setObstacles(List<Obstacle> obstacles) {this.obstacles = obstacles;}
	
	public void addObstacle(Obstacle obs)
	{
		obstacles.add(obs);
	}
	
	public void removeObstacle(Obstacle obs)
	{
		obstacles.remove(obs);
	}
	
	public void removeObstacle(int idx)
	{
		obstacles.remove(idx);
	}
}
