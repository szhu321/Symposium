package sprite.item;

import sprite.Sprite;

public abstract class Item extends Sprite implements Consumable
{
	public static final String WEAPON = "weapon";
	public static final String POTION = "potion";
	private String itemType;
	private boolean isCooledDown;
	private double currentCoolDownTime;
	private double defaultCoolDownTime;
	//item types: potions and weapons
	
	public Item(String spriteName, String fileName, double xLocation, double yLocation, String itemType, boolean isCooledDown, double coolDownTime) 
	{
		super(spriteName,fileName, xLocation, yLocation, 60.0, 60.0, 0);
		this.itemType = itemType;
		this.isCooledDown = isCooledDown;
		currentCoolDownTime = coolDownTime;
		defaultCoolDownTime = coolDownTime;
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
