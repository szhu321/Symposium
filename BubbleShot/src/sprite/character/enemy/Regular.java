package sprite.character.enemy;

import sprite.character.enemy.Enemy;
import sprite.character.enemy.ai.AI;

public class Regular extends Enemy
{
	private AI Brian;
	public Regular(String spriteName, String fileName, double xLocation, double yLocation, int health, double speed, double width, double height, String weapon, AI brain)
	{
		super(spriteName,fileName, xLocation, yLocation, health, speed, width, height, weapon);
		Brian=brain;
	}
}
