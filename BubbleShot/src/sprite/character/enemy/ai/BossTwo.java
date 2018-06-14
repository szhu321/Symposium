package sprite.character.enemy.ai;

import mainGame.GameRunner;
import sprite.character.enemy.Boss;
import sprite.character.enemy.Enemy;
import sprite.character.player.Player;
import sprite.item.Item;
import sprite.item.weapon.BossWepFive;
import sprite.item.weapon.BossWepThree;

public class BossTwo extends AI
{
	private int time;
	private boolean move;
	public BossTwo(Enemy enemy, Player player) {
		super(enemy, player, "BossTwo");
		// TODO Auto-generated constructor stub
		time=400;
		move=false;
	}

	@Override
	public void action(double sec)
	{
		if(time==500)
			time=0;
		if(time<=300)
		{
		//	moveOne(sec);
			this.getEnemy().calculateEnemyAngleToPlayer();
			this.getEnemy().useCurrentItem(Item.WEAPON);
		}
		time++;
	}
	
	public void moveOne(double secs)
	{
		
	}
	
	public void wander(double sec)
	{
		//Doesn't Wander
	}
}
