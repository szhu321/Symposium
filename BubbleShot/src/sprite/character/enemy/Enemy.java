package sprite.character.enemy;

import sprite.character.Character;

abstract class Enemy extends Character
{
	private String weapon;
	private int killPoints;
	
	public Enemy(String spriteName,String fileName, double xLocation, double yLocation, int health, int speed,
			String weapon) 
	{
		super(spriteName,fileName, xLocation, yLocation, health, speed,60,60);
		this.weapon=weapon;
	}
	
	public int getKillPoints(){return killPoints;}
	
	public void setKillPoints(int killPoints){this.killPoints=killPoints;}
	
	@Override
	public void useSelectedItem(String input) 
	{
			
	}
	
	
}
