package sprite.item.weapon;

import mainGame.GameRunner;
import sprite.character.player.Player;
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
	
	public static Fist getFistDesignOne(Player player)
	{
		double damage = 5;
		double shootingSpeed = .2;
		double bulletTravelRange = .2;
		Projectile projectile = ProjectileDesign.getFistDesignOne(null, 0, 0, 0, 5);
		Fist fist = new Fist("Fist", "file:resources/weaponPictures/fist.png", 0, 0, damage, shootingSpeed, bulletTravelRange, projectile);
		fist.setPossessor(player);
		return fist;
	}
	
	public static Pistol getPistolDesignOne(double x, double y,int levelNum)
	{
		int cost = 10+(levelNum-1)*5;
		int ammoUsedPerShot = 1;
		double damage = 5 + (levelNum-1) * 5;
		double shootingSpeed = .2;
		double bulletTravelRange = 400;
		Projectile projectile = ProjectileDesign.getBulletDesignOne(null, x, y, 0, 5);
		Pistol pistol = new Pistol(x, y, damage, shootingSpeed, bulletTravelRange, projectile, ammoUsedPerShot,cost);
		return pistol;
	}
	
	public static Pistol getEPistolDesignOne(double x, double y,int levelNum)
	{
		int ammoUsedPerShot = 1;
		double damage = 5+(levelNum-1)*5;
		double shootingSpeed = .2;
		double bulletTravelRange = 400;
		Projectile projectile = ProjectileDesign.getEBulletDesignOne(null, x, y, 0, 5);
		Pistol pistol = new Pistol(x, y, damage, shootingSpeed, bulletTravelRange, projectile, ammoUsedPerShot,5);
		return pistol;
	}
	
	public static Sniper getSniperDesignOne(double x, double y,int levelNum)
	{
		int cost=25+(levelNum-1)*10;
		double damage = 15+(levelNum-1)*10;
		double attackRate = .5;
		double attackRange = 1500;
		int ammoUsedPerShot = 3;
		Projectile projectile = ProjectileDesign.getSniperBulletDesignOne(null, x, y, 0, damage);
		Sniper sniper = new Sniper("Sniper", x, y, damage, attackRate, attackRange, projectile, ammoUsedPerShot,cost);
		return sniper;
	}
	
	public static Sniper getSniperDesignEPIC(double x, double y,int levelNum)
	{
		double damage = 5.5+(levelNum-1)*5;
		double attackRate = .01;
		double attackRange = 5000;
		int ammoUsedPerShot = 0;
		Projectile projectile = ProjectileDesign.getBouncingProjectileOne(null, x, y, 0, damage);
		Sniper sniper = new Sniper("Legendary Sniper", x, y, damage, attackRate, attackRange, projectile, ammoUsedPerShot,999);
		sniper.setAutomatic(true);
		return sniper;
	}
	
	public static Shotgun getShotgunDesignOne(double x, double y,int levelNum)
	{
		int cost=20+(levelNum-1)*10;
		double damage = 5+(levelNum-1)*5;
		//System.out.println(levelNum);
		double attackRate = .6;
		double attackRange = 500;
		Projectile projectile = ProjectileDesign.getBulletDesignOne(null, x, y, 0,5);
		int offsetAngle = 10;
		int bulletPerShot = 5;
		int ammoUsedPerShot = 3;
		Shotgun shotgun = new Shotgun("Shotgun", x, y, damage, attackRate, attackRange, projectile, offsetAngle, bulletPerShot, ammoUsedPerShot,cost);
		return shotgun;
	}
	
	public static Shotgun getShotgunDesignEPIC(double x, double y,int levelNum)
	{	
		double damage = .05+(levelNum-1)*.5;
		double attackRate = .10;
		double attackRange = 400;
		double offsetAngle = 360;
		int bulletPerShot = 1000;
		int ammoUsedPerShot = 0;
		Projectile projectile = ProjectileDesign.getBulletDesignOne(null, x, y, 0, 5);
		Shotgun shotgun = new Shotgun("Legendary Shotgun", x, y, damage, attackRate, attackRange, projectile, offsetAngle, bulletPerShot, ammoUsedPerShot,99999);
		return shotgun;
	}
	
	public static AssaultRifle getAssaultRifleDesignOne(double x, double y,int levelNum)
	{
		int cost=30+(levelNum-1)*15;
		double damage = 5+(levelNum-1)*5;
		double attackRate = .1;
		double attackRange = 500;
		int offsetAngle = 7;
		int ammoUsedPerShot = 1;
		Projectile projectile = ProjectileDesign.getBulletDesignOne(null, x, y, 0, 5);
		AssaultRifle rifle = new AssaultRifle("Assault Rifle", x, y, damage, attackRate, attackRange, projectile, offsetAngle, ammoUsedPerShot,cost);
		rifle.setAutomatic(true);
		return rifle;
	}
	
	public static AssaultRifle getEAssaultRifleDesignOne(double x, double y,int levelNum)
	{	
		double damage = 5+(levelNum-1)*5;
		double attackRate = .1;
		double attackRange = 500;
		int offsetAngle = 7;
		int ammoUsedPerShot = 1;
		Projectile projectile = ProjectileDesign.getEBulletDesignOne(null, x, y, 0, 5);
		AssaultRifle rifle = new AssaultRifle("Assault Rifle", x, y, damage, attackRate, attackRange, projectile, offsetAngle, ammoUsedPerShot,5);
		rifle.setAutomatic(true);
		return rifle;
	}
	
	public static Sword getSwordDesignOne(double x, double y,int levelNum)
	{
		int cost=15+(levelNum-1)*5;
		double damage = 20+(levelNum-1)*10;
		double attackRate = .2;
		double attackRange = .2;
		Projectile projectile = ProjectileDesign.getSlashDesignOne(null, x, y, 0, 15);
		Sword sword = new Sword("Sword", x, y, damage, attackRate, attackRange, projectile,cost);
		return sword;
	}
	
}
