package sprite.character.enemy;

import sprite.character.enemy.ai.AI;
import sprite.character.player.Player;
import sprite.item.weapon.Weapon;
import sprite.item.weapon.WeaponDesign;

public class EnemyDesign
{
	public static final String NORMAL="normal";
	public static final String GHOST="ghost";
	public static final String MELEE="melee";
	public static final String MACHINEGUN="machinegun";
	public static final String TOWER="tower";
	
	//public static getRandomDesign(double x, double y, Player player, int type)
	
	
	public static Enemy getRegularDesignOne(double x, double y, Player player)
	{
		String fileName = "file:resources/enemy/enemy.png";
		Weapon pistol=WeaponDesign.getEPistolDesignOne(x, y);
		pistol.setDefaultCoolDownTime(.3);
		Enemy enemy=new Regular("Brian",fileName, x, y,50, 160, 50, 50, pistol,player);
		return enemy;
	}
	
	public static Boss getBossDesignOne()
	{
		return null;
	}
}
