package sprite.item.weapon;

public class Pistol extends Weapon
{
	public Pistol(String fileName, int xLocation, int yLocation, String itemType, 
			boolean isCooledDown, int damage, double attackRate, double attackRange, double coolDownTime) 
	{
		super("","file:resource/weaponPictures/pistol.png", xLocation, yLocation, itemType, 
				isCooledDown, damage, attackRate, attackRange, coolDownTime);
	}


}
