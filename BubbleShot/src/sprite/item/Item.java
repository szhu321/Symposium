package sprite.item;

import map.Room;
import sprite.Sprite;
import sprite.character.Character;
import sprite.character.player.Player;

public abstract class Item extends Sprite
{
	public static final String WEAPON = "weapon";
	public static final String POTION = "potion";
	public static final String ARMOR = "armor";
	private String itemType;
	private Character possessor;
	private Room currentRoom;
	//item types: potions and weapons
	
	public Item(String spriteName, String fileName, double xLocation, double yLocation,  double width, double height, String itemType) 
	{
		super(spriteName, fileName, xLocation, yLocation, width, height, 0);
		this.itemType = itemType;
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
	
//	public void coolDownItem(double sec)
//	{
//		currentCoolDownTime -= sec;
//		if(currentCoolDownTime <= 0)
//			isCooledDown = true;
//	}
//	
//	public double getDefaultCoolDownTime()
//	{
//		return defaultCoolDownTime;
//	}
//	
//	public void setDefaultCoolDownTime(double time)
//	{
//		defaultCoolDownTime = time;
//	}
//	
//	public void setCurrentCoolDownTime(double currentCoolDownTime)
//	{
//		this.currentCoolDownTime = currentCoolDownTime;
//	}
//	
//	/**
//	 * 
//	 * @param isCooledDown attack rate for weapons.
//	 */
//	public void setCooledDown(boolean isCooledDown)
//	{
//		this.isCooledDown = isCooledDown;
//	}
//	
//	public boolean isCooledDown()
//	{
//		return isCooledDown;
//	}
}
