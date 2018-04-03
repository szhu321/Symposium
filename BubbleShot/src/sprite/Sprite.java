package sprite;

import javafx.scene.image.Image;

public abstract class Sprite 
{
	private String spriteName,fileName;
	private double xCoord,yCoord,width,height;
	private Image spriteImage;
	
	protected Sprite(String spriteName, String fileName, double xLocation, double yLocation, double width, double height)
	{
		this.spriteName=spriteName;
		this.fileName = fileName;
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
}