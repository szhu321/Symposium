package sprite.item.armor;

import sprite.item.Item;

public class Armor extends Item 
{
	private double maxHealthBoost;
	private double maxSpeedBoost;
	private double maxDamageBoost;
	
	public Armor(String spriteName, String fileName, double xLocation, double yLocation, 
			double width, double height, String itemType, double maxHealthBoost, double maxSpeedBoost, double maxDamageBoost) 
	{
		super(spriteName, fileName, xLocation, yLocation, width, height, Item.ARMOR);
		this.maxHealthBoost = maxHealthBoost;
		this.maxDamageBoost = maxDamageBoost;
		this.maxSpeedBoost = maxSpeedBoost;
	}

	public double getMaxHealthBoost() 
	{
		return maxHealthBoost;
	}

	public double getMaxSpeedBoost() 
	{
		return maxSpeedBoost;
	}

	public double getMaxDamageBoost()
	{
		return maxDamageBoost;
	}
}
