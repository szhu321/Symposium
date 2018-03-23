package sprite.item;

import sprite.Sprite;

public abstract class Item extends Sprite implements Consumable
{
	public static final String WEAPON = "weapon";
	public static final String POTION = "potion";
	private String itemType;
	//item types: potions and weapons
	
	protected Item(String fileName, int xLocation, int yLocation, String itemType) 
	{
		super(fileName, xLocation, yLocation);
		this.itemType = itemType;
	}
	
	public String getItemType()
	{
		return itemType;
	}
}
