package sprite.item.potion;

import sprite.item.Item;

public abstract class Potion extends Item
{
	private String potionColor, potionEffect;
	
	Potion(String fileName, int xLocation, int yLocation, String itemType, String color, 
			String effect) 
	{
		super(fileName, xLocation, yLocation, itemType);
		potionColor = color;
		potionEffect = effect;
	}
	
	public String getColor()
	{
		return potionColor;
	}
	
	public String getEffect()
	{
		return potionEffect;
	}
	
	public boolean useItem()
	{
		return false;
	}
}
