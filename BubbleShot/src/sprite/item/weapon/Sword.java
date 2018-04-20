package sprite.item.weapon;

public class Sword extends Weapon
{
	public Sword(String fileName, int xLocation, int yLocation, String itemType, 
			boolean isCooledDown, int damage, double attackRate, double attackRange, double coolDownTime) 
	{
		super("","file:resource/weaponPictures/sword.png", xLocation, yLocation, itemType, 
				isCooledDown, damage, attackRate, attackRange, coolDownTime);
	}

}
