package sprite.character;

import sprite.Sprite;
import sprite.character.effect.EffectManager;
import sprite.item.Item;

public abstract class Character extends Sprite
{
	private int currentHealth,defaultHealth;
	private double currentSpeed,defaultSpeed,faceAngle; 
	private Item selectedItem;
	private EffectManager effectManger;
	
	public Character(String spriteName, String fileName, double xLocation, double yLocation, int health, double speed, double width, double height) 
	{
		super(spriteName, fileName, xLocation, yLocation,width, height);
		effectManger = new EffectManager(this);
		this.currentHealth = health;
		this.defaultHealth = health;
		this.currentSpeed = speed;
		this.defaultSpeed = speed;
		faceAngle = 0;
		selectedItem=null;
	}
	
	public int getCurrentHealth(){return currentHealth;}
	public double getCurrentSpeed(){return currentSpeed;}
	public double getDefaultSpeed() {return defaultSpeed;}
	public int getDefaultHealth() {return defaultHealth;}
	public EffectManager getEffectManager()	{return effectManger;}
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
	public void setCurrentSpeed(double currentSpeed) {this.currentSpeed = currentSpeed;}
	public void setDefaultHealth(int defaultHealth) {this.defaultHealth = defaultHealth;}
	public void setDefaultSpeed(double defaultSpeed) {this.defaultSpeed = defaultSpeed;}
	public void setFaceAngle(double faceAngle){this.faceAngle = faceAngle;}
			
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
	
	public String toString()
	{
		String output = "";
		output += "Current Health = " + currentHealth + "\n"
				   +"Default Health = " + defaultHealth + "\n"
				   +"Current Speed = " + currentSpeed + "\n"
			       +"Default Speed = " + defaultSpeed + "\n"
			       +"Selected Item = " + selectedItem.getSpriteName() + "\n"
			       +"Effects = " + effectManger.toString() + "\n"
			       +"Face Angle = " + faceAngle + "\n";
		return output;
	}
	
	public void changeSelectedItem(Item newSelection)
	{
		selectedItem=newSelection;
	}
	
	public abstract void useSelectedItem(String input);
	
}
