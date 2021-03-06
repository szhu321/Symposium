package sprite.item;

import map.obstacle.Obstacle;
import sprite.character.enemy.Enemy;
import sprite.character.player.Player;
import sprite.item.ammo.AmmoDesign;
import sprite.item.armor.ArmorDesign;
import sprite.item.collectable.CoinDesign;
import sprite.item.potion.PotionDesign;
import sprite.item.shield.ShieldDesign;
import sprite.item.weapon.WeaponDesign;

public class LootGen 
{
	public static Item randomEnemyItem(Enemy enemy,int levelNum) 
	{
		//System.out.println("Enemy Item Level " + levelNum);
		//System.out.println("Current Level " + Player.getCurrentLevel() + "\n");
		int percent=(int)(Math.random()*100)+1;
		if(percent <=20)
			return null;
		else if(percent <=60)
			return CoinDesign.getCoinOne(enemy.getXLocation(),enemy.getYLocation());
		else if(percent<=70)
			return CoinDesign.getCoinFive(enemy.getXLocation(),enemy.getYLocation());
		else if(percent<=80)
			return AmmoDesign.getAmmoDesignOne(enemy.getXLocation(), enemy.getYLocation());
		else if(percent<=90)
			return PotionDesign.getHealthPotDesignOne(enemy.getXLocation(), enemy.getYLocation(),levelNum);
		else if(percent<=95)
			return PotionDesign.getDamagePotDesignOne(enemy.getXLocation(), enemy.getYLocation(),levelNum);
		else if(percent<=100)
			return PotionDesign.getSpeedPotDesignOne(enemy.getXLocation(), enemy.getYLocation(),levelNum);
		return null;
	}
	
	public static Item randomBossMoney(Enemy enemy,int levelNum) 
	{
		return CoinDesign.getCoinOne(enemy.getXLocation(),enemy.getYLocation());
	}
	
	public static Item randomShopItem(Obstacle table,int levelNum)
	{
		//System.out.println("Shop Item Level " + levelNum);
		//System.out.println("CurrentLevel " + Player.getCurrentLevel() + "\n");
		int percent=(int)(Math.random()*14)+1;
		if(percent==1)
			return PotionDesign.getHealthPotDesignOne(table.getXLocation(), table.getYLocation(),levelNum);
		if(percent==2)
			return PotionDesign.getDamagePotDesignOne(table.getXLocation(), table.getYLocation(),levelNum);
		if(percent==3)
			return PotionDesign.getSpeedPotDesignOne(table.getXLocation(), table.getYLocation(),levelNum);
		if(percent==4)
			return WeaponDesign.getAssaultRifleDesignOne(table.getXLocation(), table.getYLocation(),levelNum);
		if(percent==5)
			return WeaponDesign.getPistolDesignOne(table.getXLocation(), table.getYLocation(),levelNum);
		if(percent==6)
			return WeaponDesign.getShotgunDesignOne(table.getXLocation(), table.getYLocation(),levelNum);
		if(percent==7)
			return WeaponDesign.getSniperDesignOne(table.getXLocation(), table.getYLocation(),levelNum);
		if(percent==8)
			return WeaponDesign.getSwordDesignOne(table.getXLocation(), table.getYLocation(),levelNum);
		if(percent==9)
			return ArmorDesign.getBootsDesignOne(table.getXLocation(), table.getYLocation(),levelNum);
		if(percent==10)
			return ArmorDesign.getBreastPlateDesignOne(table.getXLocation(), table.getYLocation(),levelNum);
		if(percent==11)
			return ArmorDesign.getHelmetDesignOne(table.getXLocation(), table.getYLocation(),levelNum);
		if(percent==12)
			return ArmorDesign.getLeggingDesignOne(table.getXLocation(), table.getYLocation(),levelNum);
		if(percent==13)
			return ShieldDesign.getShieldDesignOne(table.getXLocation(), table.getYLocation(),levelNum);
		if(percent==14)
			return WeaponDesign.getSniperDesignEPIC(table.getXLocation(), table.getYLocation(),levelNum);
		return null;
	}
}
