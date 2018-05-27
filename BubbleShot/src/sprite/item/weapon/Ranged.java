package sprite.item.weapon;

import sprite.projectile.Projectile;

public class Ranged extends Weapon
{

	private double weaponAttackRange;
	private Projectile projectile;
	private int ammoUsed;
	
	public Ranged(String spriteName, String fileName, double xLocation, double yLocation, double damage,
			double attackRate, double attackRange, Projectile projectile, double width, double height, int ammoUsed)
	{
		super(spriteName, fileName, xLocation, yLocation, damage, attackRate, attackRange, projectile, width, height, ammoUsed);
		// TODO Auto-generated constructor stub
	}

}
