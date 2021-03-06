package sprite.item.weapon;

import java.util.ArrayList;
import java.util.List;

import mainGame.GameRunner;
import sprite.projectile.Projectile;
import sprite.projectile.ProjectileDesign;

public class BossAttacks 
{
	public static List<Weapon> getBossOneAtkPattern(double x, double y,int levelNum)
	{
		List<Weapon> atkList=new ArrayList<Weapon>();
		atkList.add(BossAttacks.getBossAtkOne(x,y,levelNum));
		atkList.add(BossAttacks.getBossAtkTwo(x,y,levelNum));
		atkList.add(BossAttacks.getBossAtkThree(x,y,levelNum));
		atkList.add(BossAttacks.getBossAtkFour(x,y,levelNum));
		atkList.add(BossAttacks.getBossAtkFive(x,y,levelNum));
		return atkList;
	}
	
	public static List<Weapon> getBossTwoAtkPattern(double x, double y,int levelNum)
	{
		List<Weapon> atkList=new ArrayList<Weapon>();
		atkList.add(BossAttacks.getBossAtkSix(x, y,levelNum));
		atkList.add(BossAttacks.getBossAtkSeven(x, y,levelNum));
		atkList.add(BossAttacks.getBossAtkEight(x, y,levelNum));
		return atkList;
	}
	
	public static List<Weapon> getBossThreeAtkPattern(double x, double y,int levelNum)
	{
		List<Weapon> atkList=new ArrayList<Weapon>();
		atkList.add(BossAttacks.getBossAtkNine(x, y,10,-10,levelNum));
		atkList.add(BossAttacks.getBossAtkNine(x, y,100,8,levelNum));
		atkList.add(BossAttacks.getBossAtkNine(x, y,190,17,levelNum));
		atkList.add(BossAttacks.getBossAtkNine(x, y,280,26,levelNum));
		atkList.add(BossAttacks.getBossAtkNine(x, y,55,25,levelNum));
		atkList.add(BossAttacks.getBossAtkNine(x, y,145,125,levelNum));
		atkList.add(BossAttacks.getBossAtkNine(x, y,235,215,levelNum));
		atkList.add(BossAttacks.getBossAtkNine(x, y,325,305,levelNum));
		return atkList;
	}
	
	public static List<Weapon> getBossThreeAtkPatternTwo(double x, double y,int levelNum)
	{
		List<Weapon> atkList=new ArrayList<Weapon>();
		atkList.add(BossAttacks.getBossAtkTen(x, y,levelNum));
		return atkList;
	}
	
	public static List<Weapon> getBossThreeAtkPatternThree(double x, double y,int levelNum)
	{
		List<Weapon> atkList=new ArrayList<Weapon>();
		atkList.add(BossAttacks.getBossAtkEleven(x, y,levelNum));
		return atkList;
	}
	
	public static BossWepOne getBossAtkOne(double x, double y,int levelNum)
	{
		int currentLevel=levelNum;
		double damage = 3+(levelNum-1)*5;
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
	
	public static BossWepTwo getBossAtkTwo(double x, double y,int levelNum)
	{
		int currentLevel=levelNum;
		double damage = 3+(levelNum-1)*5;
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
	
	public static BossWepThree getBossAtkThree(double x, double y,int levelNum)
	{
		int currentLevel=levelNum;
		double damage = .3+(levelNum-1)*.7;
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
	
	public static BossWepFour getBossAtkFour(double x, double y,int levelNum)
	{
		int currentLevel=levelNum;
		double damage = 1+(levelNum-1)*3;
		double attackRate = .40;
		double attackRange = 100;
		int offsetAngle = 180 ;
		Projectile projectile =ProjectileDesign.getESlowBulletDesignOne(null, x, y, 0, 5);
		int bulletPerShot = 180;
		int ammoUsedPerShot = 0;
		BossWepFour shotgun = new BossWepFour("Shotgun", x, y, damage, attackRate, attackRange, projectile, offsetAngle, bulletPerShot, ammoUsedPerShot,5);
		shotgun.setAutomatic(true);
		return shotgun;
	}
	
	public static BossWepFive getBossAtkFive(double x, double y,int levelNum)
	{
		int currentLevel=levelNum;
		double damage = 2.5+(levelNum-1)*3;
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
	
	public static BossWepSix getBossAtkSix(double x, double y,int levelNum)
	{
		int currentLevel=levelNum;
		double damage = 20+(levelNum-1)*10;
		double attackRate = .1;
		double attackRange = 1000;
		Projectile projectile = ProjectileDesign.getESlashDesignOne(null, x, y, 0, 15);
		BossWepSix sword = new BossWepSix("Sword", x, y, damage, attackRate, attackRange, projectile,5);
		return sword;
	}
	
	public static BossWepSeven getBossAtkSeven(double x, double y,int levelNum)
	{
		int currentLevel=levelNum;
		double damage = 20+(levelNum-1)*10;
		double attackRate = .03;
		double attackRange = 1000;
		int offsetAngle = 360;
		Projectile projectile = ProjectileDesign.getESlashDesignOne(null, x, y, 0, 15);
		BossWepSeven sword = new BossWepSeven("Sword",x, y, damage, attackRate, attackRange, projectile, offsetAngle,5);
		return sword;
	}
	
	public static BossWepEight getBossAtkEight(double x, double y,int levelNum)
	{
		int currentLevel=levelNum;
		double damage = 20+(levelNum-1)*10;
		double attackRate = .001;
		double attackRange = 1000;
		Projectile projectile = ProjectileDesign.getESBulletDesignOne(null, x, y, 0, 5);
		int bulletPerShot = 12;
		int ammoUsedPerShot = 0;
		BossWepEight sword = new BossWepEight("Sword", x, y, damage, attackRate, attackRange, projectile, bulletPerShot, ammoUsedPerShot,5);
		sword.setAutomatic(false);
		return sword;
	}
	
	public static BossWepNine getBossAtkNine(double x, double y,double left, double right,int levelNum)
	{
		int currentLevel=levelNum;
		double damage = .5+(levelNum-1)*.8;
		int offsetAngle = 120;
		double attackRate = .04;
		double attackRange = 1000;
		Projectile projectile = ProjectileDesign.getFBulletDesignOne(null, x, y, 0, 5);
		int bulletPerShot = 2;
		int ammoUsedPerShot = 0;
		BossWepNine sword = new BossWepNine("Shotgun", x, y, damage, attackRate, attackRange, projectile, offsetAngle, bulletPerShot, ammoUsedPerShot,5,left,right);
		sword.setAutomatic(true);
		return sword;
	}
	public static BossWepTen getBossAtkTen(double x, double y,int levelNum)
	{
		int currentLevel=levelNum;
		double damage = 3+(levelNum-1)*2;
		int offsetAngle = 120;
		double attackRate = .7;
		double attackRange = 1000;
		Projectile projectile = ProjectileDesign.getIBulletDesignOne(null, x, y, 0, 5);
		int bulletPerShot = 10;
		int ammoUsedPerShot = 0;
		BossWepTen sword = new BossWepTen("Shotgun", x, y, damage, attackRate, attackRange, projectile, offsetAngle, bulletPerShot, ammoUsedPerShot,5);
		sword.setAutomatic(true);
		return sword;
	}
	
	public static BossWepEleven getBossAtkEleven(double x, double y,int levelNum)
	{
		int currentLevel=levelNum;
		double damage = 3+(levelNum-1)*2;
		int offsetAngle = 120;
		double attackRate = .7;
		double attackRange = 1000;
		Projectile projectile = ProjectileDesign.getDBulletDesignOne(null, x, y, 0, 5);
		int bulletPerShot = 5;
		int ammoUsedPerShot = 0;
		BossWepEleven sword = new BossWepEleven("Shotgun", x, y, damage, attackRate, attackRange, projectile, bulletPerShot, ammoUsedPerShot,5);
		sword.setAutomatic(true);
		return sword;
	}
}
