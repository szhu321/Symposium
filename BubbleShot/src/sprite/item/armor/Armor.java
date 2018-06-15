package sprite.item.armor;

import sprite.item.Item;

public class Armor extends Item 
{
	private double maxHealthBoost;
	private double maxSpeedBoost;
	private double maxDamageBoost;
	
	public Armor(String spriteName, String fileName, double xLocation, double yLocation, 
			double width, double height, String itemType, double maxHealthBoost, double maxSpeedBoost, double maxDamageBoost,int cost) 
	{
		super(spriteName, fileName, xLocation, yLocation, width, height, Item.ARMOR,cost);
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

	@Override
	public String description() 
	{
		return this.getSpriteName()+"\n"+"\n"+
			   "Health Boost: "+maxHealthBoost+ "\n"+
			   "Damage Boost: "+maxDamageBoost+ "\n"+
			   "Speed Boost: "+maxSpeedBoost;
	}

}
