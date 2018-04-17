package sprite.character.enemy;

import sprite.character.enemy.Enemy;

public class Regular extends Enemy
{
	private AI Brian;
	public Regular(String spriteName, String fileName, double xLocation, double yLocation, int health, double speed, double width, double height, String weapon)
	{
		super(spriteName,fileName, xLocation, yLocation, health, speed, width, height, weapon);
	}
	
	public void setBrain(AI brain) {Brian=brain;}
}
