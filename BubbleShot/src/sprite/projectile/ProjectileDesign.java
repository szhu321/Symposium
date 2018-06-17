package sprite.projectile;

public class ProjectileDesign
{
	public static Projectile getBulletDesignOne(String bulletOwner, double xLocation, double yLocation, double faceAngle, double damage)
	{
		String fileName = "file:resources/projectilePictures/bullet.png";
		double width = 18;
		double height = 18;
		double travelDistance = 400;
		double speed = 500;
		Projectile bullet = new LinearProjectile("Simple Bullet", fileName, bulletOwner, xLocation, yLocation, width, height, speed, faceAngle, damage, travelDistance);
		return bullet;
	}
	
	public static Projectile getEBulletDesignOne(String bulletOwner, double xLocation, double yLocation, double faceAngle, double damage)
	{
		String fileName = "file:resources/projectilePictures/ebullet.png";
		double width = 18;
		double height = 18;
		double travelDistance = 400;
		double speed = 500;
		Projectile bullet = new LinearProjectile("Simple Bullet", fileName, bulletOwner, xLocation, yLocation, width, height, speed, faceAngle, damage, travelDistance);
		return bullet;
	}
	
	public static Projectile getESBulletDesignOne(String bulletOwner, double xLocation, double yLocation, double faceAngle, double damage)
	{
		String fileName = "file:resources/slash/slash.png";
		double width = 20;
		double height = 80;
		double travelDistance = 400;
		double speed = 350;
		Projectile bullet = new LinearProjectile("Simple Bullet", fileName, bulletOwner, xLocation, yLocation, width, height, speed, faceAngle, damage, travelDistance);
		return bullet;
	}
	
	public static Projectile getESlowBulletDesignOne(String bulletOwner, double xLocation, double yLocation, double faceAngle, double damage)
	{
		String fileName = "file:resources/projectilePictures/ebullet.png";
		double width = 18;
		double height = 18;
		double travelDistance = 400;
		double speed = 150;
		Projectile bullet = new LinearProjectile("Simple Bullet", fileName, bulletOwner, xLocation, yLocation, width, height, speed, faceAngle, damage, travelDistance);
		return bullet;
	}
	
	public static Projectile getSniperBulletDesignOne(String bulletOwner, double xLocation, double yLocation, double faceAngle, double damage)
	{
		String fileName = "file:resources/projectilePictures/bullet.png";
		double width = 14;
		double height = 14;
		double travelDistance = 1500;
		double speed = 1500;
		Projectile bullet = new LinearProjectile("Sniper Bullet", fileName, bulletOwner, xLocation, yLocation, width, height, speed, faceAngle, damage, travelDistance);
		return bullet;
	}
	
	public static Projectile getSlashDesignOne(String bulletOwner, double xLocation, double yLocation, double faceAngle, double damage)
	{
		String fileName = "file:resources/slash/slash.png";
		double width = 20;
		double height = 100;
		double travelDistance = .2;
		double speed = 1;
		Slash bullet = new Slash("Slash", fileName, bulletOwner, xLocation, yLocation, width, height, speed, faceAngle, damage, travelDistance);
		return bullet;
	}
	
	public static Projectile getESlashDesignOne(String bulletOwner, double xLocation, double yLocation, double faceAngle, double damage)
	{
		String fileName = "file:resources/slash/slash.png";
		double width = 20;
		double height = 100;
		double travelDistance = 1500;
		double speed = 350;
		Slash bullet = new Slash("Slash", fileName, bulletOwner, xLocation, yLocation, width, height, speed, faceAngle, damage, travelDistance);
		return bullet;
	}
	
	public static Projectile getFistDesignOne(String bulletOwner, double xLocation, double yLocation, double faceAngle, double damage)
	{
		String fileName = "file:resources/weaponPictures/fist.png";
		double width = 30;
		double height = 30;
		double travelDistance = .2;
		double speed = 1;
		Slash bullet = new Slash("Fist", fileName, bulletOwner, xLocation, yLocation, width, height, speed, faceAngle, damage, travelDistance);
		return bullet;
	}
	
	public static PenetrationBullet getPeneBulletDesignOne(String bulletOwner, double xLocation, double yLocation, double faceAngle, double damage)
	{
		String fileName = "file:resources/projectilePictures/bullet.png";
		double width = 14;
		double height = 14;
		double travelDistance = 1500;
		double speed = 1500;
		int peneCount = 2;
		PenetrationBullet bullet = new PenetrationBullet("Fist", fileName, bulletOwner, xLocation, yLocation, width, height, speed, faceAngle, damage, travelDistance, peneCount);
		return bullet;
	}
}
