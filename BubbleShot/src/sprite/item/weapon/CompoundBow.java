package sprite.item.weapon;

import sprite.projectile.Projectile;

public class CompoundBow extends Weapon
{
	public CompoundBow(String fileName, double xLocation, double yLocation,
			 double damage, double attackRate, double attackRange,  Projectile projectile, int ammoUsed,int cost) 
	{
		super("","file:resources/weaponPictures/compoundBow.png", xLocation, yLocation, 
				 damage, attackRate, attackRange, projectile, 70, 70, ammoUsed,cost);
	}

}
