package sprite.projectile;

import sprite.Sprite;

public abstract class Projectile extends Sprite
{
	private int damage;
	private double speed;
	private double faceAngle;
	
	//private double aoeRaduis; - The area of effect radius.
	
	public Projectile(String spriteName, String fileName, double xLocation, double yLocation, double width, double height, double speed, double faceAngle)
	{
		super(spriteName ,fileName, xLocation, yLocation, width, height);
		this.setSpeed(speed);
		this.faceAngle = faceAngle;
	}
	
	public int getDamage() {return damage;}
	public double getSpeed() {return speed;}
	public void setSpeed(double speed) {this.speed = speed;}
	public void setDamage(int damage) {this.damage = damage;}
	public double getFaceAngle() {return faceAngle;}
	public void setFaceAngle(double faceAngle) {this.faceAngle = faceAngle;}
	
	/**
	 * 
	 * @param timePassed - timePassed in milliseconds.
	 */
	public abstract void updateLocation(double timePassedMilli);

	
}
