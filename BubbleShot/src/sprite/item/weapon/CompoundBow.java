package sprite.item.weapon;

import sprite.projectile.Projectile;

public class CompoundBow extends Weapon
{
	public CompoundBow(String fileName, double xLocation, double yLocation, String itemType, 
			boolean isCooledDown, double damage, double attackRate, double attackRange,  Projectile projectile, int ammoUsed) 
	{
		super("","file:resources/weaponPictures/compoundBow.png", xLocation, yLocation, 
				itemType, isCooledDown, damage, attackRate, attackRange, projectile, 70, 70, ammoUsed);
	}

}
