package sprite.item;

import sprite.Sprite;

public abstract class Item extends Sprite implements Consumable
{
	public static final String WEAPON = "weapon";
	public static final String POTION = "potion";
	private String itemType;
	private boolean isCooledDown;
	//item types: potions and weapons
	
	protected Item(String fileName, int xLocation, int yLocation, String itemType, boolean 
			isCooledDown) 
	{
		super(fileName, xLocation, yLocation, 60.0, 60.0);
		this.itemType = itemType;
		this.isCooledDown = isCooledDown;
	}
	
	public String getItemType()
	{
		return itemType;
	}
}
