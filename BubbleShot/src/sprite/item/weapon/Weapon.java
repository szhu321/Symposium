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
	
	
	
	public Projectile getProjectile() 
	{
		return projectile;
	}

	public void setProjectile(Projectile projectile) 
	{
		this.projectile = projectile;
	}

	public String toString()
	{
		String output = this.toString();
		output += "Weapon Damage = " + weaponDmg + "\n";
		output += "Weapon Attack Rate = " + getDefaultCoolDownTime() + "\n";
		output += "Weapon Attack Range = " + weaponAttackRange + "\n";
		return output;
	}
	
	public boolean useItem()
	{
		if(isCooledDown())
		{
			//long pasttime = System.nanoTime();
			//Creating a copy of the weapon's projectile;
			Projectile projectile = this.projectile.getCopy();
			Character character = getPossessor();
			double characterCenterX = character.getXLocation() + character.getWidth() / 2;
			double characterCenterY = character.getYLocation() + character.getHeight() / 2;
			double projectileStartX = (characterCenterX - projectile.getWidth() / 2) + (Math.cos(Math.toRadians(character.getFaceAngle())) * character.getWidth());
			double projectileStartY = (characterCenterY - projectile.getHeight() / 2) + (Math.sin(Math.toRadians(character.getFaceAngle())) * character.getHeight());
			if(character instanceof Player)
				projectile.setBulletOwner(Projectile.SHOT_BY_PLAYER);
			if(character instanceof Enemy)
				projectile.setBulletOwner(Projectile.SHOT_BY_ENEMY);
			((LinearProjectile)projectile).createTravelPath(projectileStartX, projectileStartY, character.getFaceAngle(), projectile.getSpeed());
			projectile.setFaceAngle(character.getFaceAngle());
			projectile.setXLocation(projectileStartX);
			projectile.setYLocation(projectileStartY);
			projectile.setDamage(projectile.getDamage() * character.getEffectManager().getDamageMultiplier());
			
			//Adding the newly created projectile.
			GameRunner.getGameManager().addProjectile(projectile);
			setCurrentCoolDownTime(getDefaultCoolDownTime());
			setCooledDown(false);
			//System.out.println("Use Weapon Passed Time : " + (System.nanoTime() - pasttime));
			return true;
		}
		return false;
	}
}
