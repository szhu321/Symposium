package map;

import map.obstacle.StoneWall;
import sprite.character.player.Player;

public class RoomDesign
{
	public static Room getRoomDesignOne(Player player)
	{
		Room room = new Room();
		room.addObstacle(new StoneWall(50, 1000,0,0,0));
		room.addObstacle(new StoneWall(50, 1000,950,0,0));
		room.addObstacle(new StoneWall(1000, 50,0,0,0));
		room.addObstacle(new StoneWall(1000, 50,0,950,0));
		room.addObstacle(new StoneWall(200,200,200,200,0));
		room.addObstacle(new StoneWall(200,200,200,600,0));
		room.addObstacle(new StoneWall(200,200,600,600,0));
		room.addObstacle(new StoneWall(200,200,600,200,0));
		room.addCharacter(player);
		return room;
	}
	
	public static Room getRoomDesignTwo(Player player)
	{
		Room room = new Room();
		room.addObstacle(new StoneWall(50, 1000,0,0,0));
		room.addObstacle(new StoneWall(50, 1000,950,0,0));
		room.addObstacle(new StoneWall(1000, 50,0,0,0));
		room.addObstacle(new StoneWall(1000, 50,0,950,0));
		room.addObstacle(new StoneWall(600,100,200,450,0));
		room.addObstacle(new StoneWall(100,600,450,200,0));
		room.addCharacter(player);
		return room;
	}
	
	public static Room getRoomDesignThree(Player player)
	{
		Room room = new Room();
		room.addObstacle(new StoneWall(50, 1000,0,0,0));
		room.addObstacle(new StoneWall(50, 1000,950,0,0));
		room.addObstacle(new StoneWall(1000, 50,0,0,0));
		room.addObstacle(new StoneWall(1000, 50,0,950,0));
		room.addCharacter(player);
		return room;
	}
	
	public static Room getRoomDesignFour(Player player)
	{
		Room room = new Room();
		room.addObstacle(new StoneWall(50, 1000,0,0,0));
		room.addObstacle(new StoneWall(50, 1000,950,0,0));
		room.addObstacle(new StoneWall(1000, 50,0,0,0));
		room.addObstacle(new StoneWall(1000, 50,0,950,0));
		room.addObstacle(new StoneWall(100,500,450,450,0));
		room.addObstacle(new StoneWall(100,500,200,50,0));
		room.addObstacle(new StoneWall(100,500,700,50,0));
		room.addCharacter(player);
		return room;
	}
}
