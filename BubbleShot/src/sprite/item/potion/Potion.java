package sprite.item.potion;

import sprite.item.Item;

public abstract class Potion extends Item
{
	private String effect;
	private String color;
	
	Potion(String fileName, int xLocation, int yLocation, String itemType, String color, String 
			effect) 
	{
		super(fileName, xLocation, yLocation, itemType);
		this.color = color;
		this.effect = effect;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public String getEffect()
	{
		return effect;
	}
}
