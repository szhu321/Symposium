package map;

import sprite.character.player.Player;

public class LevelDesign
{
	public static Level getLevelDesignOne(Player player) 
	{
		Level level1 = new Level(2,2);
		level1.addRoomTo(RoomDesign.getRoomDesignOne(player), 0, 0);
		level1.addRoomTo(RoomDesign.getRoomDesignTwo(player), 0, 1);
		level1.addRoomTo(RoomDesign.getRoomDesignThree(player), 1, 0);
		level1.addRoomTo(RoomDesign.getRoomDesignFour(player), 1, 1);
		level1.setCurrentRoom(0, 0);
		return level1;
	}
	
	public static Level getLevelDesignTwo(Player player)
	{
		Level level2 = new Level(3,3);
		level2.addRoomTo(RoomDesign.getRoomDesignFive(player), 0, 0);	
		level2.setCurrentRoom(0, 0);
		return level2;
	}
}