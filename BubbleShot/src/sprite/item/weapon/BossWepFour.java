package sprite.item.weapon;

import mainGame.GameRunner;
import sprite.character.Character;
import sprite.character.enemy.Enemy;
import sprite.character.player.Player;
import sprite.projectile.LinearProjectile;
import sprite.projectile.Projectile;

public class BossWepFour extends Weapon
{

	private int offsetAngle;
	private int bulletPerShot;
	
	public BossWepFour(String spriteName, double xLocation, double yLocation, 
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
			
			double projectileStartX = (int)(Math.random()*GameRunner.getGameManager().getLevel().getCurrentRoom().getRoomPixWidth());
			double projectileStartY = (int)(Math.random()*GameRunner.getGameManager().getLevel().getCurrentRoom().getRoomPixHeight());
			
			while(numOfBullets > 0)
			{
				numOfBullets--;
				
				Projectile projectile = this.getProjectile().getCopy();
				Character character = getPossessor();
				if(character instanceof Enemy)
					((Enemy)character).getBrain().setFollowPlayer(false);
				double characterCenterX = character.getXLocation() + character.getWidth() / 2;
				double characterCenterY = character.getYLocation() + character.getHeight() / 2;
				
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
			}
			setCooledDown(false);
			//System.out.println("Use Weapon Passed Time : " + (System.nanoTime() - pasttime));
			return true;
		}
		return false;
	}
}
