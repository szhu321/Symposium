package sprite.item.weapon;

public class Sword extends Weapon
{
	Sword(String fileName, int xLocation, int yLocation, String itemType, 
			boolean isCooledDown, int damage, double attackRate, double attackRange) 
	{
		super("file:resource/weaponPictures/sword.png", xLocation, yLocation, itemType, 
				isCooledDown, damage, attackRate, attackRange);
	}

	@Override
	public boolean useItem() 
	{
		return false;
	}
}
