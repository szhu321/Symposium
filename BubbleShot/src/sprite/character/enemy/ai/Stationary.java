package sprite.character.enemy.ai;

import mainGame.GameRunner;
import mainGame.backend.Constants;
import map.Room;
import sprite.character.enemy.Enemy;
import sprite.character.player.Player;

public class Stationary extends AI
{
	public Stationary(Enemy enemy, Player player)
	{
		super(enemy,player,"Stationary");
	}
	
	public void move(double sec)
	{
		//Doesn't Move
	}
	
	public void wander(double sec)
	{
		//Doesn't Wander
	}
}
