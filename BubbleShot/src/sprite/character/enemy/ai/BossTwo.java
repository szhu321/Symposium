package sprite.character.enemy.ai;

import mainGame.GameRunner;
import mainGame.backend.Constants;
import map.Room;
import sprite.character.enemy.Boss;
import sprite.character.enemy.Enemy;
import sprite.character.player.Player;
import sprite.item.Item;
import sprite.item.weapon.BossWepEight;
import sprite.item.weapon.BossWepFive;
import sprite.item.weapon.BossWepSeven;
import sprite.item.weapon.BossWepThree;

public class BossTwo extends AI
{
	private int time;
	private boolean move;
	private boolean leftMax;
	private boolean rightMax;
	private boolean upMax;
	private boolean downMax;
	private int currentMove;
	public BossTwo(Enemy enemy, Player player) {
		super(enemy, player, "BossTwo");
		// TODO Auto-generated constructor stub
		time=400;
		move=false;
		leftMax=false;
		rightMax=false;
		upMax=false;
		downMax=false;
		currentMove=1;
	}

	@Override
	public void action(double sec)
	{
		//System.out.println(time);
		if(time==500)
			time=0;
		if(time>400)
		{
			if(!allMoves(sec,6))
				time=0;
			else
				time=401;
		}
		if(time%400==0)
		{
			//this.getEnemy().calculateEnemyAngleToPlayer();
			//this.getEnemy().useCurrentItem(Item.WEAPON);
			int wepIdx=(int)(Math.random()*((Boss)(this.getEnemy())).getAllWep().size());
			((Boss)(this.getEnemy())).switchWeapon(wepIdx);
		}
		if(time<300)
		{
			if(this.getEnemy().getWeapon() instanceof BossWepEight)
			{
			//	time=0;
				//moveMiddle(sec);
				if(time%50==0)
					this.getEnemy().useCurrentItem(Item.WEAPON);
			}
			else if(this.getEnemy().getWeapon() instanceof BossWepSeven)
				{
					if(currentMove>5)
					{
						time=401;
						currentMove=1;			
					}
					if(!allMoves(sec,currentMove))
						currentMove++;
					this.getEnemy().useCurrentItem(Item.WEAPON);
				}
			else
				this.getEnemy().useCurrentItem(Item.WEAPON);
		}
			time++;
	}
	
	public boolean allMoves(double sec, int index)
	{
		if(index==1)
			if(!moveOne(sec))
				return false;
		if(index==2||index==4)
			if(!moveTwo(sec))
				return false;
		if(index==3)
			if(!moveThree(sec))
				return false;
		if(index==5)
			if(!moveFour(sec))
				return false;
		if(index==6)
			if(!moveFive(sec))
				return false;
		return true;
	}
	
	public boolean moveOne(double sec)
	{
		double deltaX = 0;
		double deltaY = 0;
		Enemy enemy=this.getEnemy();
		double changeAmount = 5;
		Room currentRoom = GameRunner.getGameManager().getLevel().getCurrentRoom();
		if(this.getEnemy().getXLocation()!=currentRoom.getRoomPixHeight()-200&&currentRoom.canCharacterMove(enemy, Constants.MOVE_DIR_RIGHT, changeAmount))
			deltaX += changeAmount;
		else
			rightMax=true;
		if(this.getEnemy().getYLocation()!=currentRoom.getRoomPixWidth()-200&&currentRoom.canCharacterMove(enemy, Constants.MOVE_DIR_DOWN, changeAmount))
			deltaY += changeAmount;
		else
			downMax=true;
		if(deltaX != 0 && deltaY != 0)
		{
			deltaX *= 1 / Math.sqrt(2);
			deltaY *= 1 / Math.sqrt(2);
		}		
		if(rightMax&&downMax)
		{
			resetMax();
			return false;
		}
		enemy.addXLocation(deltaX);
		enemy.addYLocation(deltaY);
		return true;
	}
	
	public boolean moveTwo(double sec)
	{
		double deltaX = 0;
		double deltaY = 0;
		Enemy enemy=this.getEnemy();
		double changeAmount = 5;
		Room currentRoom = GameRunner.getGameManager().getLevel().getCurrentRoom();
		if(this.getEnemy().getXLocation()!=200&&currentRoom.canCharacterMove(enemy, Constants.MOVE_DIR_LEFT, changeAmount))
			deltaX -= changeAmount;
		else
			leftMax=true;
		if(deltaX != 0 && deltaY != 0)
		{
			deltaX *= 1 / Math.sqrt(2);
			deltaY *= 1 / Math.sqrt(2);
		}		
		if(leftMax)
		{
			resetMax();
			return false;
		}
		enemy.addXLocation(deltaX);
		enemy.addYLocation(deltaY);
		return true;
	}
	
	public boolean moveThree(double sec)
	{
		double deltaX = 0;
		double deltaY = 0;
		Enemy enemy=this.getEnemy();
		double changeAmount = 5;
		Room currentRoom = GameRunner.getGameManager().getLevel().getCurrentRoom();
		if(this.getEnemy().getXLocation()!=currentRoom.getRoomPixHeight()-200&&currentRoom.canCharacterMove(enemy, Constants.MOVE_DIR_RIGHT, changeAmount))
			deltaX += changeAmount;
		else
			rightMax=true;
		if(this.getEnemy().getYLocation()!=200&& currentRoom.canCharacterMove(enemy, Constants.MOVE_DIR_UP, changeAmount))
			deltaY -= changeAmount;
		else
			upMax=true;
		if(deltaX != 0 && deltaY != 0)
		{
			deltaX *= 1 / Math.sqrt(2);
			deltaY *= 1 / Math.sqrt(2);
		}		
		if(rightMax&&upMax)
		{
			resetMax();
			return false;
		}
		enemy.addXLocation(deltaX);
		enemy.addYLocation(deltaY);
		return true;
	}
	
	public boolean moveFour(double sec)
	{
		double deltaX = 0;
		double deltaY = 0;
		Enemy enemy=this.getEnemy();
		double changeAmount = 5;
		Room currentRoom = GameRunner.getGameManager().getLevel().getCurrentRoom();
		if(this.getEnemy().getXCenter()!=currentRoom.getRoomPixHeight()/2&&currentRoom.canCharacterMove(enemy, Constants.MOVE_DIR_RIGHT, changeAmount))
			deltaX += changeAmount;
		else
			rightMax=true;
		if(this.getEnemy().getYCenter()!=currentRoom.getRoomPixWidth()/2&& currentRoom.canCharacterMove(enemy, Constants.MOVE_DIR_DOWN, changeAmount))
			deltaY += changeAmount;
		else
			downMax=true;
		if(deltaX != 0 && deltaY != 0)
		{
			deltaX *= 1 / Math.sqrt(2);
			deltaY *= 1 / Math.sqrt(2);
		}		
		if(rightMax&&downMax)
		{
			resetMax();
			return false;
		}
		enemy.addXLocation(deltaX);
		enemy.addYLocation(deltaY);
		return true;
	}
	
	public boolean moveFive(double sec)
	{
		double deltaX = 0;
		double deltaY = 0;
		Enemy enemy=this.getEnemy();
		Player player=this.getPlayer();
		double changeAmount = enemy.getSpeed() * sec;
		Room currentRoom = GameRunner.getGameManager().getLevel().getCurrentRoom();
		
		if(enemy.getXLocation()>currentRoom.getRoomPixHeight()/2&&currentRoom.canCharacterMove(enemy, Constants.MOVE_DIR_LEFT, changeAmount))
			deltaX -= changeAmount;
		else
			rightMax=true;
		if(enemy.getXLocation()<currentRoom.getRoomPixHeight()/2&&currentRoom.canCharacterMove(enemy, Constants.MOVE_DIR_RIGHT, changeAmount))
			deltaX += changeAmount;
		else
			leftMax=true;
		if(enemy.getYLocation()>currentRoom.getRoomPixWidth()/2 && currentRoom.canCharacterMove(enemy, Constants.MOVE_DIR_UP, changeAmount))
			deltaY -= changeAmount;
		else
			upMax=true;
		if(enemy.getYLocation()<currentRoom.getRoomPixWidth()/2 && currentRoom.canCharacterMove(enemy, Constants.MOVE_DIR_DOWN, changeAmount))
			deltaY += changeAmount;
		else
			downMax=true;
		
		if(deltaX != 0 && deltaY != 0)
		{
			deltaX *= 1 / Math.sqrt(2);
			deltaY *= 1 / Math.sqrt(2);
		}		
		
		if(rightMax&&leftMax&&upMax&&downMax)
		{
			resetMax();
			return false;
		}
		enemy.addXLocation(deltaX);
		enemy.addYLocation(deltaY);
		return true;
	}
	
	public boolean moveMiddle(double sec)
	{
		double deltaX = 0;
		double deltaY = 0;
		Enemy enemy=this.getEnemy();
		Player player=this.getPlayer();
		double changeAmount = enemy.getSpeed() * sec;
		Room currentRoom = GameRunner.getGameManager().getLevel().getCurrentRoom();
		
		if(enemy.getXLocation()>currentRoom.getRoomPixHeight()/2&&currentRoom.canCharacterMove(enemy, Constants.MOVE_DIR_LEFT, changeAmount))
			deltaX -= changeAmount;
		if(enemy.getXLocation()<currentRoom.getRoomPixHeight()/2&&currentRoom.canCharacterMove(enemy, Constants.MOVE_DIR_RIGHT, changeAmount))
			deltaX += changeAmount;
		if(enemy.getYLocation()>currentRoom.getRoomPixWidth()/2 && currentRoom.canCharacterMove(enemy, Constants.MOVE_DIR_UP, changeAmount))
			deltaY -= changeAmount;
		if(enemy.getYLocation()<currentRoom.getRoomPixWidth()/2 && currentRoom.canCharacterMove(enemy, Constants.MOVE_DIR_DOWN, changeAmount))
			deltaY += changeAmount;
		
		if(deltaX != 0 && deltaY != 0)
		{
			deltaX *= 1 / Math.sqrt(2);
			deltaY *= 1 / Math.sqrt(2);
		}		
		
		enemy.addXLocation(deltaX);
		enemy.addYLocation(deltaY);
		return true;
	}
	
	public void resetMax()
	{
		leftMax=false;
		rightMax=false;
		upMax=false;
		downMax=false;
	}
	public void wander(double sec)
	{
		//Doesn't Wander
	}
}
