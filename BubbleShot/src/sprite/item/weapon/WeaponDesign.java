package sprite.item.weapon;

import sprite.item.Item;
import sprite.projectile.Projectile;
import sprite.projectile.ProjectileDesign;

public class WeaponDesign
{
	public static CompoundBow getCompoundBowDesignOne()
	{
		return null;
	}
	
	public static CrossBow getCrossBowDesignOne()
	{
		return null;
	}
	
	public static Fist getFistDesignOne()
	{
		return null;
	}
	
	public static Pistol getPistolDesignOne(double x, double y)
	{
		Projectile projectile = ProjectileDesign.getBulletDesignOne(null, x, y, 0, 5);
		Pistol pistol = new Pistol(x, y, Item.WEAPON, true, 5, .2, 400, projectile);
		return pistol;
	}
	
	public static Sniper getSniperDesignOne(double x, double y)
	{
		double damage = 15;
		double attackRate = .5;
		double attackRange = 1500;
		Projectile projectile = ProjectileDesign.getSniperBulletDesignOne(null, x, y, 0, damage);
		Sniper sniper = new Sniper("Sniper", x, y, Item.WEAPON, true, damage, attackRate, attackRange, projectile);
		return sniper;
	}
	
	public static Sword getSwordDesignOne()
	{
		return null;
	}
}
