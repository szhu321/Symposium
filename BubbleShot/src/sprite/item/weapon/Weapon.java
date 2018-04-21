package sprite.item.weapon;

import mainGame.GameRunner;
import sprite.character.enemy.Enemy;
import sprite.character.player.Player;
import sprite.item.Item;
import sprite.projectile.LinearProjectile;
import sprite.projectile.Projectile;
import sprite.character.Character;

public abstract class Weapon extends Item
{
	private double weaponDmg;
	private double weaponAttackRange;
	private Projectile projectile;
	
	public Weapon(String spriteName,String fileName, double xLocation, double yLocation, String itemType, 
			boolean isCooledDown, double damage, double attackRate, double attackRange, Projectile projectile, double width, double height) 
	{
		super(spriteName,fileName, xLocation, yLocation, itemType, isCooledDown, attackRate, width, height);
		weaponDmg = damage;
		weaponAttackRange = attackRange;
		this.projectile = projectile;
		this.projectile.setRange(weaponAttackRange);
		this.projectile.setDamage(weaponDmg);
	}
	
	public double getDamage()
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
		if(isCooledDown())
		{
			Projectile projectile = this.projectile.getCopy();
			Character character = getPossessor();
			if(character instanceof Player)
				projectile.setBulletOwner(Projectile.SHOT_BY_PLAYER);
			if(character instanceof Enemy)
				projectile.setBulletOwner(Projectile.SHOT_BY_ENEMY);
			((LinearProjectile)projectile).createTravelPath(character.getXLocation(), character.getYLocation(), character.getFaceAngle(), projectile.getSpeed());
			projectile.setFaceAngle(character.getFaceAngle());
			projectile.setXLocation(character.getXLocation());
			projectile.setYLocation(character.getYLocation());
			GameRunner.getGameManager().addProjectile(projectile);
			setCurrentCoolDownTime(getDefaultCoolDownTime());
			setCooledDown(false);
		}
	}
}
