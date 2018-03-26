package sprite.character.enemy;

import sprite.character.Character;

abstract class Enemy extends Character
{
	private String weapon;
	protected Enemy(String fileName, double xLocation, double yLocation, int health, int speed,
			String weapon) 
	{
		super(fileName, xLocation, yLocation, health, speed,60,60);
		this.weapon=weapon;
	}
	@Override
	public void useSelectedItem() 
	{
		
		
	}
	
	
}
