package sprite.item.weapon;

import sprite.projectile.Projectile;

public class Fist extends Weapon
{
	public Fist(String spriteName, String fileName, double xLocation, double yLocation,
			 double damage, double attackRate, double attackRange,  Projectile projectile) 
	{
		super(spriteName ,fileName, xLocation, yLocation, damage, attackRate, 
				attackRange, projectile, 30, 30, 0,0);
	}
	
}
