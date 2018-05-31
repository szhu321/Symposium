package sprite;

import java.io.Serializable;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sprite.bounds.BoxCollider;
import sprite.bounds.CircleCollider;
import sprite.bounds.Collider;

public abstract class Sprite implements Collider, Serializable
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
		spriteImage = new Image(fileName, width, height, true, true);
		spriteImageView = new ImageView(spriteImage);
		this.faceAngle = faceAngle;
	}
	
	protected Sprite(String spriteName, Image image, double xLocation, double yLocation, double width, double height, double faceAngle)
	{
		this.spriteName=spriteName;
		this.fileName = "";
		xCoord = xLocation;
		yCoord = yLocation;
		this.width = width;
		this.height = height;
		spriteImage = image;
		spriteImageView = new ImageView(spriteImage);
		this.faceAngle = faceAngle;
	}
	
	public String getSpriteFileName()
	{
		return fileName;
	}
	public void setSpriteFileName(String fileName)
	{
		this.fileName=fileName;
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
	
	public double getXLocationMax()
	{
		return xCoord + width;
	}
	
	public double getYLocationMax()
	{
		return yCoord + height;
	}
	
	public double getXCenter()
	{
		return xCoord + (width / 2);
	}
	
	public double getYCenter()
	{
		return yCoord + (height / 2);
	}
	
	public double getWidth()
	{
		return width;
	}
	
	public double getHeight()
	{
		return height;
	}
	
	public void setWidth(double width)
	{
		this.width = width;
	}

	public void setHeight(double height)
	{
		this.height = height;
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
	
	public BoxCollider getBoundsOfObject(double setX,double setY)
	{
		return new BoxCollider(setX, setY, width, height, faceAngle);
	}
	
	public CircleCollider getCircleBoundsOfObject(double radius)
	{
		return new CircleCollider(getXCenter(), getYCenter(), radius);
	}
	
	public CircleCollider getCircleBoundsOfObject()
	{
		double radius;
		if(height >= width)
			radius = width / 2;
		else
			radius = height / 2;
		return new CircleCollider(xCoord + (width / 2), yCoord + (height / 2), radius);
	}
}