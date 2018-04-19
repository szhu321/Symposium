package sprite.character.enemy.ai;

import map.Level;
import sprite.character.enemy.Enemy;
import sprite.character.player.Player;

public abstract class AI 
{
	private Enemy enemy;
	private Player player;
	public AI(Enemy enemy, Player player)
	{
		this.enemy=enemy;
		this.player=player;
	}
	
	public abstract void move(double sec, Level level);

	public Enemy getEnemy()	{return enemy;}
	public Player getPlayer(){return player;}
}
