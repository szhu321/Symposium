package sprite.item.potion;

public class HealthPot extends Potion
{

	HealthPot(String fileName, int xLocation, int yLocation, String itemType, String color, 
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
