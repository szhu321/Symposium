package sprite.item.weapon;

import sprite.projectile.Projectile;

public class Sniper extends Weapon
{
	public Sniper(String spriteName, double xLocation, double yLocation,  
		 double damage, double attackRate, double attackRange,  Projectile projectile, int ammoUsed) 
	{
		super(spriteName,"file:resources/weaponPictures/sniper.png", xLocation, yLocation,  
				 damage, attackRate, attackRange, projectile, 110, 60, ammoUsed);
	}

}
