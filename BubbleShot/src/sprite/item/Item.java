package sprite.item;

import map.Room;
import sprite.Sprite;
import sprite.character.Character;
import sprite.character.player.Player;

public abstract class Item extends Sprite implements Consumable
{
	public static final String WEAPON = "weapon";
	public static final String POTION = "potion";
	private String itemType;
	private boolean isCooledDown;
	private double currentCoolDownTime;
	private double defaultCoolDownTime;
	private Character possessor;
	private Room currentRoom;
	//item types: potions and weapons
	
	public Item(String spriteName, String fileName, double xLocation, double yLocation, String itemType, boolean isCooledDown, double coolDownTime, double width, double height) 
	{
		super(spriteName,fileName, xLocation, yLocation, width,height, 0);
		this.itemType = itemType;
		this.isCooledDown = isCooledDown;
		currentCoolDownTime = coolDownTime;
		defaultCoolDownTime = coolDownTime;
	}
	
	public Character getPossessor()
	{
		return possessor;
	}
	
	public void destroy()
	{
		if(possessor == null)
			currentRoom.removeItem(this);
		else
			((Player)possessor).removeItem(this);
	}
	
	public Room getCurrentRoom()
	{
		return currentRoom;
	}
	
	public void setCurrentRoom(Room currentRoom) 
	{
		this.currentRoom = currentRoom;
	}
	
	public void setPossessor(Character possessor)
	{
		this.possessor = possessor;
	}
	
	public String getItemType()
	{
		return itemType;
	}
	
	public void coolDownItem(double sec)
	{
		currentCoolDownTime -= sec;
		if(currentCoolDownTime <= 0)
			isCooledDown = true;
	}
	
	public double getDefaultCoolDownTime()
	{
		return defaultCoolDownTime;
	}
	
	public void setCurrentCoolDownTime(double currentCoolDownTime)
	{
		this.currentCoolDownTime = currentCoolDownTime;
	}
	
	public void setCooledDown(boolean isCooledDown)
	{
		this.isCooledDown = isCooledDown;
	}
	
	public boolean isCooledDown()
	{
		return isCooledDown;
	}
}
