package myutilities;

public class LinearParaEquation
{
	private double deltaX;
	private double deltaY;
	private double time;
	private double initialX;
	private double initialY;
	
	public LinearParaEquation(double initialX, double initialY, double deltaX, double deltaY)
	{
		this.initialX = initialX;
		this.initialY = initialY;
		this.deltaX = deltaX;
		this.deltaY = deltaY;
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
		return Math.sqrt(Math.pow((Math.abs(deltaX) * time),2) + Math.pow((Math.abs(deltaY) * time),2));
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
}
