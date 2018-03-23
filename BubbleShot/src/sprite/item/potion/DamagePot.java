package sprite.item.potion;

import sprite.item.Consumable;

public class DamagePot extends Potion implements Consumable
{

	DamagePot(String fileName, int xLocation, int yLocation, String itemType, String color, 
			String effect) 
	{
		super(fileName, xLocation, yLocation, itemType, color, effect);
	}

	@Override
	public boolean useItem() 
	{
		return false;
	}
	
	
}