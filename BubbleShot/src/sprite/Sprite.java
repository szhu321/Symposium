package sprite;

import java.io.Serializable;

import javafx.scene.image.Image;
import myutilities.MyMath;
import myutilities.Point;
import sprite.bounds.BoxCollider;
import sprite.bounds.CircleCollider;
import sprite.bounds.Collider;

public abstract class Sprite implements Collider, Serializable
{
	private static final long serialVersionUID = 8948031829820320618L;
	
	private String spriteName,fileName;
	private double xCoord,yCoord,width,height,faceAngle;
	private transient Image spriteImage;
	//private ImageView spriteImageView;
	
	public Sprite(String spriteName, String fileName, double xLocation, double yLocation, double width, double height, double faceAngle)
	{
		this.spriteName=spriteName;
		this.fileName = fileName;
		xCoord = xLocation;
		yCoord = yLocation;
		this.width = width;
		this.height = height;
		spriteImage = new Image(fileName, width, height, true, true);
		//spriteImageView = new ImageView(spriteImage);
		this.faceAngle = faceAngle;
	}
	
	public Sprite(String spriteName, Image image, double xLocation, double yLocation, double width, double height, double faceAngle)
	{
		this.spriteName=spriteName;
		this.fileName = "";
		xCoord = xLocation;
		yCoord = yLocation;
		this.width = width;
		this.height = height;
		spriteImage = image;
		//spriteImageView = new ImageView(spriteImage);
		this.faceAngle = faceAngle;
	}
	
	public void reloadObject()
	{
		spriteImage = new Image(fileName, width, height, true, true);
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
	
	public void setSpriteImage(Image image)
	{
		this.spriteImage = image;
	}
	
//	public ImageView getSpriteImageView()
//	{
//		return spriteImageView;
//	}
	
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
	
	public BoxCollider getBoundsOfObject(double newW,double newH)
	{
		return new BoxCollider(xCoord, yCoord, newW, newH, faceAngle);
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
	
	
	/**
	 * Gets a corner point of this rectangular sprite.
	 * @return the top left point of the rectangle, change of location based on faceAngle.
	 * <br> double[0] = xValue
	 * <br> double[1] = yValue
	 */
	public Point getPoint1()
	{
		Point point = new Point(getXLocation(), getYLocation());
		if(faceAngle != 0)
		{
			double[] newAngle = MyMath.rotatePointAboutPivot(point.getX(), point.getY(), getXCenter(), getYCenter(), faceAngle);
			point.setX(newAngle[0]);
			point.setY(newAngle[1]);
		}
		return point;
	}
	
	/**
	 * Gets a corner point of this rectangular sprite.
	 * @return the top right point of the rectangle, change of location based on faceAngle.
	 * <br> double[0] = xValue
	 * <br> double[1] = yValue
	 */
	public Point getPoint2()
	{
		Point point = new Point(getXLocation() + getWidth(), getYLocation());
		if(faceAngle != 0)
		{
			double[] newAngle = MyMath.rotatePointAboutPivot(point.getX(), point.getY(), getXCenter(), getYCenter(), faceAngle);
			point.setX(newAngle[0]);
			point.setY(newAngle[1]);
		}
		return point;
	}
	
	/**
	 * Gets a corner point of this rectangular sprite.
	 * @return the bottom right point of the rectangle, change of location based on faceAngle.
	 * <br> double[0] = xValue
	 * <br> double[1] = yValue
	 */
	public Point getPoint3()
	{
		Point point = new Point(getXLocation() + getWidth(), getYLocation() + getHeight());
		if(faceAngle != 0)
		{
			double[] newAngle = MyMath.rotatePointAboutPivot(point.getX(), point.getY(), getXCenter(), getYCenter(), faceAngle);
			point.setX(newAngle[0]);
			point.setY(newAngle[1]);
		}
		return point;
	}
	
	/**
	 * Gets a corner point of this rectangular sprite.
	 * @return the bottom left point of the rectangle, change of location based on faceAngle.
	 * <br> double[0] = xValue
	 * <br> double[1] = yValue
	 */
	public Point getPoint4()
	{
		Point point = new Point(getXLocation(), getYLocation() + getHeight());
		if(faceAngle != 0)
		{
			double[] newAngle = MyMath.rotatePointAboutPivot(point.getX(), point.getY(), getXCenter(), getYCenter(), faceAngle);
			point.setX(newAngle[0]);
			point.setY(newAngle[1]);
		}
		return point;
	}
}