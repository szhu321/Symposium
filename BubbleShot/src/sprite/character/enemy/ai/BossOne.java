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
		if(time==500)
			time=0;
		if(time<=300)
		{
			if(this.isFollowPlayer())
			{
				if(this.isClockwise())
					this.getEnemy().setFaceAngle(this.getEnemy().getFaceAngle()+1);
				else
					this.getEnemy().setFaceAngle(this.getEnemy().getFaceAngle()-1);
			}
			if(time%320==0)
				this.getEnemy().getBrain().switchClockwise();
			if(time%320==0)
			{
				int wepIdx=(int)(Math.random()*((Boss)(this.getEnemy())).getAllWep().size());
				((Boss)(this.getEnemy())).switchWeapon(wepIdx);
				if(this.getEnemy().getWeapon() instanceof BossWepThree)
				{
					int max=(int)(Math.random()*361);
					int min=max-50;
					((BossWepThree)this.getEnemy().getWeapon()).setRange(min,max);
				}
				if(this.getEnemy().getWeapon() instanceof BossWepFive)
				{
					this.setFollowPlayer(false);
					int direction=(int)(Math.random()*4);
					if(direction==0)
					{
						this.getEnemy().setXLocation(GameRunner.getGameManager().getLevel().getCurrentRoom().getRoomPixWidth()/2);
						this.getEnemy().setYLocation(100);
						((BossWepFive)this.getEnemy().getWeapon()).setRange(70,120);
					}
					if(direction==1)
					{
						this.getEnemy().setXLocation(GameRunner.getGameManager().getLevel().getCurrentRoom().getRoomPixWidth()-200);
						this.getEnemy().setYLocation(GameRunner.getGameManager().getLevel().getCurrentRoom().getRoomPixHeight()/2);
						((BossWepFive)this.getEnemy().getWeapon()).setRange(150,210);
					}
					if(direction==2)
					{
						this.getEnemy().setXLocation(GameRunner.getGameManager().getLevel().getCurrentRoom().getRoomPixWidth()/2);
						this.getEnemy().setYLocation(GameRunner.getGameManager().getLevel().getCurrentRoom().getRoomPixHeight()-200);
						((BossWepFive)this.getEnemy().getWeapon()).setRange(240,300);
					}
					if(direction==3)
					{
						this.getEnemy().setXLocation(100);
						this.getEnemy().setYLocation(GameRunner.getGameManager().getLevel().getCurrentRoom().getRoomPixHeight()/2);
						((BossWepFive)this.getEnemy().getWeapon()).setRange(-30,30);
					}
				}
				else
				{
					this.getEnemy().setXLocation(GameRunner.getGameManager().getLevel().getCurrentRoom().getRoomPixWidth()/2);
					this.getEnemy().setYLocation(GameRunner.getGameManager().getLevel().getCurrentRoom().getRoomPixHeight()/2);
					if(this.getEnemy().getBoundsOfObject().contains(this.getPlayer().getBoundsOfObject()))
					{
						this.getEnemy().addXLocation(this.getPlayer().getWidth()+50);
						this.getEnemy().addYLocation(this.getPlayer().getHeight()+50);
					}
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
