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
		time=400;
	}

	@Override
	public void action(double sec)
	{
		//Pauses an enemy after an attack and resets time for new attack
		if(time==500)
			time=0;
		if(time<=300)
		{
			//Boss doesn't follow player, then it goes in either directions
			if(this.isFollowPlayer())
			{
				if(this.isClockwise())
					this.getEnemy().setFaceAngle(this.getEnemy().getFaceAngle()+1);
				else
					this.getEnemy().setFaceAngle(this.getEnemy().getFaceAngle()-1);
			}
			//Chance changes direction of attacks
			if(time%320==0)
			{
				int num=(int)(Math.random()*2);
				if(num==0)
					this.getEnemy().getBrain().switchClockwise();
			}
			// Chance to randomly switches weapons
			if(time%320==0)
			{
				int wepIdx=(int)(Math.random()*((Boss)(this.getEnemy())).getAllWep().size());
				((Boss)(this.getEnemy())).switchWeapon(wepIdx);
				
				if(this.getEnemy().getWeapon() instanceof BossWepThree)
				{
					//Picks a random location for player to doge
					int max=(int)(Math.random()*361);
					int min=max-50;
					((BossWepThree)this.getEnemy().getWeapon()).setRange(min,max);
				}
				if(this.getEnemy().getWeapon() instanceof BossWepFive)
				{
					//Shoots and teleports to a random direction
					this.setFollowPlayer(false);
					int direction=(int)(Math.random()*4);
					move(direction);				
				}
				else
				{
					this.getEnemy().setXLocation(GameRunner.getGameManager().getLevel().getCurrentRoom().getRoomPixWidth()/2);
					this.getEnemy().setYLocation(GameRunner.getGameManager().getLevel().getCurrentRoom().getRoomPixHeight()/2);
					if(this.getEnemy().getBoundsOfObject().contains(this.getPlayer().getBoundsOfObject())||this.getEnemy().getBoundsOfObject().intersect(this.getPlayer().getBoundsOfObject()))
					{
						this.getEnemy().addXLocation(this.getPlayer().getWidth()+100);
					//	this.getEnemy().addYLocation(this.getPlayer().getHeight()+50);
					}
				}
			}	
			this.getEnemy().useCurrentItem(Item.WEAPON);
		}
		time++;
	}
	
	public boolean move(int direction)
	{
		if(direction==0)
		{
			this.getEnemy().setXLocation(GameRunner.getGameManager().getLevel().getCurrentRoom().getRoomPixWidth()/2);
			this.getEnemy().setYLocation(100);
			if(this.getEnemy().getBoundsOfObject().contains(this.getPlayer().getBoundsOfObject()))
			{
				move(direction+1);
				return true;
			}
			((BossWepFive)this.getEnemy().getWeapon()).setRange(70,120);
		}
		if(direction==1)
		{
			this.getEnemy().setXLocation(GameRunner.getGameManager().getLevel().getCurrentRoom().getRoomPixWidth()-200);
			this.getEnemy().setYLocation(GameRunner.getGameManager().getLevel().getCurrentRoom().getRoomPixHeight()/2);
			if(this.getEnemy().getBoundsOfObject().contains(this.getPlayer().getBoundsOfObject()))
			{
				move(direction+1);
				return true;
			}
			((BossWepFive)this.getEnemy().getWeapon()).setRange(150,210);
		}
		if(direction==2)
		{
			this.getEnemy().setXLocation(GameRunner.getGameManager().getLevel().getCurrentRoom().getRoomPixWidth()/2);
			this.getEnemy().setYLocation(GameRunner.getGameManager().getLevel().getCurrentRoom().getRoomPixHeight()-200);
			if(this.getEnemy().getBoundsOfObject().contains(this.getPlayer().getBoundsOfObject()))
			{
				move(direction+1);
				return true;
			}
			((BossWepFive)this.getEnemy().getWeapon()).setRange(240,300);
		}
		if(direction==3)
		{
			this.getEnemy().setXLocation(100);
			this.getEnemy().setYLocation(GameRunner.getGameManager().getLevel().getCurrentRoom().getRoomPixHeight()/2);
			if(this.getEnemy().getBoundsOfObject().contains(this.getPlayer().getBoundsOfObject()))
			{
				move(0);
				return true;
			}
			((BossWepFive)this.getEnemy().getWeapon()).setRange(-30,30);
		}
		return false;
	}
	
	public void wander(double sec)
	{
		//Doesn't Wander
	}
}
