package sprite.item.shield;

import sprite.item.Item;

public class ShieldDesign
{	
	public static Shield getShieldDesignOne(double x, double y)
	{
		double rechargeDelay = 5;
		double rechargeRate = 3;
		double shieldAmount = 200;
		return new Shield("Shield", "file:resources/shield/simpleshield.png", x, y, 30, 46, Item.ARMOR, rechargeDelay, rechargeRate, shieldAmount,5);
	}
}
