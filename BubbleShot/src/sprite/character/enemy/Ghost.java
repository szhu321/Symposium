package sprite.character.enemy;

import sprite.character.enemy.Enemy;
import sprite.character.enemy.ai.Astar;
import sprite.character.enemy.ai.Follower;
import sprite.character.player.Player;
import sprite.item.Item;

public class Ghost extends Enemy
{
	public Ghost(String spriteName, String fileName, double xLocation, double yLocation, double health, double speed, double width, double height, Item weapon,Player player,String enemyType)
	{
		super(spriteName,fileName, xLocation, yLocation, health, speed, width, height, weapon,player,enemyType);		
		this.setBrain(new Follower(this,this.getPlayer()));
	}
}
