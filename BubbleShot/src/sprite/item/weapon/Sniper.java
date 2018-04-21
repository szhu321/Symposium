package sprite.item.weapon;

import sprite.projectile.Projectile;

public class Sniper extends Weapon
{
	public Sniper(String fileName, int xLocation, int yLocation, String itemType, 
			boolean isCooledDown, int damage, double attackRate, double attackRange, double coolDownTime, Projectile projectile) 
	{
		super("","file:resource/weaponPictures/sniper.png", xLocation, yLocation, itemType, 
				isCooledDown, damage, attackRate, attackRange, coolDownTime, projectile);
	}

}
