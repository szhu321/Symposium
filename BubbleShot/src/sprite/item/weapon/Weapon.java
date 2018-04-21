package sprite.item.weapon;

import sprite.item.Item;
import sprite.projectile.Projectile;

public abstract class Weapon extends Item
{
	private int weaponDmg;
	private double weaponAttackRange;
	private Projectile projectile;
	
	public Weapon(String spriteName,String fileName, int xLocation, int yLocation, String itemType, 
			boolean isCooledDown, int damage, double attackRate, double attackRange, double coolDownTime, Projectile projectile) 
	{
		super(spriteName,fileName, xLocation, yLocation, itemType, isCooledDown, coolDownTime);
		weaponDmg = damage;
		weaponAttackRange = attackRange;
		this.projectile = projectile;
		this.projectile.setRange(weaponAttackRange);
	}
	
	public int getDamage()
	{
		return weaponDmg;
	}
	
	public double getAttackRange()
	{
		return weaponAttackRange;
	}
	
	public String toString()
	{
		String output = this.toString();
		output += "Weapon Damage = " + weaponDmg + "\n";
		output += "Weapon Attack Rate = " + getDefaultCoolDownTime() + "\n";
		output += "Weapon Attack Range = " + weaponAttackRange + "\n";
		return output;
	}
	
	public void useItem()
	{
		
	}
}
