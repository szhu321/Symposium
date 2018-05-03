package sprite.item.weapon;

import sprite.projectile.Projectile;

public class Sniper extends Weapon
{
	public Sniper(String fileName, double xLocation, double yLocation, String itemType, 
			boolean isCooledDown, double damage, double attackRate, double attackRange,  Projectile projectile) 
	{
		super("Sniper","file:resources/weaponPictures/sniper.png", xLocation, yLocation, itemType, 
				isCooledDown, damage, attackRate, attackRange, projectile, 110, 60);
	}

}
