package sprite.item.weapon;

import sprite.projectile.Projectile;

public class Sword extends Weapon
{
	public Sword(String fileName, int xLocation, int yLocation, String itemType, 
			boolean isCooledDown, int damage, double attackRate, double attackRange, double coolDownTime, Projectile projectile) 
	{
		super("","file:resource/weaponPictures/sword.png", xLocation, yLocation, itemType, 
				isCooledDown, damage, attackRate, attackRange, coolDownTime, projectile);
	}

}
