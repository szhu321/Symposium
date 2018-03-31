package sprite.projectile;

public class LinearProjectile extends Projectile
{
	private double deltaX;
	private double deltaY;
	
	public LinearProjectile(String spriteName, String fileName, double xLocation, double yLocation, double width, double height, double speed, double deltaX, double deltaY)
	{
		super(spriteName, fileName, xLocation, yLocation, width, height, speed);
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}
	
	public void updateLocation(double timePassedMilli)
	{
		double secPassed = timePassedMilli / 1000;
		updateXPos(secPassed);
		updateYPos(secPassed);
	}
	
	private void updateXPos(double timePassedSec)
	{
		addXLocation(getSpeed() * timePassedSec * deltaX);
	}
	
	private void updateYPos(double timePassedSec)
	{
		addYLocation(getSpeed() * timePassedSec * deltaY);
	}
}
