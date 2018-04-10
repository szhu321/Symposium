package sprite;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sprite.bounds.BoxCollider;
import sprite.bounds.Collider;

public abstract class Sprite implements Collider
{
	private String spriteName,fileName;
	private double xCoord,yCoord,width,height;
	private Image spriteImage;
	private ImageView spriteImageView;
	
	protected Sprite(String spriteName, String fileName, double xLocation, double yLocation, double width, double height)
	{
		this.spriteName=spriteName;
		this.fileName = fileName;
		xCoord = xLocation;
		yCoord = yLocation;
		this.width=width;
		this.height=height;
		spriteImage=new Image(fileName, width, height, false, false);
		spriteImageView = new ImageView(spriteImage);
	}
	
	public double getXLocation()
	{
		return xCoord;
	}
	
	public double getYLocation()
	{
		return yCoord;
	}
	
	public String getSpriteName()
	{
		return spriteName;
	}
	
	public Image getSpriteImage()
	{
		return spriteImage;
	}
	
	public ImageView getSpriteImageView()
	{
		return spriteImageView;
	}
	
	public void addXLocation(double newX)
	{
		xCoord+=newX;
	}
	
	public void addYLocation(double newY)
	{
		yCoord+=newY;
	}
	
	public String toString()
	{
		//debug
		String output = "";
		output += "Sprite Name = " + spriteName + "\n"
				 +"File Name = " + fileName + "\n"
				 +"X Coords = " + xCoord + "\n"
				 +"Y Coords = " + yCoord + "\n"
				 +"Width = " + width + "\n"
			     +"Height = " + height + "\n";
		return output;
	}
	
	public BoxCollider getBoundsOfObject()
	{
		return new BoxCollider(xCoord, yCoord, width, height);
	}
}