package sprite.character.enemy;

import sprite.character.enemy.ai.AI;
import sprite.character.enemy.ai.Astar;
import sprite.character.player.Player;
import sprite.item.weapon.Weapon;
import sprite.item.weapon.WeaponDesign;

public class EnemyDesign
{
	public static final String FOLLOWER="follower";
	public static final String SMART="smart";
	public static final String GHOST="ghost";
	public static final String MELEE="melee";
	public static final String MACHINEGUN="machinegun";
	public static final String TOWER="tower";
	
	public static Enemy getRandomDesign(double x, double y, Player player, String type)
	{
		if(type.equals(EnemyDesign.FOLLOWER))
			return EnemyDesign.getRegularDesignOne(x, y, player);
		if(type.equals(EnemyDesign.SMART))
			return EnemyDesign.getSmartDesignOne(x, y, player);
		return null;
	}
	
	
	public static Enemy getRegularDesignOne(double x, double y, Player player)
	{
		String fileName = "file:resources/enemy/enemy.png";
		Weapon pistol=WeaponDesign.getEPistolDesignOne(x, y);
		pistol.setDefaultCoolDownTime(.3);
		Enemy enemy=new Regular("Brian",fileName, x, y,50, 80, 50, 50, pistol,player);
		return enemy;
	}
	
	public static Enemy getSmartDesignOne(double x, double y, Player player)
	{
		String fileName = "file:resources/enemy/enemy.png";
		Weapon pistol=WeaponDesign.getEPistolDesignOne(x, y);
		pistol.setDefaultCoolDownTime(.3);
		Enemy enemy=new Smart("Smart Brian",fileName, x, y,50, 160, 50, 50, pistol,player);
		return enemy;
	}
	
	public static Boss getBossDesignOne()
	{
		return null;
	}
}
