package sprite.projectile;

import myutilities.LinearEquation;

public class LinearProjectile extends Projectile
{
	private LinearEquation travelPath;
	
	public LinearProjectile(String spriteName, String fileName, double xLocation, double yLocation, double width, double height, double speed, double faceAngle)
	{
		super(spriteName, fileName, xLocation, yLocation, width, height, speed, faceAngle);
		
	}
	
	public void updateLocation(double timePassedMilli)
	{
		double secPassed = timePassedMilli / 1000;
		updateXPos(secPassed);
		updateYPos(secPassed);
	}
	
	private void updateXPos(double timePassedSec)
	{
		addXLocation(getSpeed() * timePassedSec * travelPath.getDeltaX());
	}
	
	private void updateYPos(double timePassedSec)
	{
		addYLocation(getSpeed() * timePassedSec * travelPath.getDeltaY());
	}
}
