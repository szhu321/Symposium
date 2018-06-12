package sprite.character.enemy.ai;

import mainGame.GameRunner;
import sprite.character.enemy.Boss;
import sprite.character.enemy.Enemy;
import sprite.character.player.Player;
import sprite.item.Item;
import sprite.item.weapon.BossWepFive;
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
		if(this.isFollowPlayer())
		{
			if(this.isClockwise())
				this.getEnemy().setFaceAngle(this.getEnemy().getFaceAngle()+1);
			else
				this.getEnemy().setFaceAngle(this.getEnemy().getFaceAngle()-1);
		}
		int wepIdx=0;
		if(time==400)
			time=0;
		if(time<=300)
		{
			if(time%300==0)
				this.getEnemy().getBrain().switchClockwise();
			if(time%300==0)
			{
				wepIdx=(int)(Math.random()*((Boss)(this.getEnemy())).getAllWep().size());
				((Boss)(this.getEnemy())).switchWeapon(wepIdx);
				if(this.getEnemy().getWeapon() instanceof BossWepThree)
				{
					int max=(int)(Math.random()*361);
					int min=max-20;
					((BossWepThree)this.getEnemy().getWeapon()).setRange(min,max);
				}
				if(this.getEnemy().getWeapon() instanceof BossWepFive)
				{
					this.setFollowPlayer(false);
					int direction=(int)(Math.random()*4);
//					if(direction==1)
//					{
//						this.getEnemy().setXLocation(GameRunner.getGameManager().getLevel().getCurrentRoom().getRoomPixWidth()/2);
//						this.getEnemy().setYLocation(100);
//					}
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
