package sprite.item.armor;

import sprite.item.Item;

public class Armor extends Item 
{
	private double shieldAmount;
	private double maxHealthBoost;
	private double maxSpeedBoost;
	private double maxDamageBoost;
	
	public Armor(String spriteName, String fileName, double xLocation, double yLocation, String itemType,
			boolean isCooledDown, double coolDownTime, double width, double height) 
	{
		super(spriteName, fileName, xLocation, yLocation, itemType, isCooledDown, coolDownTime, width, height);
		
	}
}
