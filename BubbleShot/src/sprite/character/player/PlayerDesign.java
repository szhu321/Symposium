package sprite.character.player;

import sprite.item.Item;
import sprite.item.weapon.WeaponDesign;

public class PlayerDesign
{
	public static Player getSimpleStarterPlayer(String name)
	{
		String fileName = "file:resources/player/player1.png";
		Item[] inventory = new Item[6];
		Player player = new Player(name, fileName, 100, 100, 60, 60, 20, 100, inventory, 100);
		player.addItem(WeaponDesign.getPistolDesignOne(100, 100));
		return player;
	}
}
