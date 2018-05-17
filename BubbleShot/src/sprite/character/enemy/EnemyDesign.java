package sprite.character.enemy;

import sprite.character.enemy.ai.AI;
import sprite.character.enemy.ai.Astar;
import sprite.character.player.Player;
import sprite.item.weapon.Weapon;
import sprite.item.weapon.WeaponDesign;

public class EnemyDesign
{	
	public static Enemy getRandomDesign(double x, double y, Player player, int num)
	{
		if(num==1)
			return EnemyDesign.getRegularDesignOne(x, y, player);
		if(num==2)
			return EnemyDesign.getSmartDesignOne(x, y, player);
		if(num==3)
			return EnemyDesign.getRegularDesignTwo(x, y, player);
		if(num==4)
			return EnemyDesign.getSwordDesignOne(x, y, player);
		if(num==5)
			return EnemyDesign.getTurrentDesignOne(x, y, player);
		if(num==6)
			return EnemyDesign.getBaseDesignOne(x, y, player);
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
	
	public static Enemy getSwordDesignOne(double x, double y, Player player)
	{
		String fileName = "file:resources/enemy/enemy.png";
		Weapon sword=WeaponDesign.getSwordDesignOne(x, y);
		sword.setDefaultCoolDownTime(.8);
		Enemy enemy=new Swordsman("Sword Brian",fileName, x, y,50, 130, 50, 50, sword,player,Enemy.MELEE);
		return enemy;
	}
	
	public static Enemy getTurrentDesignOne(double x, double y, Player player)
	{
		String fileName = "file:resources/enemy/turret.png";
		Weapon rifle=WeaponDesign.getAssaultRifleDesignOne(x, y);
		rifle.setDefaultCoolDownTime(.8);
		Enemy enemy=new Turrent("Turrent Brian",fileName, x, y,50, 130, 50, 50, rifle,player,Enemy.TOWER);
		return enemy;
	}
	
	public static Enemy getBaseDesignOne(double x, double y, Player player)
	{
		String fileName = "file:resources/enemy/enemy3.png";
		Weapon rifle=WeaponDesign.getAssaultRifleDesignOne(x, y);
		rifle.setDefaultCoolDownTime(.8);
		Enemy enemy=new Spawner("Tower Brian",fileName, x, y,250, 130, 50, 50, rifle,player,Enemy.BASE);
		return enemy;
	}
	
	public static Boss getBossDesignOne()
	{
		return null;
	}
}
