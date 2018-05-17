package sprite.character.enemy.ai;

import mainGame.GameRunner;
import mainGame.backend.Constants;
import map.Room;
import sprite.character.enemy.Enemy;
import sprite.character.enemy.EnemyDesign;
import sprite.character.player.Player;
import sprite.item.Item;

public class Stationary extends AI
{
	private int time=0;
	public Stationary(Enemy enemy, Player player)
	{
		super(enemy,player,"Stationary");
		time=0;
	}
	
	public void spawnEnemy()
	{
			int randomEnemy=(int) ((Math.random()*4)+1);
			GameRunner.getGameManager().getLevel().getCurrentRoom().addCharacter(EnemyDesign.getRandomDesign(this.getEnemy().getXLocation(), this.getEnemy().getYLocation(), this.getPlayer(),randomEnemy));
	}
	
	public void action(double sec)
	{
		if(this.getEnemy().getEnemyType().equals(Enemy.BASE))
		{
			if(time%200==0)
			{
				spawnEnemy();
			}
			time++;
		}
		move(sec);
		this.getEnemy().useCurrentItem(Item.WEAPON);
			
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
