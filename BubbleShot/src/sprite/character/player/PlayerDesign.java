package sprite.character.player;

import sprite.item.Item;
import sprite.item.weapon.WeaponDesign;

public class PlayerDesign
{
	public static Player getSimpleStarterPlayer(String name)
	{
		String fileName = "file:resources/player/player1.png";
		//The health the player starts with.
		double health = 500;
		//Players speed in pixels per second.
		double speed = 170;
		//The ammo the player starts with.
		int ammoCount = 400;
		Player player = new Player(name, fileName, 100, 100, 50, 50, health, speed, ammoCount);
		player.addItem(WeaponDesign.getPistolDesignOne(100, 100));
		return player;
	}
	
	public static Player getSimpleStarterPlayer(String name, String fileName)
	{
		//The health the player starts with.
		double health = 500;
		//Players speed in pixels per second.
		double speed = 170;
		//The ammo the player starts with.
		int ammoCount = 400;
		Player player = new Player(name, fileName, 100, 100, 50, 50, health, speed, ammoCount);
		player.addItem(WeaponDesign.getPistolDesignOne(100, 100));
		return player;
	}
}
