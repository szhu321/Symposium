package sprite.projectile;

public class ProjectileDesign
{
	public static Projectile getBulletDesignOne(String bulletOwner, double xLocation, double yLocation, double faceAngle, int damage)
	{
		String fileName = "file:resources/projectilePictures/bullet.png";
		double width = 100;
		double height = 20;
		Projectile bullet = new LinearProjectile("Simple Bullet", fileName, bulletOwner, xLocation, yLocation, width, height, 500, faceAngle, damage);
		return bullet;
	}
}
