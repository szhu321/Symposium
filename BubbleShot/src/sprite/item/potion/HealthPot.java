package sprite.item.potion;

public class HealthPot extends Potion
{
	public HealthPot(String fileName, int xLocation, int yLocation, String itemType, String color, 
			String effect, boolean isCooledDown) 
	{
		super("","file:resource/potionPictures/healthPotion.png", xLocation, yLocation, 
				itemType, color, effect, isCooledDown);
	}

	@Override
	public boolean useItem() 
	{
		return false;
	}
}
