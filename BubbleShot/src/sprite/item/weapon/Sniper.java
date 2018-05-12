package sprite.item.weapon;

import sprite.projectile.Projectile;

public class Sniper extends Weapon
{
	public Sniper(String spriteName, double xLocation, double yLocation, String itemType, 
			boolean isCooledDown, double damage, double attackRate, double attackRange,  Projectile projectile, int ammoUsed) 
	{
		super(spriteName,"file:resources/weaponPictures/sniper.png", xLocation, yLocation, itemType, 
				isCooledDown, damage, attackRate, attackRange, projectile, 110, 60, ammoUsed);
	}

}
