package sprite.character.enemy.ai;

import sprite.character.enemy.Boss;
import sprite.character.enemy.Enemy;
import sprite.character.player.Player;
import sprite.item.Item;
import sprite.item.weapon.BossWepThree;

public class BossOne extends AI
{
	private int time;
	public BossOne(Enemy enemy, Player player) {
		super(enemy, player, "BossOne");
		// TODO Auto-generated constructor stub
		time=0;
	}

	@Override
	public void action(double sec)
	{
		int wepIdx=0;
		if(time==400)
			time=0;
		if(time<=300)
		{
			if(time%200==0)
				this.getEnemy().getBrain().switchClockwise();
			if(time%300==0)
			{
				wepIdx=(int)(Math.random()*((Boss)(this.getEnemy())).getAllWep().size());
				((Boss)(this.getEnemy())).switchWeapon(wepIdx);
				if(this.getEnemy().getWeapon() instanceof BossWepThree)
				{
					((BossWepThree)this.getEnemy().getWeapon()).setRange((int)(Math.random()*361));
					
				}
			}	
			this.getEnemy().useCurrentItem(Item.WEAPON);
		}
		time++;
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
