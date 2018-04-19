package sprite.character.enemy;

import sprite.character.enemy.Enemy;
import sprite.character.enemy.ai.Follower;
import sprite.character.player.Player;

public class Regular extends Enemy
{
	public Regular(String spriteName, String fileName, double xLocation, double yLocation, double health, double speed, double width, double height, String weapon,Player player)
	{
		super(spriteName,fileName, xLocation, yLocation, health, speed, width, height, weapon,player);		
		this.setBrain(new Follower(this,this.getPlayer()));
	}
}
