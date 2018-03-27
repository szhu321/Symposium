package sprite.item.potion;

public class HealthPot extends Potion
{
	HealthPot(String fileName, int xLocation, int yLocation, String itemType, String color, 
			String effect, boolean isCooledDown) 
	{
		super(fileName, xLocation, yLocation, itemType, color, effect, isCooledDown);
	}

	@Override
	public boolean useItem() 
	{
		return false;
	}
}
