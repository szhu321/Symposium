package sprite.item.shield;

import sprite.item.Item;

public class ShieldDesign
{	
	public static Shield getShieldDesignOne(double x, double y)
	{
		double rechargeDelay = 3;
		double rechargeRate = 2;
		double shieldAmount = 300;
		return new Shield("Shield", "file:resources/shield/simpleshield.png", x, y, 30, 46, Item.ARMOR, rechargeDelay, rechargeRate, shieldAmount);
	}
}
