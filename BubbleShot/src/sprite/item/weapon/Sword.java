package sprite.item.weapon;

import sprite.projectile.Projectile;

public class Sword extends Weapon
{
	public Sword(String fileName, double xLocation, double yLocation, String itemType, 
			boolean isCooledDown, double damage, double attackRate, double attackRange, Projectile projectile) 
	{
		super("","file:resources/weaponPictures/sword.png", xLocation, yLocation, itemType, 
				isCooledDown, damage, attackRate, attackRange, projectile, 60, 60, 0);
		setAmmoUsed(0);
	}

}
