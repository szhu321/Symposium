package map;

import map.obstacle.StoneWall;
import sprite.character.player.Player;

public class RoomDesign
{
	public static Room getRoomDesignOne(Player player)
	{
		Room room = new Room();
		room.addObstacle(new StoneWall(50, 1000,0,0));
		room.addObstacle(new StoneWall(50, 1000,950,0));
		room.addObstacle(new StoneWall(1000, 50,0,0));
		room.addObstacle(new StoneWall(1000, 50,0,950));
		room.addObstacle(new StoneWall(200,200,200,200));
		room.addObstacle(new StoneWall(200,200,200,600));
		room.addObstacle(new StoneWall(200,200,600,600));
		room.addObstacle(new StoneWall(200,200,600,200));
		room.addCharacter(player);
		return room;
	}
}
