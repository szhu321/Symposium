package sprite.item.weapon;

public class CrossBow extends Weapon
{
	CrossBow(String fileName, int xLocation, int yLocation, String itemType, 
			boolean isCooledDown, int damage, double attackRate, double attackRange) 
	{
		super("","file:resource/weaponPictures/crossbow.png", xLocation, yLocation, itemType, 
				isCooledDown, damage, attackRate, attackRange);
	}

	@Override
	public boolean useItem() 
	{
		return false;
	}
}
