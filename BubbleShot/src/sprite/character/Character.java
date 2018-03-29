package sprite.character;

import sprite.Sprite;
import sprite.character.effect.EffectManager;
import sprite.item.Item;

public abstract class Character extends Sprite
{
	private int health;
	private int speed;
	private Item selectedItem;
	private EffectManager effects;
	private double faceAngle;
	
	public Character(String spriteName, String fileName, double xLocation, double yLocation, int health, int speed, double width, double height) 
	{
		super(spriteName, fileName, xLocation, yLocation,width, height);
		effects = new EffectManager(this);
		this.health = health;
		this.speed = speed;
		faceAngle=0;
		selectedItem=null;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public int getSpeed()
	{
		return speed;
	}

	public Item getSelectedItem()
	{
		return selectedItem;
	}
	
	public double getfaceAngle()
	{
		return faceAngle;
	}
	
	public void setHealth(int health)
	{
		this.health=health;
	}
	
	public void setSpeed(int speed)
	{
		this.speed=speed;
	}
	
	public void changeSelectedItem(Item newSelection)
	{
		selectedItem=newSelection;
	}
	
	public void faceAngle(int faceAngle)
	{
		this.faceAngle=faceAngle;
	}
	
	public void moveUp(double time)
	{
		this.addYLocation(-(speed*time));
	}
	
	public void moveDown(double time)
	{
		this.addYLocation(-(speed*time));
	}
	
	public void moveLeft(double time)
	{
		this.addXLocation(-(speed*time));
	}
	
	public void moveRight(double time)
	{
		this.addXLocation(speed*time);
	}
	
	public abstract void useSelectedItem(String input);
	
}
