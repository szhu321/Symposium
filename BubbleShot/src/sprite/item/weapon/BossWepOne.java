package sprite.item.weapon;

import mainGame.GameRunner;
import sound.SoundEffects;
import sprite.character.Character;
import sprite.character.enemy.Enemy;
import sprite.character.player.Player;
import sprite.projectile.LinearProjectile;
import sprite.projectile.Projectile;

public class BossWepOne extends Weapon
{

	private int offsetAngle;
	private int bulletPerShot;
	
	public BossWepOne(String spriteName, double xLocation, double yLocation, 
			 double damage, double attackRate, double attackRange, Projectile projectile, int offsetAngle, int bulletPerShot, int ammoUsed,int cost) 
	{
		super(spriteName,"file:resources/weaponPictures/shotgun.png", xLocation, yLocation, damage, attackRate, attackRange, projectile,
				100, 27, ammoUsed,cost);
		this.offsetAngle = offsetAngle;
		this.bulletPerShot = bulletPerShot;
	}
	
	public boolean useItem()
	{
		if(isCooledDown())
		{
			//long pasttime = System.nanoTime();
			//Creating a copy of the weapon's projectile;
			int numOfBullets = bulletPerShot;
			while(numOfBullets > 0)
			{
				numOfBullets--;
				
				Projectile projectile = this.getProjectile().getCopy();
				Character character = getPossessor();
				((Enemy)character).getBrain().setFollowPlayer(true);
				double characterCenterX = character.getXLocation() + character.getWidth() / 2;
				double characterCenterY = character.getYLocation() + character.getHeight() / 2;
				double projectileStartX = characterCenterX ;
				double projectileStartY = characterCenterY ;
				
				int flip = (int)(Math.random() * 3);
				int angleOffset = (int)(offsetAngle);
				double faceAngle=0;
				if(flip == 0)
					faceAngle = character.getFaceAngle() + angleOffset;
				if(flip == 1)
					faceAngle = character.getFaceAngle() - angleOffset;
				if(flip == 2)
					faceAngle = character.getFaceAngle() - angleOffset+120;
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
				SoundEffects.PEW_PEW_SOUND.playSound();
				//Adding the newly created projectile.
				GameRunner.getGameManager().addProjectile(projectile);
			}
			setCooledDown(false);
			//System.out.println("Use Weapon Passed Time : " + (System.nanoTime() - pasttime));
			return true;
		}
		return false;
	}
}
