package sprite.item.weapon;

public class CrossBow extends Weapon
{
	public CrossBow(String fileName, int xLocation, int yLocation, String itemType, 
			boolean isCooledDown, int damage, double attackRate, double attackRange, double coolDownTime) 
	{
		super("","file:resource/weaponPictures/crossbow.png", xLocation, yLocation, itemType, 
				isCooledDown, damage, attackRate, attackRange, coolDownTime);
	}


}
