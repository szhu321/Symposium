package sprite.projectile;

import map.Room;
import sprite.Sprite;

public abstract class Projectile extends Sprite
{
	public static final String SHOT_BY_PLAYER = "player";
	public static final String SHOT_BY_ENEMY = "enemy";
	
	private double damage;
	private double speed;
	private String bulletOwner;
	private double range;
	private Room currentRoom;
	
	//private double aoeRaduis; - The area of effect radius.
	
	public Projectile(String spriteName, String fileName, String bulletOwner, double xLocation, double yLocation, double width, double height, double speed, double faceAngle, double damage, double range)
	{
		super(spriteName ,fileName, xLocation, yLocation, width, height, faceAngle);
		this.setSpeed(speed);
		this.bulletOwner = bulletOwner;
		this.damage = damage;
		this.range = range;
	}
	
	public double getDamage() {return damage;}
	public double getSpeed() {return speed;}
	public void setSpeed(double speed) {this.speed = speed;}
	public void setDamage(double damage) {this.damage = damage;}
	public String getBulletOwner() {return bulletOwner;}
	public void setBulletOwner(String owner) {bulletOwner = owner;} 
	public double getRange() {return range;}
	public void setRange(double range) {this.range = range;}
	public void setCurrentRoom(Room room)
	{
		currentRoom = room;
	}
	public Room getCurrentRoom()
	{
		return currentRoom;
	}
	
	public Projectile getCopy()
	{
		Projectile projectile = new LinearProjectile(getSpriteName(), getSpriteFileName(), bulletOwner, getXLocation(), getYLocation(), getWidth(), getHeight(), speed, getFaceAngle(), damage, range);
		return projectile;
	}
	
	/**
	 * 
	 * @param timePassed - timePassed in milliseconds.
	 */
	public abstract void updateLocation(double timePassedMilli);

	
}
