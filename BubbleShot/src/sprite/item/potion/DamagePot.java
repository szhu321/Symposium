package sprite.item.potion;

public class DamagePot extends Potion
{
	DamagePot(String fileName, int xLocation, int yLocation, String itemType, String color, 
			String effect, boolean isCooledDown) 
	{
		super("","file:resource/potionPictures/damagePotion.png", xLocation, yLocation, 
				itemType, color, effect, isCooledDown);
	}

	@Override
	public boolean useItem() 
	{
		return false;
	}
}