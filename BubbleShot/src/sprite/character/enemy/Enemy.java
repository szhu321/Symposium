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
	private AI brain;
	private Player player;
	
	public Enemy(String spriteName,String fileName, double xLocation, double yLocation, double health, double speed,
			double width, double height,String weapon,Player player) 
	{
		super(spriteName,fileName, xLocation, yLocation, health, speed, width, height);
		this.weapon=weapon;
		this.player=player;
	}
	
	public int getKillPoints(){return killPoints;}
	public Player getPlayer() {return player;}
	public void setKillPoints(int killPoints){this.killPoints=killPoints;}
	public AI getBrain(){return brain;}
	public void setBrain(AI brain){this.brain=brain;}
	
	@Override
	public void useSelectedItem(String input) 
	{
			
	}
}
