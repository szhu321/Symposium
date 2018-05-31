package sprite.item.weapon;

import sprite.projectile.Projectile;

public class Pistol extends Weapon
{
	public Pistol(double xLocation, double yLocation,
			 double damage, double attackRate, double attackRange,  Projectile projectile, int ammoUsed,int cost) 
	{
		super("Pistol","file:resources/weaponPictures/pistol.png", xLocation, yLocation,
				damage, attackRate, attackRange, projectile, 60, 60, ammoUsed, cost);
	}


}
