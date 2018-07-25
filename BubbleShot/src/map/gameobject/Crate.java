package map.gameobject;

import sprite.item.Item;

public class Crate extends BreakableObject
{
	private Item[] loot;
	
	public Crate(String spriteName, String fileName, double xLocation, double yLocation, double width, double height,
			double faceAngle, double hitpoints, Item[] loot) 
	{
		super(spriteName, fileName, xLocation, yLocation, width, height, faceAngle, hitpoints);
		this.loot = loot;
	}
	
	public Item[] getLoot()
	{
		return loot;
	}
}
