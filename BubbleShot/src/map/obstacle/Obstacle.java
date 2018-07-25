package map.obstacle;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Translate;
import sprite.Sprite;
import sprite.bounds.BoxCollider;
import sprite.bounds.Collider;

/**
 * Obstacles are placed on top of the map tiles. Its at same level as the 
 * characters. Its mainly used for barriers, walls, etc.
 * @author Sheng
 *
 */
public class Obstacle extends Sprite implements Collider
{
	private static final long serialVersionUID = -584532843083071509L;

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
