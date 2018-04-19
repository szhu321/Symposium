package sprite.character.enemy;

import mainGame.backend.Constants;
import map.Level;
import map.Room;
import sprite.character.Character;
import sprite.character.enemy.ai.AI;
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
}
