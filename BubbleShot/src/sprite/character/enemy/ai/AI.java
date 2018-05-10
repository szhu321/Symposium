package sprite.character.enemy.ai;

import map.Level;
import sprite.character.enemy.Enemy;
import sprite.character.player.Player;

public abstract class AI 
{
	private Enemy enemy;
	private Player player;
	private String name;
	public AI(Enemy enemy, Player player,String name)
	{
		this.enemy=enemy;
		this.player=player;
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract void move(double sec);

	public Enemy getEnemy()	{return enemy;}
	public Player getPlayer(){return player;}
}
