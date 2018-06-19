package sprite.item.weapon;

import mainGame.GameRunner;
import sprite.character.Character;
import sprite.character.enemy.Enemy;
import sprite.character.player.Player;
import sprite.projectile.LinearProjectile;
import sprite.projectile.Projectile;

public class BossWepEleven extends Weapon
{

	private int offsetAngle;
	private int bulletPerShot;
	private int amount;
	private int phase;
	
	public BossWepEleven(String spriteName, double xLocation, double yLocation, 
			 double damage, double attackRate, double attackRange, Projectile projectile, int bulletPerShot, int ammoUsed,int cost) 
	{
		super(spriteName,"file:resources/weaponPictures/shotgun.png", xLocation, yLocation, damage, attackRate, attackRange, projectile,
				100, 27, ammoUsed,cost);
		this.bulletPerShot = bulletPerShot;
		amount=0;
		phase=1;
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
				amount++;
				//System.out.println(amount);
				//System.out.println(phase);
				//System.out.println(amount);
				Projectile projectile = this.getProjectile().getCopy();
				Character character = getPossessor();			
				double characterCenterX = character.getXLocation() + character.getWidth() / 2;
				double characterCenterY = character.getYLocation() + character.getHeight() / 2;
				double projectileStartX = characterCenterX;
				double projectileStartY = characterCenterY;
				if(amount%13==0)
				{
					amount=1;
					if(phase==3)
						phase=1;
					else
						phase++;
				}
				//System.out.println(amount);
				int flip = (int)(amount * 30);
				double faceAngle=0;
				if(phase==2)
					faceAngle=6;
				if(phase==3)
					faceAngle=12;
				faceAngle+=flip;
				//System.out.println(faceAngle);
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
