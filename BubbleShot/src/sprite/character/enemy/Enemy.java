package sprite.character.enemy;

import mainGame.backend.Constants;
import map.Level;
import map.Room;
import sprite.character.Character;
import sprite.character.player.Player;

public abstract class Enemy extends Character
{
	private String weapon;
	private int killPoints;
	
	public Enemy(String spriteName,String fileName, double xLocation, double yLocation, double health, double speed,
			double width, double height,String weapon) 
	{
		super(spriteName,fileName, xLocation, yLocation, health, speed, width, height);
		this.weapon=weapon;
	}
	
	public int getKillPoints(){return killPoints;}
	
	public void setKillPoints(int killPoints){this.killPoints=killPoints;}
	
	@Override
	public void useSelectedItem(String input) 
	{
			
	}
	public void moveEnemy(double sec,Player player,Level level)
	{
		Boolean up = false;
		Boolean down = false;
		Boolean left = false;
		Boolean right = false;
		double deltaX = 0;
		double deltaY = 0;
		double changeAmount = this.getSpeed() * sec;
		Room currentRoom = level.getCurrentRoom();
		if(left && currentRoom.canCharacterMove(this, Constants.MOVE_DIR_LEFT, changeAmount))
			deltaX -= changeAmount;
		if(right && currentRoom.canCharacterMove(this, Constants.MOVE_DIR_RIGHT, changeAmount))
			deltaX += changeAmount;
		if(up && currentRoom.canCharacterMove(this, Constants.MOVE_DIR_UP, changeAmount))
			deltaY -= changeAmount;
		if(down && currentRoom.canCharacterMove(this, Constants.MOVE_DIR_DOWN, changeAmount))
			deltaY += changeAmount;
		if(deltaX != 0 && deltaY != 0)
		{
			deltaX *= 1 / Math.sqrt(2);
			deltaY *= 1 / Math.sqrt(2);
		}
		player.addXLocation(deltaX);
		player.addYLocation(deltaY);
	}
	
}
