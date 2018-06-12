package sprite.character.enemy.ai;

import mainGame.GameRunner;
import mainGame.backend.Constants;
import map.Level;
import map.Room;
import sprite.character.enemy.Enemy;
import sprite.character.player.Player;
import sprite.item.Item;

public class Follower extends AI
{
	public Follower(Enemy enemy, Player player)
	{
		super(enemy,player,"Follower");
	}
	
	public void action(double sec)
	{
		this.getEnemy().calculateEnemyAngleToPlayer();
		move(sec);
		this.getEnemy().useCurrentItem(Item.WEAPON);
	}
	
	public void move(double sec)
	{
		double deltaX = 0;
		double deltaY = 0;
		Enemy enemy=this.getEnemy();
		Player player=this.getPlayer();
		double changeAmount = enemy.getSpeed() * sec;
		Room currentRoom = GameRunner.getGameManager().getLevel().getCurrentRoom();
		
		if(enemy.getXLocation()>player.getXLocation()&&currentRoom.canCharacterMove(enemy, Constants.MOVE_DIR_LEFT, changeAmount))
			deltaX -= changeAmount;
		if(enemy.getXLocation()<player.getXLocation()&&currentRoom.canCharacterMove(enemy, Constants.MOVE_DIR_RIGHT, changeAmount))
			deltaX += changeAmount;
		if(enemy.getYLocation()>player.getYLocation() && currentRoom.canCharacterMove(enemy, Constants.MOVE_DIR_UP, changeAmount))
			deltaY -= changeAmount;
		if(enemy.getYLocation()<player.getYLocation() && currentRoom.canCharacterMove(enemy, Constants.MOVE_DIR_DOWN, changeAmount))
			deltaY += changeAmount;
		
		if(deltaX != 0 && deltaY != 0)
		{
			deltaX *= 1 / Math.sqrt(2);
			deltaY *= 1 / Math.sqrt(2);
		}		
		enemy.addXLocation(deltaX);
		enemy.addYLocation(deltaY);
	}
}
