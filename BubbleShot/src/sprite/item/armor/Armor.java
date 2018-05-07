package sprite.item.armor;

import sprite.item.Item;

public class Armor extends Item 
{
	private double maxHealthBoost;
	private double maxSpeedBoost;
	private double maxDamageBoost;
	
	public Armor(String spriteName, String fileName, double xLocation, double yLocation, String itemType,
			boolean isCooledDown, double coolDownTime, double width, double height, double maxHealthBoost, double maxSpeedBoost, double maxDamageBoost) 
	{
		super(spriteName, fileName, xLocation, yLocation, itemType, isCooledDown, coolDownTime, width, height);
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

	public void setMaxHealthBoost(double maxHealthBoost) 
	{
		this.maxHealthBoost = maxHealthBoost;
	}

	public void setMaxSpeedBoost(double maxSpeedBoost)
	{
		this.maxSpeedBoost = maxSpeedBoost;
	}

	public void setMaxDamageBoost(double maxDamageBoost)
	{
		this.maxDamageBoost = maxDamageBoost;
	}
	
	
}
