package sprite.item.weapon;

import mainGame.GameRunner;
import sprite.character.Character;
import sprite.character.enemy.Enemy;
import sprite.character.player.Player;
import sprite.projectile.LinearProjectile;
import sprite.projectile.Projectile;

public class AssaultRifle extends Weapon
{
	private int offsetAngle;
	
	public AssaultRifle(String spriteName, double xLocation, double yLocation,
			 double damage, double attackRate, double attackRange, Projectile projectile, int offsetAngle, int ammoUsed,int cost) 
	{
		super(spriteName,"file:resources/weaponPictures/assaultrifle.png", xLocation, yLocation, damage, attackRate, attackRange, projectile,
				100, 27, ammoUsed,cost);
		this.offsetAngle = offsetAngle;
	}
	
	public boolean useItem()
	{
		if(isCooledDown())
		{
			Projectile projectile = this.getProjectile().getCopy();
			Character character = getPossessor();
			double characterCenterX = character.getXLocation() + character.getWidth() / 2;
			double characterCenterY = character.getYLocation() + character.getHeight() / 2;
			double projectileStartX = (characterCenterX - projectile.getWidth() / 2) + (Math.cos(Math.toRadians(character.getFaceAngle())) * character.getWidth());
			double projectileStartY = (characterCenterY - projectile.getHeight() / 2) + (Math.sin(Math.toRadians(character.getFaceAngle())) * character.getHeight());
			
			int flip = (int)(Math.random() * 2);
			int angleOffset = (int)(Math.random() * offsetAngle);
			double faceAngle;
			if(flip == 0)
				faceAngle = character.getFaceAngle() + angleOffset;
			else
				faceAngle = character.getFaceAngle() - angleOffset;
			if(faceAngle > 360)
				faceAngle = faceAngle % 360;
			if(faceAngle < 0)
				faceAngle += 360;
			
				
			if(character instanceof Player)
				projectile.setBulletOwner(Projectile.SHOT_BY_PLAYER);
			if(character instanceof Enemy)
				projectile.setBulletOwner(Projectile.SHOT_BY_ENEMY);
			((LinearProjectile)projectile).createTravelPath(projectileStartX, projectileStartY, faceAngle, projectile.getSpeed());
			projectile.setFaceAngle(faceAngle);
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
}
