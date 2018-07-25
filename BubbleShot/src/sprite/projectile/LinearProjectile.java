package sprite.projectile;

import java.io.Serializable;

import javafx.scene.image.Image;
import myutilities.LinearEquation;
import myutilities.LinearParaEquation;

public class LinearProjectile extends Projectile
{
	private LinearParaEquation travelPath;
	
	public LinearProjectile(String spriteName, String fileName,String bulletOwner, double xLocation, double yLocation, double width, double height, double speed, double faceAngle, double damage, double range)
	{
		super(spriteName, fileName, bulletOwner, xLocation, yLocation, width, height, speed, faceAngle, damage, range);
		//travelPath = new LinearParaEquation(faceAngle, xLocation, yLocation);
		createTravelPath(xLocation, yLocation, faceAngle, speed);
	}
	
	public LinearProjectile(String spriteName, Image image,String bulletOwner, double xLocation, double yLocation, double width, double height, double speed, double faceAngle, double damage, double range)
	{
		super(spriteName, image, bulletOwner, xLocation, yLocation, width, height, speed, faceAngle, damage, range);
		//travelPath = new LinearParaEquation(faceAngle, xLocation, yLocation);
		createTravelPath(xLocation, yLocation, faceAngle, speed);
	}
	
	public void createTravelPath(double x, double y, double angle, double speed)
	{
		angle = angle % 360;
		double deltaX = speed * Math.cos(Math.toRadians(angle));
		double deltaY = speed * Math.sin(Math.toRadians(angle));
		travelPath = new LinearParaEquation(x, y, deltaX, deltaY);
	}
	
	public void updateLocation(double timePassedMilli)
	{
		travelPath.addTime(timePassedMilli / 1000);
		updateXPos();
		updateYPos();
		
	}
	
	public LinearParaEquation getTravelPath()
	{
		return travelPath;
	}
	
	public void setTravelPath(LinearParaEquation travelPath)
	{
		this.travelPath = travelPath;
	}

	private void updateXPos()
	{
		setXLocation(travelPath.getXPos());
	}
	
	private void updateYPos()
	{
		setYLocation(travelPath.getYPos());
	}
}
