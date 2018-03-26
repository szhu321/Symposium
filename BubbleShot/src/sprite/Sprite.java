package sprite;

import javafx.scene.image.Image;

public abstract class Sprite 
{
	private String spriteName;
	private double xCoord;
	private double yCoord;
	private double width;
	private double height;
	private Image spriteImage;
	
	protected Sprite(String fileName, double xLocation, double yLocation, double width, double height)
	{
		spriteName = fileName;
		xCoord = xLocation;
		yCoord = yLocation;
		this.width=width;
		this.height=height;
		spriteImage=new Image(fileName);
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
	
	public void addXLocation(double newX)
	{
		xCoord+=newX;
	}
	
	public void addYLocation(double newY)
	{
		yCoord+=newY;
	}
}