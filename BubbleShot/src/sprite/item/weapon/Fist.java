package sprite.item.weapon;

public class Fist extends Weapon
{
	public Fist(String fileName, int xLocation, int yLocation, String itemType,
			boolean isCooledDown, int damage, double attackRate, double attackRange) 
	{
		super("",fileName, xLocation, yLocation, itemType, isCooledDown, damage, attackRate, 
				attackRange);
	}
	
	public Fist()
	{
		this("",0,0,"", false, 0, 0, 0);
	}
	
	@Override
	public boolean useItem()
	{
		return false;
	}
}
