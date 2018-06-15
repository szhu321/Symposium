package sprite.item.weapon;

import mainGame.GameRunner;
import sprite.character.enemy.Enemy;
import sprite.character.player.Player;
import sprite.item.Item;
import sprite.projectile.LinearProjectile;
import sprite.projectile.PenetrationBullet;
import sprite.projectile.Projectile;
import sprite.character.Character;

public abstract class Weapon extends Item
{
	private static final long serialVersionUID = -5855881898898826251L;
	
	private double weaponDmg;
	private double weaponAttackRange;
	private Projectile projectile;
	private int ammoUsed;
	private boolean isCooledDown;
	private double currentCoolDownTime;
	private double defaultCoolDownTime;
	private boolean isAutomatic;
	
	public Weapon(String spriteName,String fileName, double xLocation, double yLocation, 
			 double damage, double attackRate, double attackRange, Projectile projectile, double width, double height, int ammoUsed,int cost) 
	{
		super(spriteName ,fileName, xLocation, yLocation, width, height, Item.WEAPON,cost);
		weaponDmg = damage;
		weaponAttackRange = attackRange;
		this.projectile = projectile;
		this.projectile.setRange(weaponAttackRange);
		this.projectile.setDamage(weaponDmg);
		this.ammoUsed = ammoUsed;
		this.currentCoolDownTime = attackRate;
		this.defaultCoolDownTime = attackRate;
		this.isCooledDown = true;
		isAutomatic = false;
	}
	
	public void reloadObject()
	{
		super.reloadObject();
		projectile.reloadObject();
	}
	
	public boolean isCooledDown()
	{
		return isCooledDown;
	}

	public double getCurrentCoolDownTime() 
	{
		return currentCoolDownTime;
	}

	public double getDefaultCoolDownTime()
	{
		return defaultCoolDownTime;
	}

	public void setCooledDown(boolean isCooledDown) 
	{
		if(!isCooledDown)
			currentCoolDownTime = defaultCoolDownTime;
		this.isCooledDown = isCooledDown;
	}

	public void setCurrentCoolDownTime(double currentCoolDownTime) 
	{
		this.currentCoolDownTime = currentCoolDownTime;
	}

	public void setDefaultCoolDownTime(double defaultCoolDownTime) 
	{
		this.defaultCoolDownTime = defaultCoolDownTime;
	}

	public double getDamage()
	{
		if(getPossessor() instanceof Player)
			return weaponDmg * ((Player) getPossessor()).getDamageBoost() * getPossessor().getEffectManager().getDamageMultiplier();
		else
			return weaponDmg * getPossessor().getEffectManager().getDamageMultiplier();
	}
	
	public int getAmmoUsed() 
	{
		return ammoUsed;
	}

	public void setAmmoUsed(int ammoUsed) 
	{
		this.ammoUsed = ammoUsed;
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

	public void coolDownItem(double sec)
	{
		currentCoolDownTime -= sec;
		if(currentCoolDownTime <= 0)
			isCooledDown = true;
	}
	
	public String description()
	{
		String output = "";
		output += getSpriteName() + "\n"+"\n";
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
			projectile.setDamage(getDamage());
			//Adding the newly created projectile.
			GameRunner.getGameManager().addProjectile(projectile);
			setCooledDown(false);
			//System.out.println("Use Weapon Passed Time : " + (System.nanoTime() - pasttime));
			return true;
		}
		return false;
	}

	public boolean isAutomatic()
	{
		return isAutomatic;
	}

	public void setAutomatic(boolean isAutomatic)
	{
		this.isAutomatic = isAutomatic;
	}
}
