package sprite.character.enemy;

import map.Room;
import sprite.character.enemy.Enemy;
import sprite.character.enemy.ai.Stationary;
import sprite.character.player.Player;
import sprite.item.Item;

public class Spawner extends Enemy
{
	public Spawner(String spriteName, String fileName, double xLocation, double yLocation, double health, double speed, double width, double height, Item weapon,Player player,String enemyType)
	{
		super(spriteName,fileName, xLocation, yLocation, health, speed, width, height, weapon,player,enemyType);
		this.setGunVisibility(false);
		this.setBrain(new Stationary(this,this.getPlayer()));
	}
	
	public Spawner(String spriteName, String fileName, double xLocation, double yLocation, double health, double speed, double width, double height, Item weapon,Player player,String enemyType,String specificEnemy)
	{
		super(spriteName,fileName, xLocation, yLocation, health, speed, width, height, weapon,player,enemyType);
		this.setGunVisibility(false);
		this.setBrain(new Stationary(this,this.getPlayer(),specificEnemy));
	}
}
