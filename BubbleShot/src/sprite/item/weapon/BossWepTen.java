package sprite.item.weapon;

import mainGame.GameRunner;
import map.Room;
import map.Tile.Tile;
import sound.SoundEffects;
import sprite.character.Character;
import sprite.character.enemy.Enemy;
import sprite.character.player.Player;
import sprite.projectile.LinearProjectile;
import sprite.projectile.Projectile;

public class BossWepTen extends Weapon
{

	private int offsetAngle;
	private int bulletPerShot;
	private int rangeMin;
	private int rangeMax;
	
	public BossWepTen(String spriteName, double xLocation, double yLocation, 
			 double damage, double attackRate, double attackRange, Projectile projectile, int offsetAngle, int bulletPerShot, int ammoUsed,int cost) 
	{
		super(spriteName,"file:resources/weaponPictures/shotgun.png", xLocation, yLocation, damage, attackRate, attackRange, projectile,
				100, 27, ammoUsed,cost);
		this.offsetAngle = offsetAngle;
		this.bulletPerShot = bulletPerShot;
		this.rangeMax=0;
		this.rangeMin=0;
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
			//	System.out.println(character.getSpriteName());
				Room currentRoom=GameRunner.getGameManager().getLevel().getCurrentRoom();
				Tile[][] allTiles=currentRoom.getTiles();
				double characterCenterX = character.getXLocation() + character.getWidth() / 2;
				double characterCenterY = character.getYLocation() + character.getHeight() / 2;
				double projectileStartX = 0;
				double projectileStartY = 0;
				int flip =(int)(Math.random()*4);
				double faceAngle=0;
				if(flip==0)
				{
					double test=(Math.random()*(allTiles[0].length-2))+1;
					projectileStartX=test*100;
					projectileStartY=100;
					faceAngle=90;
				}
				if(flip==1)
				{
					projectileStartY=100*((Math.random()*(allTiles.length-2))+1);
					projectileStartX=currentRoom.getRoomPixWidth()-120;
					faceAngle=180;
				}
				if(flip==2)
				{
					projectileStartY=currentRoom.getRoomPixHeight()-120;
					projectileStartX=100*((Math.random()*(allTiles.length-2))+1);
					faceAngle=270;
				}
				if(flip==3)
				{
					projectileStartY=100*((Math.random()*(allTiles.length-2))+1);
					projectileStartX=100;
					faceAngle=0;
				}
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
				
				setCooledDown(false);
			}
			//System.out.println("Use Weapon Passed Time : " + (System.nanoTime() - pasttime));
			return true;
		}
		return false;
	}
}
