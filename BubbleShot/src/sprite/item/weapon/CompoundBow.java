package sprite.item.weapon;

import sprite.projectile.Projectile;

public class CompoundBow extends Weapon
{
	public CompoundBow(String fileName, int xLocation, int yLocation, String itemType, 
			boolean isCooledDown, int damage, double attackRate, double attackRange, double coolDownTime, Projectile projectile) 
	{
		super("","file:resources/weaponPictures/compoundBow.png", xLocation, yLocation, 
				itemType, isCooledDown, damage, attackRate, attackRange, coolDownTime, projectile);
	}

}
