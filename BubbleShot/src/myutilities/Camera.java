package myutilities;

import javafx.scene.shape.Shape;

/**
 * The camera keeps track of the players position and 
 * updates the x and y coordinates accordingly.
 * The camera moves with the tweening algorithm that has a smooth
 * transition effect.
 */
public class Camera
{
	private double xCoord;
	private double yCoord;
	
	public Camera(double xCoord, double yCoord)
	{
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}
	
	public void shiftCamera(Shape player)
	{
		xCoord += (player.getTranslateX() - xCoord) * .5;
		yCoord += (player.getTranslateY() - yCoord) * .5;
	}
	
	public void shiftCamera(double x, double y, double windowX,double windowY)
	{
		//Tweening Algorithm.
		xCoord += ((-x + (windowX/2)) - xCoord) * .2;
		yCoord += ((-y + (windowY/2)) - yCoord) * .2;
	}
	
	public double getxCoord() {return xCoord;}
	public double getyCoord() {return yCoord;}
	public void setxCoord(double xCoord) {this.xCoord = xCoord;}
	public void setyCoord(double yCoord) {this.yCoord = yCoord;}
}
