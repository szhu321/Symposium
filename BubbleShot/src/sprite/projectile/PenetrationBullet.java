package sprite.projectile;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import sprite.character.Character;

public class PenetrationBullet extends LinearProjectile
{
	private int penetrationCount;
	private List<Character> peneCharacters;
	private Character currentPeneCharacter;
	
	public PenetrationBullet(String spriteName, String fileName, String bulletOwner, double xLocation, double yLocation,
			double width, double height, double speed, double faceAngle, double damage, double range, int penetrationCount)
	{
		super(spriteName, fileName, bulletOwner, xLocation, yLocation, width, height, speed, faceAngle, damage, range);
		this.penetrationCount = penetrationCount;
		currentPeneCharacter = null;
		peneCharacters = new ArrayList<Character>();
		createTravelPath(xLocation, yLocation, faceAngle, speed);
	}

	public PenetrationBullet(String spriteName, Image image,String bulletOwner, double xLocation, double yLocation, double width, double height, double speed, double faceAngle, double damage, double range, int penetrationCount)
	{
		super(spriteName, image, bulletOwner, xLocation, yLocation, width, height, speed, faceAngle, damage, range);
		this.penetrationCount = penetrationCount;
		currentPeneCharacter = null;
		peneCharacters = new ArrayList<Character>();
		createTravelPath(xLocation, yLocation, faceAngle, speed);
	}
	
	public Projectile getCopy()
	{
		Projectile projectile = new PenetrationBullet(getSpriteName(), getSpriteImage(), getBulletOwner(), getXLocation(), getYLocation(), getWidth(), getHeight(), getSpeed(), getFaceAngle(), getDamage(), getRange(), getPenetraionCount());
		projectile.setSpriteFileName(getSpriteFileName());
		return projectile;
	}
	
	public boolean isDown(Character peneChar)
	{
		if(peneChar == null)
			currentPeneCharacter = null;
		else if(currentPeneCharacter == null)
		{
			currentPeneCharacter = peneChar;
			peneCharacters.add(peneChar);
			penetrationCount--;
		}
		else if(currentPeneCharacter != peneChar)
		{
			if(!peneCharacters.contains(peneChar))
			{
				peneCharacters.add(peneChar);
				penetrationCount--;
			}
			currentPeneCharacter = peneChar;
		}
		if(penetrationCount <= 0)
			return true;
		return false;
	}
	
	public void setPenetrationCount(int penetrationCount)
	{
		this.penetrationCount = penetrationCount;
	}
	
	public int getPenetraionCount() 
	{
		return penetrationCount;
	}
}
