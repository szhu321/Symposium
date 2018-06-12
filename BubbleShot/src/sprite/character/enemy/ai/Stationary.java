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
	private String specificEnemy;
	public Stationary(Enemy enemy, Player player)
	{
		super(enemy,player,"Stationary");
		time=0;
		this.specificEnemy="random";
	}
	
	public Stationary(Enemy enemy, Player player,String specificEnemy)
	{
		super(enemy,player,"Stationary");
		time=0;
		this.specificEnemy=specificEnemy;
	}
	
	public void spawnEnemy()
	{		
		
		if(specificEnemy.equals("random"))
		{
			int randomEnemy=(int) ((Math.random()*4)+1);
			GameRunner.getGameManager().getLevel().getCurrentRoom().addCharacter(EnemyDesign.getRandomDesign(this.getEnemy().getXLocation(), this.getEnemy().getYLocation(), this.getPlayer(),randomEnemy));
		}
		else
		{
			GameRunner.getGameManager().getLevel().getCurrentRoom().addCharacter(EnemyDesign.getRandomDesign(this.getEnemy().getXLocation(), this.getEnemy().getYLocation(), this.getPlayer(),specificEnemy));
		}
				
	}
	
	public void action(double sec)
	{
		this.getEnemy().calculateEnemyAngleToPlayer();
		if(this.getEnemy().getEnemyType().equals(Enemy.SPAWNER1)||this.getEnemy().getEnemyType().equals(Enemy.SPAWNER2))
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

	public String getSpecificEnemy() {
		return specificEnemy;
	}

	public void setSpecificEnemy(String specificEnemy) {
		this.specificEnemy = specificEnemy;
	}
}
