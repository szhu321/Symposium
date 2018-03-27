package sprite.item.weapon;

import sprite.item.Item;

public abstract class Weapon extends Item
{
	private int weaponDmg;
	private double weaponAttackRate, weaponAttackRange;
	
	protected Weapon(String fileName, int xLocation, int yLocation, String itemType, 
			boolean isCooledDown, int damage, double attackRate, double attackRange) 
	{
		super(fileName, xLocation, yLocation, itemType, isCooledDown);
		weaponDmg = damage;
		weaponAttackRate = attackRate;
		weaponAttackRange = attackRange;
	}
	
	public int getDamage()
	{
		return weaponDmg;
	}
	
	public double getAttackRange()
	{
		return weaponAttackRange;
	}
	
	public double getAttackRate()
	{
		return weaponAttackRate;
	}
}
