package sprite.item;

import map.Room;
import sprite.Sprite;
import sprite.bounds.CircleCollider;
import sprite.character.Character;
import sprite.character.player.Player;

public abstract class Item extends Sprite
{
	public static final String WEAPON = "Weapon";
	public static final String POTION = "Potion";
	public static final String ARMOR = "Armor";
	public static final String SHIELD = "Shield";
	public static final String COIN = "Coin";
	private String itemType;
	private Character possessor;
	private Room currentRoom;
	
	private double itemPickPeriod = 1.2;
	private double lastItemDropTime;
	private int cost;
	//item types: potions and weapons
	
	public Item(String spriteName, String fileName, double xLocation, double yLocation,  double width, double height, String itemType,int cost) 
	{
		super(spriteName, fileName, xLocation, yLocation, width, height, 0);
		this.itemType = itemType;
		this.cost=cost;
	}
	
	public Character getPossessor()
	{
		return possessor;
	}
	
	public boolean isItemPickable()
	{
		if((System.currentTimeMillis() - lastItemDropTime) / 1000 > itemPickPeriod)
			return true;
		return false;
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
		lastItemDropTime = System.currentTimeMillis();
	}
	
	public void setPossessor(Character possessor)
	{
		this.possessor = possessor;
	}
	
	public String getItemType()
	{
		return itemType;
	}
	
	public CircleCollider getCircleBoundsOfObject()
	{
		return new CircleCollider(getXCenter(), getYCenter(), 7);
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
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
