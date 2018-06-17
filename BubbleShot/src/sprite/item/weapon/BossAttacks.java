package sprite.item.weapon;

import java.util.ArrayList;
import java.util.List;

import sprite.projectile.Projectile;
import sprite.projectile.ProjectileDesign;

public class BossAttacks 
{
	public static List<Weapon> getBossOneAtkPattern(double x, double y)
	{
		List<Weapon> atkList=new ArrayList<Weapon>();
		atkList.add(BossAttacks.getBossAtkOne(x,y));
		atkList.add(BossAttacks.getBossAtkTwo(x,y));
		atkList.add(BossAttacks.getBossAtkThree(x,y));
		atkList.add(BossAttacks.getBossAtkFour(x,y));
		atkList.add(BossAttacks.getBossAtkFive(x,y));
		return atkList;
	}
	
	public static List<Weapon> getBossTwoAtkPattern(double x, double y)
	{
		List<Weapon> atkList=new ArrayList<Weapon>();
		atkList.add(BossAttacks.getBossAtkSix(x, y));
		atkList.add(BossAttacks.getBossAtkSeven(x, y));
		atkList.add(BossAttacks.getBossAtkEight(x, y));
		return atkList;
	}
	
	public static BossWepOne getBossAtkOne(double x, double y)
	{
		double damage = 5;
		double attackRate = .05;
		double attackRange = 800;
		Projectile projectile = ProjectileDesign.getEBulletDesignOne(null, x, y, 0, 5);
		int offsetAngle = 120;
		int bulletPerShot = 5;
		int ammoUsedPerShot = 0;
		BossWepOne shotgun = new BossWepOne("Shotgun", x, y, damage, attackRate, attackRange, projectile, offsetAngle, bulletPerShot, ammoUsedPerShot,5);
		shotgun.setAutomatic(true);
		return shotgun;
	}
	
	public static BossWepTwo getBossAtkTwo(double x, double y)
	{
		double damage = 5;
		double attackRate = .001;
		double attackRange = 800;
		Projectile projectile = ProjectileDesign.getEBulletDesignOne(null, x, y, 0, 5);
		int offsetAngle = 72;
		int bulletPerShot = 5;
		int ammoUsedPerShot = 0;
		BossWepTwo shotgun = new BossWepTwo("Shotgun", x, y, damage, attackRate, attackRange, projectile, offsetAngle, bulletPerShot, ammoUsedPerShot,5);
		shotgun.setAutomatic(true);
		return shotgun;
	}
	
	public static BossWepThree getBossAtkThree(double x, double y)
	{
		double damage = .3;
		double attackRate = .1;
		double attackRange = 800;
		int offsetAngle = 180;
		Projectile projectile = ProjectileDesign.getEBulletDesignOne(null, x, y, 0, 5);
		int bulletPerShot = 180;
		int ammoUsedPerShot = 0;
		BossWepThree shotgun = new BossWepThree("Shotgun", x, y, damage, attackRate, attackRange, projectile, offsetAngle, bulletPerShot, ammoUsedPerShot,5);
		shotgun.setAutomatic(true);
		return shotgun;
	}
	
	public static BossWepFour getBossAtkFour(double x, double y)
	{
		double damage = 1;
		double attackRate = .40;
		double attackRange = 100;
		int offsetAngle = 160;
		Projectile projectile =ProjectileDesign.getESlowBulletDesignOne(null, x, y, 0, 5);
		int bulletPerShot = 180;
		int ammoUsedPerShot = 0;
		BossWepFour shotgun = new BossWepFour("Shotgun", x, y, damage, attackRate, attackRange, projectile, offsetAngle, bulletPerShot, ammoUsedPerShot,5);
		shotgun.setAutomatic(true);
		return shotgun;
	}
	
	public static BossWepFive getBossAtkFive(double x, double y)
	{
		double damage = 2.5;
		double attackRate = .1;
		double attackRange = 800;
		int offsetAngle = 180;
		Projectile projectile = ProjectileDesign.getEBulletDesignOne(null, x, y, 0, 5);
		int bulletPerShot = 180;
		int ammoUsedPerShot = 0;
		BossWepFive shotgun = new BossWepFive("Shotgun", x, y, damage, attackRate, attackRange, projectile, offsetAngle, bulletPerShot, ammoUsedPerShot,5);
		shotgun.setAutomatic(true);
		return shotgun;
	}
	
	public static BossWepSix getBossAtkSix(double x, double y)
	{
		double damage = 20;
		double attackRate = .1;
		double attackRange = 1000;
		Projectile projectile = ProjectileDesign.getESlashDesignOne(null, x, y, 0, 15);
		BossWepSix sword = new BossWepSix("Sword", x, y, damage, attackRate, attackRange, projectile,5);
		return sword;
	}
	
	public static BossWepSeven getBossAtkSeven(double x, double y)
	{
		double damage = 20;
		double attackRate = .03;
		double attackRange = 1000;
		int offsetAngle = 360;
		Projectile projectile = ProjectileDesign.getESlashDesignOne(null, x, y, 0, 15);
		BossWepSeven sword = new BossWepSeven("Sword",x, y, damage, attackRate, attackRange, projectile, offsetAngle,5);
		return sword;
	}
	
	public static BossWepEight getBossAtkEight(double x, double y)
	{
		double damage = 20;
		double attackRate = .001;
		double attackRange = 1000;
		Projectile projectile = ProjectileDesign.getESBulletDesignOne(null, x, y, 0, 5);
		int bulletPerShot = 12;
		int ammoUsedPerShot = 0;
		BossWepEight sword = new BossWepEight("Sword", x, y, damage, attackRate, attackRange, projectile, bulletPerShot, ammoUsedPerShot,5);
		sword.setAutomatic(false);
		return sword;
	}
}
