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
		int ammoCount = 5;
		Projectile bullet = new LinearProjectile("Simple Bullet", fileName, bulletOwner, xLocation, yLocation, width, height, speed, faceAngle, damage, travelDistance, ammoCount);
		return bullet;
	}
	
	public static Projectile getEBulletDesignOne(String bulletOwner, double xLocation, double yLocation, double faceAngle, double damage)
	{
		String fileName = "file:resources/projectilePictures/ebullet.png";
		double width = 18;
		double height = 18;
		double travelDistance = 400;
		double speed = 500;
		int ammoCount = 5;
		Projectile bullet = new LinearProjectile("Simple Bullet", fileName, bulletOwner, xLocation, yLocation, width, height, speed, faceAngle, damage, travelDistance, ammoCount);
		return bullet;
	}
	
	public static Projectile getSniperBulletDesignOne(String bulletOwner, double xLocation, double yLocation, double faceAngle, double damage)
	{
		String fileName = "file:resources/projectilePictures/bullet.png";
		double width = 14;
		double height = 14;
		double travelDistance = 1500;
		double speed = 1500;
		int ammoCount = 20;
		Projectile bullet = new LinearProjectile("Sniper Bullet", fileName, bulletOwner, xLocation, yLocation, width, height, speed, faceAngle, damage, travelDistance, ammoCount);
		return bullet;
	}
}
