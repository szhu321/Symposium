package sprite.item.weapon;

import sprite.projectile.Projectile;

public class CrossBow extends Weapon
{
	public CrossBow(String fileName, int xLocation, int yLocation, String itemType, 
			boolean isCooledDown, int damage, double attackRate, double attackRange, double coolDownTime, Projectile projectile) 
	{
		super("","file:resource/weaponPictures/crossbow.png", xLocation, yLocation, itemType, 
				isCooledDown, damage, attackRate, attackRange, coolDownTime, projectile);
	}


}
