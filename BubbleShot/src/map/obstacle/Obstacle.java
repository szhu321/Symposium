package map.obstacle;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Obstacles are placed on top of the map tiles. Its at same level as the 
 * characters. Its mainly used for barriers, walls, etc.
 * @author Sheng
 *
 */
public class Obstacle
{
	private String name;
	private String fileName;
	private Image img;
	private ImageView imgView;
	
	private double xPos;
	private double yPos;
	
	private double width;
	private double height;
	
	/**
	 * A new obstacle to be added to the map.
	 * @param name
	 * @param fileName
	 * @param width
	 * @param height
	 * @param xPos
	 * @param yPos
	 */
	public Obstacle(String name, String fileName, double width, double height, double xPos, double yPos)
	{
		
	}
}
