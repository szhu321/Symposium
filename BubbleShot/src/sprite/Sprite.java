package sprite;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sprite.bounds.BoxCollider;
import sprite.bounds.Collider;

public abstract class Sprite implements Collider
{
	private String spriteName,fileName;
	private double xCoord,yCoord,width,height,faceAngle;
	private Image spriteImage;
	private ImageView spriteImageView;
	
	protected Sprite(String spriteName, String fileName, double xLocation, double yLocation, double width, double height, double faceAngle)
	{
		this.spriteName=spriteName;
		this.fileName = fileName;
		xCoord = xLocation;
		yCoord = yLocation;
		this.width = width;
		this.height = height;
		spriteImage = new Image(fileName, width, height, false, false);
		spriteImageView = new ImageView(spriteImage);
		this.faceAngle = faceAngle;
	}
	
	public double getFaceAngle()
	{
		return faceAngle;
	}
	
	public void setFaceAngle(double faceAngle)
	{
		this.faceAngle = faceAngle;
	}
	
	public double getXLocation()
	{
		return xCoord;
	}
	
	public double getYLocation()
	{
		return yCoord;
	}
	
	public double getWidth()
	{
		return width;
	}
	
	public double getHeight()
	{
		return height;
	}
	
	public void setXLocation(double x)
	{
		xCoord = x;
	}
	
	public void setYLocation(double y)
	{
		yCoord = y;
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
		return new BoxCollider(xCoord, yCoord, width, height, faceAngle);
	}
}