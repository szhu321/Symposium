package sprite.item.weapon;

import mainGame.GameRunner;
import sound.SoundEffects;
import sprite.character.Character;
import sprite.character.enemy.Enemy;
import sprite.character.player.Player;
import sprite.projectile.LinearProjectile;
import sprite.projectile.Projectile;

public class BossWepSeven extends Weapon
{
	private double faceAngle;
	private int offsetAngle;
	
	public BossWepSeven(String spriteName, double xLocation, double yLocation, 
			double damage, double attackRate, double attackRange, Projectile projectile, int offsetAngle,int cost) 
	{
		super(spriteName,"file:resources/weaponPictures/sword.png", xLocation, yLocation,  
				 damage, attackRate, attackRange, projectile, 60, 60, 0,cost);
		setAmmoUsed(0);
		this.offsetAngle = offsetAngle;
		faceAngle=0;
	}
	
	public boolean useItem()
	{
		if(isCooledDown())
		{
			
			int numOfBullets = 12;
			while(numOfBullets > 0)
			{
				numOfBullets--;
				Projectile projectile = getProjectile().getCopy();
				Character character = getPossessor();
				if(character instanceof Enemy)
					((Enemy)character).getBrain().setFollowPlayer(false);
				double characterCenterX = character.getXLocation() + character.getWidth() / 2;
				double characterCenterY = character.getYLocation() + character.getHeight() / 2;
				double projectileStartX = characterCenterX;
				double projectileStartY = characterCenterY;
				int flip = (int)(Math.random() * 5);
				double faceAngle=0;
				double angleOffset = (Math.random() * offsetAngle);
				if(flip == 0)
					faceAngle = character.getFaceAngle() + angleOffset;
				if(flip == 1)
					faceAngle = character.getFaceAngle() - angleOffset;
				if(flip == 2)
					faceAngle = character.getFaceAngle() + angleOffset+72;
				if(flip == 3)
				faceAngle = character.getFaceAngle() + angleOffset-72;
				if(flip == 4)
					faceAngle = character.getFaceAngle() - angleOffset-72;
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
				SoundEffects.SWORD_SWING_SOUND.playSound();
				//Adding the newly created projectile.
				GameRunner.getGameManager().addProjectile(projectile);
				setCooledDown(false);
				//System.out.println("Use Weapon Passed Time : " + (System.nanoTime() - pasttime));
				return true;
			}
		}
		return false;
	}

}
