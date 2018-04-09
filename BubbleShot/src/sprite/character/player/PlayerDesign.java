package sprite.character.player;

import sprite.item.Item;

public class PlayerDesign
{
	public static Player getSimpleStarterPlayer(String name)
	{
		String fileName = "file:resources/player/player1.png";
		Item[] inventory = new Item[6];
		Player player = new Player(name, fileName, 100, 100, 60, 60, 20, 4, inventory);
		return player;
	}
}
