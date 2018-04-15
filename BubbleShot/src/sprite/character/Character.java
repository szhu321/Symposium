package sprite.character;

import sprite.Sprite;
import sprite.character.effect.EffectManager;
import sprite.item.Item;

public abstract class Character extends Sprite
{
	private int currentHealth, defaultHealth;
	private double speed, faceAngle; 
	private Item selectedItem;
	private EffectManager effectManager;
	
	public Character(String spriteName, String fileName, double xLocation, double yLocation, int health, double speed, double width, double height) 
	{
		super(spriteName, fileName, xLocation, yLocation,width, height);
		effectManager = new EffectManager(this);
		this.currentHealth = health;
		this.defaultHealth = health;
		this.speed = speed;
		faceAngle = 0;
		selectedItem=null;
	}
	
	public int getCurrentHealth(){return currentHealth;}
	public double getSpeed()
	{
		return speed * effectManager.getSpeedMultiplier();
	}
	public int getDefaultHealth() {return defaultHealth;}
	public EffectManager getEffectManager()	{return effectManager;}
	public Item getSelectedItem(){return selectedItem;}
	public double getfaceAngle(){return faceAngle;}
	
	public void setCurrentHealth(int currentHealth) 
	{
		this.currentHealth = currentHealth;
		if(currentHealth <= 0)
			//DeadMethod
		if(currentHealth > defaultHealth)
			currentHealth = defaultHealth;
	}
	public void setSpeed(double speed) {this.speed = speed;}
	public void setDefaultHealth(int defaultHealth) {this.defaultHealth = defaultHealth;}
	public void setFaceAngle(double faceAngle){this.faceAngle = faceAngle;}
			
	public void moveUp(double time)
	{
		this.addYLocation(-(speed*time));
	}
	
	public void moveDown(double time)
	{
		this.addYLocation((speed*time));
	}
	
	public void moveLeft(double time)
	{
		this.addXLocation(-(speed*time));
	}
	
	public void moveRight(double time)
	{
		this.addXLocation(speed*time);
	}
	
	public String toString()
	{
		String output = "";
		output += "Current Health = " + currentHealth + "\n"
				   +"Default Health = " + defaultHealth + "\n"
				   +"Speed = " + speed + "\n"
			       +"Selected Item = " + selectedItem.getSpriteName() + "\n"
			       +"Effects = " + effectManager.toString() + "\n"
			       +"Face Angle = " + faceAngle + "\n";
		return output;
	}
	
	public void changeSelectedItem(Item newSelection)
	{
		selectedItem=newSelection;
	}
	
	public abstract void useSelectedItem(String input);
	
}
