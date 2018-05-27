package sprite.item.weapon;

import sprite.projectile.Projectile;

public class Melee extends Weapon
{

	public Melee(String spriteName, String fileName, double xLocation, double yLocation, double damage,
			double attackRate, double attackRange, Projectile projectile, double width, double height, int ammoUsed)
	{
		super(spriteName, fileName, xLocation, yLocation, damage, attackRate, attackRange, projectile, width, height, ammoUsed);
		
	}
	
}
