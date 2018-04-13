package map;

import sprite.character.player.Player;

public class LevelDesign
{
	public static Level LevelDesign(Player player) 
	{
		Level level1=new Level(2,2);
		level1.addRoomTo(RoomDesign.getRoomDesignOne(player), 0, 0);
		level1.addRoomTo(RoomDesign.getRoomDesignOne(player), 0, 1);
		level1.addRoomTo(RoomDesign.getRoomDesignOne(player), 1, 0);
		level1.addRoomTo(RoomDesign.getRoomDesignOne(player), 1, 1);
		return level1;
	}
}
