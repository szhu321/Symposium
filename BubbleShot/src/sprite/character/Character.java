package sprite.character;

import javafx.geometry.Point2D;
import map.Room;
import sprite.Sprite;
import sprite.character.effect.EffectManager;
import sprite.character.movement.MovementDrive;
import sprite.item.Item;

public abstract class Character extends Sprite
{
	private static final long serialVersionUID = 5734238308090470540L;
	
	private double currentHealth, defaultHealth;
	private double speed;
	private boolean gunVisibility;
	
	private transient MovementDrive movement;
	
	private transient EffectManager effectManager;
	private	transient Room currentRoom;
	
	public Character(String spriteName, String fileName, double xLocation, double yLocation, double health, double speed, double width, double height) 
	{
		super(spriteName, fileName, xLocation, yLocation,width, height, 0);
		effectManager = new EffectManager(this);
		this.currentHealth = health;
		this.defaultHealth = health;
		this.speed = speed;
		movement = new MovementDrive(this);
		setGunVisibility(true);
	}
	
	public void reloadObject()
	{
		super.reloadObject();
		effectManager = new EffectManager(this);
		movement = new MovementDrive(this);
	}
	
	public void setEffectManager(EffectManager effectManager)
	{
		this.effectManager = effectManager;
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
		if(currentHealth > getDefaultHealth())
			this.currentHealth = getDefaultHealth();
		else
		{
			this.currentHealth = currentHealth;
		}
		//if(currentHealth <= 0)
			//DeadMethod
	}
	
	public MovementDrive getMovement() {
		return movement;
	}

	public void setMovement(MovementDrive movement) {
		this.movement = movement;
	}

	public void setSpeed(double speed) {this.speed = speed;}
	public void setDefaultHealth(int defaultHealth) {this.defaultHealth = defaultHealth;}	
	
	public boolean isGunVisibility() {
		return gunVisibility;
	}

	public void setGunVisibility(boolean gunVisibility) {
		this.gunVisibility = gunVisibility;
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
