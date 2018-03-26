package sprite.item.weapon;

import sprite.item.Item;

public class Fist extends Item
{

	public Fist(String fileName, int xLocation, int yLocation, String itemType)
	{
		super(fileName, xLocation, yLocation, itemType);
		
	}
	
	public Fist()
	{
		this("",0,0,"");
	}
	
	@Override
	public boolean useItem()
	{
		
		return false;
	}

}
