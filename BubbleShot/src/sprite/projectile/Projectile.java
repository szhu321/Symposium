package sprite.projectile;

import sprite.Sprite;

public class Projectile extends Sprite
{
	private int damage;
	private double speed;
	private double deltaX;
	private double deltaY;
	
	//private double aoeRaduis; - The area of effect radius.
	
	protected Projectile(String fileName, double xLocation, double yLocation, double width, double height)
	{
		super(fileName, xLocation, yLocation, width, height);
		
	}
	
	public int getDamage() {return damage;}
	
}
