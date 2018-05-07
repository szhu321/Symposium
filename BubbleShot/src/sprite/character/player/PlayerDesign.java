package sprite.character.player;

import sprite.item.Item;
import sprite.item.weapon.WeaponDesign;

public class PlayerDesign
{
	public static Player getSimpleStarterPlayer(String name)
	{
		String fileName = "file:resources/player/player1.png";
		Item[] inventory = new Item[6];
		//The health the player starts with.
		double health = 70;
		//Players speed in pixels per second.
		double speed = 130;
		//The ammo the player starts with.
		int ammoCount = 2000;
		Player player = new Player(name, fileName, 100, 100, 60, 60, health, speed, inventory, ammoCount);
		player.addItem(WeaponDesign.getPistolDesignOne(100, 100));
		return player;
	}
}
