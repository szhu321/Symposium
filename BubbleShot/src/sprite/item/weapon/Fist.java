package sprite.item.weapon;

import sprite.projectile.Projectile;

public class Fist extends Weapon
{
	public Fist(String fileName, double xLocation, double yLocation, String itemType,
			boolean isCooledDown, double damage, double attackRate, double attackRange,  Projectile projectile) 
	{
		super("",fileName, xLocation, yLocation, itemType, isCooledDown, damage, attackRate, 
				attackRange, projectile, 30, 30, 0);
	}
	
}
