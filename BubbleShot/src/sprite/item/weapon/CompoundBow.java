package sprite.item.weapon;

public class CompoundBow extends Weapon
{
	CompoundBow(String fileName, int xLocation, int yLocation, String itemType, 
			boolean isCooledDown, int damage, double attackRate, double attackRange) 
	{
		super(fileName, xLocation, yLocation, itemType, isCooledDown, damage, attackRate, 
				attackRange);
	}

	@Override
	public boolean useItem() 
	{
		return false;
	}
}
