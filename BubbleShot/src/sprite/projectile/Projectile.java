package sprite.projectile;

import sprite.Sprite;

public abstract class Projectile extends Sprite
{
	public static final String SHOT_BY_PLAYER = "player";
	public static final String SHOT_BY_ENEMY = "enemy";
	
	private int damage;
	private double speed;
	private String bulletOwner;
	
	//private double aoeRaduis; - The area of effect radius.
	
	public Projectile(String spriteName, String fileName, String bulletOwner, double xLocation, double yLocation, double width, double height, double speed, double faceAngle, int damage)
	{
		super(spriteName ,fileName, xLocation, yLocation, width, height, faceAngle);
		this.setSpeed(speed);
		this.bulletOwner = bulletOwner;
		this.damage = damage;
	}
	
	public int getDamage() {return damage;}
	public double getSpeed() {return speed;}
	public void setSpeed(double speed) {this.speed = speed;}
	public void setDamage(int damage) {this.damage = damage;}
	public String getBulletOwner() {return bulletOwner;}
	
	/**
	 * 
	 * @param timePassed - timePassed in milliseconds.
	 */
	public abstract void updateLocation(double timePassedMilli);

	
}
