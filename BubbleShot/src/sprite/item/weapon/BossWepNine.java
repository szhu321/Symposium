package sprite.item.weapon;

import mainGame.GameRunner;
import sound.SoundEffects;
import sprite.character.Character;
import sprite.character.enemy.Enemy;
import sprite.character.player.Player;
import sprite.projectile.LinearProjectile;
import sprite.projectile.Projectile;

public class BossWepNine extends Weapon
{
	private int offsetAngle;
	private int bulletPerShot;
	private int phase;
	private double left;
	private double right;
	private int bulletCount;
	
	public BossWepNine(String spriteName, double xLocation, double yLocation, 
			 double damage, double attackRate, double attackRange, Projectile projectile, int offsetAngle, int bulletPerShot, int ammoUsed,int cost,double left,double right) 
	{
		super(spriteName,"file:resources/weaponPictures/shotgun.png", xLocation, yLocation, damage, attackRate, attackRange, projectile,
				100, 27, ammoUsed,cost);
		this.offsetAngle = offsetAngle;
		this.bulletPerShot = bulletPerShot;
		phase=1;
		this.left=left;
		this.right=right;
		bulletCount=0;
	}
	
	public boolean useItem()
	{
		if(isCooledDown())
		{
			//long pasttime = System.nanoTime();
			//Creating a copy of the weapon's projectile;
//			System.out.println(min);
//			System.out.println(faceAngle);
//			System.out.println(max);
			int numOfBullets = bulletPerShot;
			while(numOfBullets > 0)
			{
				numOfBullets--;
				bulletCount++;
				if(bulletCount%75==0)
				{
					if(phase==1)
						phase=2;
					else
						if(phase==2)
							phase=1;
				}
				Projectile projectile = this.getProjectile().getCopy();
				Character character = getPossessor();
				double characterCenterX = character.getXLocation() + character.getWidth() / 2;
				double characterCenterY = character.getYLocation() + character.getHeight() / 2;
				double projectileStartX = characterCenterX;
				double projectileStartY = characterCenterY;	
				double faceAngle=0;
				if(phase==1)
				{
					if(bulletCount%2==1)
					{
						left-=.3;
						faceAngle=left;
					}
					 
					if(bulletCount%2==0)
					{
						right+=.3;
						faceAngle=right;
					}
				}
				if(phase==2)
				{
					if(bulletCount%2==1)
					{
						left+=.3;
						faceAngle=left;
					}
					 
					if(bulletCount%2==0)
					{
						right-=.3;
						faceAngle=right;
					}
				}
				if(faceAngle > 360)
					faceAngle = faceAngle % 360;
				if(faceAngle < 0)
					faceAngle += 360;
				
				//	System.out.println(left);
				//	System.out.println(right)
					;
				//	System.out.println(right);
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
