package sprite.projectile;

import javafx.scene.image.Image;
import sprite.bounds.BoxCollider;

public class Slash extends LinearProjectile
{

	public Slash(String spriteName, Image image, String bulletOwner, double xLocation, double yLocation, double width,
			double height, double speed, double faceAngle, double damage, double range)
	{
		super(spriteName, image, bulletOwner, xLocation, yLocation, width, height, speed, faceAngle, damage, range);
		
	}
	
	public Slash(String spriteName, String fileName,String bulletOwner, double xLocation, double yLocation, double width, double height, double speed, double faceAngle, double damage, double range)
	{
		super(spriteName, fileName, bulletOwner, xLocation, yLocation, width, height, speed, faceAngle, damage, range);
	}
	
	public BoxCollider getBoundsOfObject()
	{
		return new BoxCollider(getXCenter() - 3, getYCenter() - 3, 6, 6, 0);
	}
	
	public Projectile getCopy()
	{
		Projectile projectile = new Slash(getSpriteName(), getSpriteImage(), getBulletOwner(), getXLocation(), getYLocation(), getWidth(), getHeight(), getSpeed(), getFaceAngle(), getDamage(), getRange());
		return projectile;
	}

}
