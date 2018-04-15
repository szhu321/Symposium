package sprite.item.weapon;

import sprite.item.Item;

public abstract class Weapon extends Item
{
	private int weaponDmg;
	private double weaponAttackRate, weaponAttackRange;
	
	public Weapon(String spriteName,String fileName, int xLocation, int yLocation, String itemType, 
			boolean isCooledDown, int damage, double attackRate, double attackRange) 
	{
		super(spriteName,fileName, xLocation, yLocation, itemType, isCooledDown);
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
	
	public String toString()
	{
		String output = this.toString();
		output += "Weapon Damage = " + weaponDmg + "\n";
		output += "Weapon Attack Rate = " + weaponAttackRate + "\n";
		output += "Weapon Attack Range = " + weaponAttackRange + "\n";
		return output;
	}
}
