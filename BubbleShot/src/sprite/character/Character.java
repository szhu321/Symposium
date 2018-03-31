package sprite.character;

import sprite.Sprite;
import sprite.character.effect.EffectManager;
import sprite.item.Item;

public abstract class Character extends Sprite
{
	private int currentHealth;
	private int defaultHealth;
	private double currentSpeed;
	private double defaultSpeed; 
	private Item selectedItem;
	private EffectManager effectManger;
	private double faceAngle;
	
	public Character(String spriteName, String fileName, double xLocation, double yLocation, int health, double speed, double width, double height) 
	{
		super(spriteName, fileName, xLocation, yLocation,width, height);
		effectManger = new EffectManager(this);
		this.currentHealth = health;
		this.defaultHealth = health;
		this.currentSpeed = speed;
		this.defaultSpeed = speed;
		faceAngle=0;
		selectedItem=null;
	}
	
	public int getCurrentHealth(){return currentHealth;}
	public double getCurrentSpeed(){return currentSpeed;}
	public double getDefaultSpeed() {return defaultSpeed;}
	public int getDefaultHealth() {return defaultHealth;}
	
	public void setCurrentHealth(int currentHealth) 
	{
		this.currentHealth = currentHealth;
		if(currentHealth <= 0)
			//DeadMethod
		if(currentHealth > defaultHealth)
			currentHealth = defaultHealth;
	}
	public void setCurrentSpeed(double currentSpeed) {this.currentSpeed = currentSpeed;}
	public void setDefaultHealth(int defaultHealth) {this.defaultHealth = defaultHealth;}
	public void setDefaultSpeed(double defaultSpeed) {this.defaultSpeed = defaultSpeed;}
	
	public EffectManager getEffectManager()
	{
		return effectManger;
	}
	
	public Item getSelectedItem()
	{
		return selectedItem;
	}
	
	public double getfaceAngle()
	{
		return faceAngle;
	}
	
	public void changeSelectedItem(Item newSelection)
	{
		selectedItem=newSelection;
	}
	
	public void setFaceAngle(int faceAngle)
	{
		this.faceAngle = faceAngle;
	}
	
	public void moveUp(double time)
	{
		this.addYLocation(-(currentSpeed*time));
	}
	
	public void moveDown(double time)
	{
		this.addYLocation((currentSpeed*time));
	}
	
	public void moveLeft(double time)
	{
		this.addXLocation(-(currentSpeed*time));
	}
	
	public void moveRight(double time)
	{
		this.addXLocation(currentSpeed*time);
	}
	
	public abstract void useSelectedItem(String input);
	
}
