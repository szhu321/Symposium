package sprite.item.armor;

import sprite.item.Item;

public class Legging extends Armor
{

	public Legging(String spriteName, String fileName, double xLocation, double yLocation, 
			double width, double height, double maxHealthBoost,
			double maxSpeedBoost, double maxDamageBoost, double armorPoints,int cost) 
	{
		super(spriteName, fileName, xLocation, yLocation,width, height, Item.ARMOR, maxHealthBoost,
				maxSpeedBoost, maxDamageBoost, armorPoints,cost);
	}
	
}
