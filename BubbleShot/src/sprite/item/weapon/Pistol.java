package sprite.item.weapon;

public class Pistol extends Weapon
{
	Pistol(String fileName, int xLocation, int yLocation, String itemType, 
			boolean isCooledDown, int damage, double attackRate, double attackRange) 
	{
		super("","file:resource/weaponPictures/pistol.png", xLocation, yLocation, itemType, 
				isCooledDown, damage, attackRate, attackRange);
	}

	@Override
	public boolean useItem() 
	{
		return false;
	}
}
