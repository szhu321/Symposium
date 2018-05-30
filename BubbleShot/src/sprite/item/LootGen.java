package sprite.item;

import sprite.character.enemy.Enemy;
import sprite.item.ammo.AmmoDesign;
import sprite.item.collectable.CoinDesign;
import sprite.item.potion.PotionDesign;
import sprite.item.weapon.WeaponDesign;

public class LootGen 
{
	public static Item randomEnemyItem(Enemy enemy) 
	{
		int percent=(int)(Math.random()*100)+1;
		if(percent <=40)
			return null;
		else if(percent <=60)
			return CoinDesign.getCoinOne(enemy.getXLocation(),enemy.getYLocation());
		else if(percent<=70)
			return CoinDesign.getCoinFive(enemy.getXLocation(),enemy.getYLocation());
		else if(percent<=80)
			return AmmoDesign.getAmmoDesignOne(enemy.getXLocation(), enemy.getYLocation());
		else if(percent<=90)
			return PotionDesign.getHealthPotDesignOne(enemy.getXLocation(), enemy.getYLocation());
		else if(percent<=95)
			return PotionDesign.getDamagePotDesignOne(enemy.getXLocation(), enemy.getYLocation());
		else if(percent<=100)
			return PotionDesign.getHealthPotDesignOne(enemy.getXLocation(), enemy.getYLocation());
		return null;
	}
	
	public static Item randomShopItem()
	{
		return null;
	}
}
