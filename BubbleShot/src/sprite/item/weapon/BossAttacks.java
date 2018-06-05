package sprite.item.weapon;

import sprite.projectile.Projectile;
import sprite.projectile.ProjectileDesign;

public class BossAttacks 
{
	public static Weapon[] getBossOneAtkPattern()
	{
		return null;
	}
	
	public static BossWepOne getBossAtkOne(double x, double y)
	{
		double damage = 5;
		double attackRate = .001;
		double attackRange = 500;
		Projectile projectile = ProjectileDesign.getBulletDesignOne(null, x, y, 0, 5);
		int offsetAngle = 90;
		int bulletPerShot = 5;
		int ammoUsedPerShot = 0;
		BossWepOne shotgun = new BossWepOne("Shotgun", x, y, damage, attackRate, attackRange, projectile, offsetAngle, bulletPerShot, ammoUsedPerShot,5);
		return shotgun;
	}
	
	public static BossWepTwo getBossAtkTwo(double x, double y)
	{
		double damage = 5;
		double attackRate = .001;
		double attackRange = 500;
		Projectile projectile = ProjectileDesign.getBulletDesignOne(null, x, y, 0, 5);
		int offsetAngle = 1;
		int bulletPerShot = 1;
		int ammoUsedPerShot = 0;
		BossWepTwo shotgun = new BossWepTwo("Shotgun", x, y, damage, attackRate, attackRange, projectile, offsetAngle, bulletPerShot, ammoUsedPerShot,5);
		return shotgun;
	}
	
	public static BossWepThree getBossAtkThree(double x, double y)
	{
		double damage = .07;
		double attackRate = .05;
		double attackRange = 500;
		int offsetAngle = 160;
		Projectile projectile = ProjectileDesign.getBulletDesignOne(null, x, y, 0, 5);
		int bulletPerShot = 360;
		int ammoUsedPerShot = 0;
		BossWepThree shotgun = new BossWepThree("Shotgun", x, y, damage, attackRate, attackRange, projectile, offsetAngle, bulletPerShot, ammoUsedPerShot,5);
		return shotgun;
	}
}
