package sprite.character.enemy;


import java.util.List;

import sprite.character.enemy.ai.AI;
import sprite.character.enemy.ai.Astar;
import sprite.character.player.Player;
import sprite.item.weapon.BossAttacks;
import sprite.item.weapon.Weapon;
import sprite.item.weapon.WeaponDesign;

public class EnemyDesign
{	
	public static Enemy getRandomDesign(double x, double y, Player player, String type,int levelNum)
	{
		if(type.equals(Enemy.FOLLOWER))
			return EnemyDesign.getRegularDesignOne(x, y, player,levelNum);
		if(type.equals(Enemy.SMART))
			return EnemyDesign.getSmartDesignOne(x, y, player,levelNum);
		if(type.equals(Enemy.GHOST))
			return EnemyDesign.getRegularDesignTwo(x, y, player,levelNum);
		if(type.equals(Enemy.SWORD))
			return EnemyDesign.getSwordDesignOne(x, y, player,levelNum);
		return null;
	}
	
	public static Enemy getRandomDesign(double x, double y, Player player, int num,int levelNum)
	{
		if(num==1)
			return EnemyDesign.getRegularDesignOne(x, y, player,levelNum);
		if(num==2)
			return EnemyDesign.getSmartDesignOne(x, y, player,levelNum);
		if(num==3)
			return EnemyDesign.getRegularDesignTwo(x, y, player,levelNum);
		if(num==4)
			return EnemyDesign.getSwordDesignOne(x, y, player,levelNum);
		if(num==5)
			return EnemyDesign.getTurrentDesignOne(x, y, player,levelNum);
		if(num==6)
			return EnemyDesign.getBaseDesignOne(x, y, player,levelNum);
		if(num==7)
			return EnemyDesign.getBaseDesignTwo(x, y, player,levelNum);
		return null;
	}
	
	public static Enemy getRegularDesignOne(double x, double y, Player player,int levelNum)
	{
		int health=50+(levelNum-1)*50;
		String fileName = "file:resources/enemy/enemy.png";
		Weapon pistol=WeaponDesign.getEPistolDesignOne(x, y,levelNum);
		pistol.setDefaultCoolDownTime(.3);
		Enemy enemy=new Regular("Brian",fileName, x, y,health, 80, 50, 50, pistol,player,Enemy.FOLLOWER);
		return enemy;
	}
	
	public static Enemy getRegularDesignTwo(double x, double y, Player player,int levelNum)
	{
		int health=50+(levelNum-1)*50;
		String fileName = "file:resources/enemy/ghost.png";
		Weapon pistol=WeaponDesign.getEPistolDesignOne(x, y,levelNum);
		pistol.setDefaultCoolDownTime(.3);
		Enemy enemy=new Ghost("Ghost Brian",fileName, x, y,health, 100, 50, 50, pistol,player,Enemy.GHOST);
		return enemy;
	}
	
	public static Enemy getSmartDesignOne(double x, double y, Player player,int levelNum)
	{
		int health=50+(levelNum-1)*50;
		String fileName = "file:resources/enemy/enemy.png";
		Weapon pistol=WeaponDesign.getEPistolDesignOne(x, y,levelNum);
		pistol.setDefaultCoolDownTime(.3);
		Enemy enemy=new Smart("Soviet Brian",fileName, x, y,health, 130, 50, 50, pistol,player,Enemy.SMART);
		return enemy;
	}
	
	public static Enemy getSwordDesignOne(double x, double y, Player player,int levelNum)
	{
		int health=100+(levelNum-1)*50;
		String fileName = "file:resources/enemy/enemy.png";
		Weapon sword=WeaponDesign.getSwordDesignOne(x, y,levelNum);
		sword.setDefaultCoolDownTime(.8);
		Enemy enemy=new Swordsman("Sword Brian",fileName, x, y,health, 130, 50, 50, sword,player,Enemy.MELEE);
		return enemy;
	}
	
	public static Enemy getTurrentDesignOne(double x, double y, Player player,int levelNum)
	{
		int health=200+(levelNum-1)*50;
		String fileName = "file:resources/enemy/turret.png";
		Weapon rifle=WeaponDesign.getEAssaultRifleDesignOne(x, y,levelNum);
		rifle.setDefaultCoolDownTime(.8);
		Enemy enemy=new Turrent("Turrent Brian",fileName, x, y,health, 130, 50, 50, rifle,player,Enemy.TOWER);
		return enemy;
	}
	
	public static Enemy getBaseDesignOne(double x, double y, Player player,int levelNum)
	{
		int health=100+(levelNum-1)*50;
		String fileName = "file:resources/enemy/enemy3.png";
		Weapon rifle=WeaponDesign.getEAssaultRifleDesignOne(x, y,levelNum);
		rifle.setDefaultCoolDownTime(.8);
		Enemy enemy=new Spawner("Spawner1 Brian",fileName, x, y,health, 130, 50, 50, rifle,player,Enemy.SPAWNER1);
		return enemy;
	}
	
	public static Enemy getBaseDesignTwo(double x, double y, Player player,int levelNum)
	{
		int health=100+(levelNum-1)*50;
		String fileName = "file:resources/enemy/enemy3.png";
		Weapon rifle=WeaponDesign.getEAssaultRifleDesignOne(x, y,levelNum);
		rifle.setDefaultCoolDownTime(.8);
		String randomEnemy="";
		int chooser=0;
		chooser=(int)(Math.random()*4)+1;
		if(chooser==1)
			randomEnemy=Enemy.FOLLOWER;
		if(chooser==2)
			randomEnemy=Enemy.SMART;
		if(chooser==3)
			randomEnemy=Enemy.GHOST;
		if(chooser==4)
			randomEnemy=Enemy.SWORD;
		Enemy enemy=new Spawner("Spawner2 Brian",fileName, x, y,health, 130, 50, 50, rifle,player,Enemy.SPAWNER2,randomEnemy);
		return enemy;
	}
	
	public static Boss getBossDesignOne(double x, double y, Player player,int levelNum)
	{
		int health=1000+(levelNum-1)*1000;
		String fileName = "file:resources/enemy/robo.png";
		List<Weapon> weps=BossAttacks.getBossOneAtkPattern(x, y,levelNum);
		Boss boss=new RobotBoss("ROBOTBOSS",fileName, x, y,health, 100, 100, 100, weps.get(0),player,Enemy.ROBOTBOSS,weps);
		for(Weapon w:weps)
			w.setPossessor(boss);
		boss.setGunVisibility(false);
		return boss;
	}
	
	public static Boss getBossDesignTwo(double x, double y, Player player,int levelNum)
	{
		int health=1000+(levelNum-1)*1000;
		String fileName = "file:resources/enemy/knight.png";
		List<Weapon> weps=BossAttacks.getBossTwoAtkPattern(x, y,levelNum);
		Boss boss=new KnightBoss("KNIGHTBOSS",fileName, x, y,health, 100, 100, 100, weps.get(0),player,Enemy.ROBOTBOSS,weps);
		for(Weapon w:weps)
			w.setPossessor(boss);
		boss.setGunVisibility(false);
		return boss;
	}
	
	public static Boss getBossDesignThree(double x, double y, Player player,int levelNum)
	{
		String fileName = "file:resources/enemy/wizard.png";
		int health=1000+(levelNum-1)*1000;
		List<Weapon> weps=BossAttacks.getBossThreeAtkPattern(x, y,levelNum);
		List<Weapon> weps2=BossAttacks.getBossThreeAtkPatternTwo(x, y,levelNum);
		List<Weapon> weps3=BossAttacks.getBossThreeAtkPatternThree(x, y,levelNum);
		Boss boss=new WizardBoss("WIZARDBOSS",fileName, x, y,health, 100, 100, 100, weps.get(0),player,Enemy.ROBOTBOSS,weps,weps2,weps3);
		for(Weapon w:weps)
			w.setPossessor(boss);
		boss.setGunVisibility(false);
		return boss;
	}
}
