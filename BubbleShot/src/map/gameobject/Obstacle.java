package map.gameobject;

import sprite.Sprite;
import sprite.bounds.Collider;

/**
 * Obstacles are placed on top of the map tiles. Its at same level as the 
 * characters. Its mainly used for barriers, walls, etc.
 * @author Sheng
 *
 */
public class Obstacle extends UnbreakableObject implements Collider
{
	/**
	 * A new obstacle to be added to the map.
	 * @param name - name of the obstacle
	 * @param fileName - image path of the obstacle
	 * @param width - the width of the obstacle
	 * @param height - the height of the obstacle 
	 * @param xPos - the x location of the obstacle
	 * @param yPos - the y location of the obstacle
	 */
	public Obstacle(String name, String fileName, double width, double height, double xPos, double yPos, double faceAngle)
	{
		super(name, fileName, xPos, yPos, width, height, faceAngle);
	}
}
