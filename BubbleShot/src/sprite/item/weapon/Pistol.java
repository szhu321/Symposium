package sprite.item.weapon;

import sprite.projectile.Projectile;

public class Pistol extends Weapon
{
	public Pistol(double xLocation, double yLocation, String itemType, 
			boolean isCooledDown, double damage, double attackRate, double attackRange,  Projectile projectile) 
	{
		super("Pistol","file:resources/weaponPictures/pistol.png", xLocation, yLocation, itemType, 
				isCooledDown, damage, attackRate, attackRange, projectile, 60, 60);
	}


}
