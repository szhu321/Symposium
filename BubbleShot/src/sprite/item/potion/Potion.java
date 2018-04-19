package sprite.item.potion;

import sprite.item.Item;

public abstract class Potion extends Item
{
	private String potionColor, potionEffect;
	
	public Potion(String spriteName,String fileName, double xLocation, double yLocation, String itemType, String color, 
			String effect, boolean isCooledDown) 
	{
		super(spriteName,fileName, xLocation, yLocation, itemType, isCooledDown);
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
	
	public String toString()
	{
		String output = "";
		output += "Potion effect: " + potionEffect + "\n";
		return output;
	}
}
