package sprite.item.potion;

public class SpeedPot extends Potion
{
	public SpeedPot(String fileName, double xLocation, double yLocation, String itemType, String color, 
			String effect, boolean isCooledDown) 
	{
		super("","file:resources/potionPictures/speedPotion.png", xLocation, yLocation, itemType, color, effect, isCooledDown);
	}

	@Override
	public boolean useItem() 
	{
		return false;
	}
}
