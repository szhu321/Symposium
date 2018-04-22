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
	private static double xCoord = 0;
	private static double yCoord = 0;
	
//	public void shiftCamera(Shape player)
//	{
//		xCoord += (player.getTranslateX() - xCoord) * .5;
//		yCoord += (player.getTranslateY() - yCoord) * .5;
//	}
	
	public static void shiftCamera(double x, double y, double windowX,double windowY)
	{
		//Tweening Algorithm.
		xCoord += ((-x + (windowX / 2)) - xCoord) * .2;
		yCoord += ((-y + (windowY / 2)) - yCoord) * .2;
	}
	
	public static double getxCoord() {return xCoord;}
	public static double getyCoord() {return yCoord;}
	public static void setxCoord(double x) {xCoord = x;}
	public static void setyCoord(double y) {yCoord = y;}
}
