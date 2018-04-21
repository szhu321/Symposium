package sprite.item.weapon;

import sprite.projectile.Projectile;

public class Fist extends Weapon
{
	public Fist(String fileName, int xLocation, int yLocation, String itemType,
			boolean isCooledDown, int damage, double attackRate, double attackRange, double coolDownTime, Projectile projectile) 
	{
		super("",fileName, xLocation, yLocation, itemType, isCooledDown, damage, attackRate, 
				attackRange, coolDownTime, projectile);
	}
	
}
