package sprite.character.enemy;

import sprite.character.enemy.ai.AI;
import sprite.character.player.Player;
import sprite.item.weapon.Weapon;
import sprite.item.weapon.WeaponDesign;

public class EnemyDesign
{
	public static Enemy getRegularDesignOne(double x, double y, Player player)
	{
		String fileName = "file:resources/enemy/enemy.png";
		Weapon pistol=WeaponDesign.getPistolDesignOne(x, y);
		Enemy enemy=new Regular("Brian",fileName, x, y,100, 50, 60, 60, pistol,player);
		return enemy;
	}
	
	public static Boss getBossDesignOne()
	{
		return null;
	}
}
