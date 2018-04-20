package sprite.item.weapon;

public class Fist extends Weapon
{
	public Fist(String fileName, int xLocation, int yLocation, String itemType,
			boolean isCooledDown, int damage, double attackRate, double attackRange, double coolDownTime) 
	{
		super("",fileName, xLocation, yLocation, itemType, isCooledDown, damage, attackRate, 
				attackRange, coolDownTime);
	}
	
}
