package sprite.item.potion;

public class SpeedPot extends Potion
{
	SpeedPot(String fileName, int xLocation, int yLocation, String itemType, String color, 
			String effect, boolean isCooledDown) 
	{
		super("","file:resource/potionPictures/speedPotion.png", xLocation, yLocation, 
				itemType, color, effect, isCooledDown);
	}

	@Override
	public boolean useItem() 
	{
		return false;
	}
}
