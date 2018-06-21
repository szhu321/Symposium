package sprite.projectile;

import javafx.scene.image.Image;
import myutilities.LinearParaEquation;
import myutilities.MyMath;

public class BouncingProjectile extends LinearProjectile
{
	public static final String HIT_LEFT_EDGE = "left";
	public static final String HIT_RIGHT_EDGE = "right";
	public static final String HIT_TOP_EDGE = "top";
	public static final String HIT_BOTTOM_EDGE = "bottom";
	
	private String hitSide;
	private double offsetAngle;
	private int numBounces;
	
	public BouncingProjectile(String spriteName, String fileName, String bulletOwner, double xLocation,
			double yLocation, double width, double height, double speed, double faceAngle, double damage,
			double range, int numBounces, double offsetAngle)
	{
		super(spriteName, fileName, bulletOwner, xLocation, yLocation, width, height, speed, faceAngle, damage, range);
		this.numBounces = numBounces;
		this.offsetAngle = offsetAngle;
	}

	public BouncingProjectile(String spriteName, Image image, String bulletOwner, double xLocation, double yLocation,
			double width, double height, double speed, double faceAngle, double damage, double range, int numBounces, double offsetAngle)
	{
		super(spriteName, image, bulletOwner, xLocation, yLocation, width, height, speed, faceAngle, damage, range);
		this.numBounces = numBounces;
		this.offsetAngle = offsetAngle;
	}

	public boolean isDown()
	{
		numBounces--;
		if(numBounces <= 0)
			return true;
		LinearParaEquation currentEq = getTravelPath();
		double angle = 0;
		if(hitSide == null)
		{
			return true;
		}
		if(hitSide.equals(HIT_BOTTOM_EDGE) || hitSide.equals(HIT_TOP_EDGE))
		{
			angle = MyMath.findAngleBetween(currentEq.getDeltaX(), currentEq.getDeltaY(), currentEq.getDeltaX() * 5, -currentEq.getDeltaY() * 5);
		}
		if(hitSide.equals(HIT_LEFT_EDGE) || hitSide.equals(HIT_RIGHT_EDGE))
		{
			angle = MyMath.findAngleBetween(currentEq.getDeltaX(), currentEq.getDeltaY(), -currentEq.getDeltaX() * 5, currentEq.getDeltaY() * 5);
		}
		
		int flip = (int)(Math.random() * 2);
		double angleOffset = (Math.random() * offsetAngle);
		if(flip == 0)
			angle = angle + angleOffset;
		else
			angle = angle - angleOffset;
		if(angle > 360)
			angle = angle % 360;
		if(angle < 0)
			angle += 360;
		
		createTravelPath(currentEq.getXPos(), currentEq.getYPos(), angle, getSpeed());
		setFaceAngle(angle);
		//updateLocation(20);
		return false;
	}
	
	public Projectile getCopy()
	{
		Projectile projectile = new BouncingProjectile(getSpriteName(), getSpriteImage(), getBulletOwner(), getXLocation(), getYLocation(), getWidth(), getHeight(), getSpeed(), getFaceAngle(), getDamage(), getRange(), getNumBounces(), getOffsetAngle());
		projectile.setSpriteFileName(getSpriteFileName());
		return projectile;
	}

	public double getOffsetAngle()
	{
		return offsetAngle;
	}

	public int getNumBounces()
	{
		return numBounces;
	}
	
	public void setHitSide(String side)
	{
		hitSide = side;
	}
	
	public String getHitSide()
	{
		return hitSide;
	}
}
