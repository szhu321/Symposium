package sprite.item.weapon;

import mainGame.GameRunner;
import sprite.character.Character;
import sprite.character.enemy.Enemy;
import sprite.character.player.Player;
import sprite.projectile.LinearProjectile;
import sprite.projectile.Projectile;

public class Sword extends Weapon
{
	public Sword(String spriteName, double xLocation, double yLocation, String itemType, 
			boolean isCooledDown, double damage, double attackRate, double attackRange, Projectile projectile) 
	{
		super(spriteName,"file:resources/weaponPictures/sword.png", xLocation, yLocation, itemType, 
				isCooledDown, damage, attackRate, attackRange, projectile, 60, 60, 0);
		setAmmoUsed(0);
	}
	
	public boolean useItem()
	{
		if(isCooledDown())
		{
			//long pasttime = System.nanoTime();
			//Creating a copy of the weapon's projectile;
			Projectile projectile = getProjectile().getCopy();
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
