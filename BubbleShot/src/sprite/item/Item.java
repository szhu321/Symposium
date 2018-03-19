package sprite.item;

import sprite.Sprite;

public abstract class Item extends Sprite
{
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
