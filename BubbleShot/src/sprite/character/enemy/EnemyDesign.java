package sprite.character.enemy;

import sprite.character.enemy.ai.AI;
import sprite.character.enemy.ai.Astar;
import sprite.character.player.Player;
import sprite.item.weapon.Weapon;
import sprite.item.weapon.WeaponDesign;

public class EnemyDesign
{	
	public static Enemy getRandomDesign(double x, double y, Player player, String type)
	{
		if(type.equals(Enemy.FOLLOWER))
			return EnemyDesign.getRegularDesignOne(x, y, player);
		if(type.equals(Enemy.SMART))
			return EnemyDesign.getSmartDesignOne(x, y, player);
		if(type.equals(Enemy.GHOST))
			return EnemyDesign.getRegularDesignTwo(x, y, player);
		return null;
	}
	
	public static Enemy getRegularDesignOne(double x, double y, Player player)
	{
		String fileName = "file:resources/enemy/enemy.png";
		Weapon pistol=WeaponDesign.getEPistolDesignOne(x, y);
		pistol.setDefaultCoolDownTime(.3);
		Enemy enemy=new Regular("Brian",fileName, x, y,50, 80, 50, 50, pistol,player,Enemy.FOLLOWER);
		return enemy;
	}
	
	public static Enemy getRegularDesignTwo(double x, double y, Player player)
	{
		String fileName = "file:resources/enemy/ghost.png";
		Weapon pistol=WeaponDesign.getEPistolDesignOne(x, y);
		pistol.setDefaultCoolDownTime(.3);
		Enemy enemy=new Ghost("Ghost Brian",fileName, x, y,50, 100, 50, 50, pistol,player,Enemy.GHOST);
		return enemy;
	}
	
	public static Enemy getSmartDesignOne(double x, double y, Player player)
	{
		String fileName = "file:resources/enemy/enemy.png";
		Weapon pistol=WeaponDesign.getEPistolDesignOne(x, y);
		pistol.setDefaultCoolDownTime(.3);
		Enemy enemy=new Smart("Smart Brian",fileName, x, y,50, 130, 50, 50, pistol,player,Enemy.SMART);
		return enemy;
	}
	
	public static Boss getBossDesignOne()
	{
		return null;
	}
}
