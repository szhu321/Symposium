package sprite.item.weapon;

import sprite.projectile.Projectile;

public class CrossBow extends Weapon
{
	public CrossBow(String fileName, double xLocation, double yLocation, String itemType, 
			boolean isCooledDown, double damage, double attackRate, double attackRange,  Projectile projectile) 
	{
		super("","file:resources/weaponPictures/crossbow.png", xLocation, yLocation, itemType, 
				isCooledDown, damage, attackRate, attackRange, projectile, 70, 70);
	}


}
