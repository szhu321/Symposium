package sprite.character.enemy;

import sprite.character.enemy.ai.AI;
import sprite.character.player.Player;

public class EnemyDesign
{
	public static Enemy getRegularDesignOne(double x, double y, Player player)
	{
		String fileName = "file:resources/enemy/enemy.png";
		Enemy enemy=new Regular("Brian",fileName, x, y,100, 50, 60, 60, null,player);
		return enemy;
	}
	
	public static Boss getBossDesignOne()
	{
		return null;
	}
}
