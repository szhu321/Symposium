package sprite.projectile;

import java.util.ArrayList;
import java.util.List;
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
	
	public Projectile getCopy()
	{
		PenetrationBullet pro = (PenetrationBullet) super.getCopy();
		pro.setPenetrationCount(penetrationCount);
		pro.currentPeneCharacter = null;
		pro.peneCharacters = new ArrayList<Character>();
		return pro;
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
