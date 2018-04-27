package sprite.character;

import javafx.geometry.Point2D;
import map.Room;
import sprite.Sprite;
import sprite.character.effect.EffectManager;
import sprite.item.Item;

public abstract class Character extends Sprite
{
	private double currentHealth, defaultHealth;
	private double speed;
	
	private EffectManager effectManager;
	private	Room currentRoom;
	
	public Character(String spriteName, String fileName, double xLocation, double yLocation, double health, double speed, double width, double height) 
	{
		super(spriteName, fileName, xLocation, yLocation,width, height, 0);
		effectManager = new EffectManager(this);
		this.currentHealth = health;
		this.defaultHealth = health;
		this.speed = speed;
	}
	
	public Room getCurrentRoom() 
	{
		return currentRoom;
	}
	
	public void setCurrentRoom(Room currentRoom) 
	{
		this.currentRoom = currentRoom;
	}
	
	public double getCurrentHealth(){return currentHealth;}
	public double getSpeed()
	{
		//System.out.println(effectManager.getSpeedMultiplier());
		return speed * effectManager.getSpeedMultiplier();
	}
	public double getDefaultHealth() {return defaultHealth;}
	public EffectManager getEffectManager()	{return effectManager;}
	
	public void setCurrentHealth(double currentHealth) 
	{
		if(currentHealth > defaultHealth)
			this.currentHealth = defaultHealth;
		else
		{
			this.currentHealth = currentHealth;
		}
		//if(currentHealth <= 0)
			//DeadMethod
	}
	public void setSpeed(double speed) {this.speed = speed;}
	public void setDefaultHealth(int defaultHealth) {this.defaultHealth = defaultHealth;}	
	
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
			       +"Effects = " + effectManager.toString() + "\n"
			       +"Face Angle = " + getFaceAngle() + "\n";
		return output;
	}

	public abstract void useCurrentItem(String input);
	public abstract void coolDownWeapons(double sec);
}
