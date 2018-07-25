package myutilities;

import java.io.Serializable;

/**
 * The class that keeps track of a projectile's location on the screen
 * based on time.
 */
public class LinearParaEquation implements Serializable
{
	private double deltaX;
	private double deltaY;
	private double time;
	private double initialX;
	private double initialY;
	private double distanceTraveled;
	
	public LinearParaEquation(double initialX, double initialY, double deltaX, double deltaY)
	{
		this.initialX = initialX;
		this.initialY = initialY;
		this.deltaX = deltaX;
		this.deltaY = deltaY;
		distanceTraveled = 0;
	}
	
	public double getXPos()
	{
		return (deltaX * time) + initialX; 
	}
	
	public double getYPos()
	{
		return (deltaY * time) + initialY;
	}
	
	public double getXPosAtTime(double time)
	{
		return (deltaX * time) + initialX; 
	}
	
	public double getDistanceTraveled()
	{
		return Math.sqrt(Math.pow((Math.abs(deltaX) * time),2) + Math.pow((Math.abs(deltaY) * time),2)) + distanceTraveled;
	}
	
	public void addDistanceTraveled(double disTrav)
	{
		distanceTraveled += disTrav;
	}
	
	public double getYPosAtTime(double time)
	{
		return (deltaY * time) + initialY;
	}
	
	public double getTime()
	{
		return time;
	}
	
	public void setTime(double time)
	{
		this.time = time;
	}
	
	public void addTime(double timeIncrement)
	{
		time += timeIncrement;
	}

	public double getDeltaX()
	{
		return deltaX;
	}

	public double getDeltaY() 
	{
		return deltaY;
	}

	public double getInitialX() 
	{
		return initialX;
	}

	public double getInitialY()
	{
		return initialY;
	}
}
