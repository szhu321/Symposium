package sprite.projectile;

public class ProjectileDesign
{
	public static Projectile getBulletDesignOne(String bulletOwner, double xLocation, double yLocation, double faceAngle, double damage)
	{
		String fileName = "file:resources/projectilePictures/bullet.png";
		double width = 22;
		double height = 22;
		double travelDistance = 400;
		double speed = 300;
		Projectile bullet = new LinearProjectile("Simple Bullet", fileName, bulletOwner, xLocation, yLocation, width, height, speed, faceAngle, damage, travelDistance);
		return bullet;
	}
	
	public static Projectile getSniperBulletDesignOne(String bulletOwner, double xLocation, double yLocation, double faceAngle, double damage)
	{
		String fileName = "file:resources/projectilePictures/bullet.png";
		double width = 15;
		double height = 15;
		double travelDistance = 1500;
		double speed = 900;
		Projectile bullet = new LinearProjectile("Sniper Bullet", fileName, bulletOwner, xLocation, yLocation, width, height, speed, faceAngle, damage, travelDistance);
		return bullet;
	}
}
