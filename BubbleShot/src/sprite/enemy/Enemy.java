package sprite.enemy;

import sprite.character.Character;

abstract class Enemy extends Character
{

	protected Enemy(String fileName, int xLocation, int yLocation, int health, int speed,
			String weapon) 
	{
		super(fileName, xLocation, yLocation, health, speed, weapon);
	}
	
	
}
