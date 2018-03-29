package sprite.projectile;

import sprite.Sprite;

public class Projectile extends Sprite
{
	private int damage;
	private double speed;
	private double deltaX;
	private double deltaY;
	
	//private double aoeRaduis; - The area of effect radius.
	
	public Projectile(String spriteName, String fileName, double xLocation, double yLocation, double width, double height, double speed, double deltaX, double deltaY)
	{
		super(spriteName ,fileName, xLocation, yLocation, width, height);
		this.speed = speed;
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}
	
	public int getDamage() {return damage;}
	
	/**
	 * 
	 * @param timePassed - timePassed in milliseconds.
	 */
	public void updateLocation(double timePassedMilli)
	{
		double secPassed = timePassedMilli / 1000;
		updateXPos(secPassed);
		updateYPos(secPassed);
	}
	
	private void updateXPos(double timePassedSec)
	{
		addXLocation(speed * timePassedSec * deltaX);
	}
	
	private void updateYPos(double timePassedSec)
	{
		addYLocation(speed * timePassedSec * deltaY);
	}
}
