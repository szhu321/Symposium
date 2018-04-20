package map;

import sprite.character.enemy.Enemy;
import sprite.character.player.Player;

public class LevelDesign
{
	public static Level getLevelDesignOne(Player player, Enemy enemy) 
	{
		Level level1 = new Level(2,2);
		level1.addRoomTo(RoomDesign.getRoomDesignOne(player,enemy), 0, 0);
		level1.addRoomTo(RoomDesign.getRoomDesignTwo(player,enemy), 0, 1);
		level1.addRoomTo(RoomDesign.getRoomDesignThree(player,enemy), 1, 0);
		level1.addRoomTo(RoomDesign.getRoomDesignFour(player,enemy), 1, 1);
		level1.setCurrentRoom(0, 0);
		return level1;
	}
}