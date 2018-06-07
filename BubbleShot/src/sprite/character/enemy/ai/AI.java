package sprite.character.enemy.ai;

import mainGame.GameRunner;
import mainGame.backend.Constants;
import map.Level;
import map.Room;
import myutilities.MyMath;
import sprite.character.enemy.Enemy;
import sprite.character.player.Player;

public abstract class AI 
{
	private Enemy enemy;
	private Player player;
	private String name;
	private int directionSecs;
	private int direction;
	private boolean followPlayer;
	
	public AI(Enemy enemy, Player player,String name)
	{
		this.enemy=enemy;
		this.player=player;
		this.name=name;
		directionSecs=1;
		direction=0;
		followPlayer=false;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract void action(double sec);

	public void wander(double sec)
	{
		double deltaX = 0;
		double deltaY = 0;
		Enemy enemy=this.getEnemy();
		double changeAmount = enemy.getSpeed() * sec;
		Room currentRoom = GameRunner.getGameManager().getLevel().getCurrentRoom();
		if(directionSecs==20)
		{	
			direction=MyMath.getRandomInteger(1, 4);
			directionSecs=0;
		}
		else
		{
			if(this.getEnemy().getEnemyType()!=Enemy.GHOST)
			{
				if(direction==1&&currentRoom.canCharacterMove(enemy, Constants.MOVE_DIR_LEFT, changeAmount))
					deltaX -= changeAmount;
				if(direction==2&&currentRoom.canCharacterMove(enemy, Constants.MOVE_DIR_RIGHT, changeAmount))
					deltaX += changeAmount;
				if(direction==3&&currentRoom.canCharacterMove(enemy, Constants.MOVE_DIR_UP, changeAmount))
					deltaY -= changeAmount;
				if(direction==4&&currentRoom.canCharacterMove(enemy, Constants.MOVE_DIR_DOWN, changeAmount))
					deltaY += changeAmount;
			}
			if(deltaX != 0 && deltaY != 0)
			{
				deltaX *= 1 / Math.sqrt(2);
				deltaY *= 1 / Math.sqrt(2);
			}		
			enemy.addXLocation(deltaX);
			enemy.addYLocation(deltaY);
			directionSecs++;
		}
	}
	
	public Enemy getEnemy()	{return enemy;}
	public Player getPlayer(){return player;}

	public boolean isFollowPlayer() {
		return followPlayer;
	}

	public void setFollowPlayer(boolean followPlayer) {
		this.followPlayer = followPlayer;
	}
}
