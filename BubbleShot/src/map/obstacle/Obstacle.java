package map.obstacle;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Translate;
import sprite.bounds.BoxCollider;
import sprite.bounds.Collider;

/**
 * Obstacles are placed on top of the map tiles. Its at same level as the 
 * characters. Its mainly used for barriers, walls, etc.
 * @author Sheng
 *
 */
public class Obstacle implements Collider
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
	 * @param name - name of the obstacle
	 * @param fileName - image path of the obstacle
	 * @param width - the width of the obstacle
	 * @param height - the height of the obstacle 
	 * @param xPos - the x location of the obstacle
	 * @param yPos - the y location of the obstacle
	 */
	public Obstacle(String name, String fileName, double width, double height, double xPos, double yPos)
	{
		this.name = name;
		this.fileName = fileName;
		this.width = width;
		this.height = height;
		this.xPos = xPos;
		this.yPos = yPos;
		img = new Image(fileName, width,height,false,false);
		imgView = new ImageView(img);
		imgView.getTransforms().add(new Translate(xPos, yPos));
	}
	
	public Image getImg() {return img;}
	public ImageView getImgView() {return imgView;}
	public String getName() {return name;}
	public double getHeight() {return height;}
	public double getWidth() {return width;}
	public double getxPos() {return xPos;}
	public double getyPos() {return yPos;}
	public void setName(String name) {this.name = name;}

	@Override
	public BoxCollider getBoundsOfObject()
	{
		return new BoxCollider(xPos, yPos, width, height, 0);
	}
}
