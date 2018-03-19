package sprite.character;

import sprite.Sprite;

public abstract class Character extends Sprite
{
	private int health;
	private int speed;
	private String weapon;
	
	protected Character(String fileName, int xLocation, int yLocation, int health, int speed,
			String weapon) 
	{
		super(fileName, xLocation, yLocation);
		this.health = health;
		this.speed = speed;
		this.weapon = weapon;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public String getWeapon()
	{
		return weapon;
	}
}
