package map;

import java.util.ArrayList;
import java.util.List;

import sprite.character.movement.Coord;
import sprite.character.player.Player;

public class LevelDesign
{
	public static Level getLevelDesignOne() 
	{
		Level level1 = new Level(20,20);
		level1.addRoomTo(RoomDesign.getRoomDesignOne(), 0, 0);
		//level1.addRoomTo(RoomDesign.getRoomDesignThree(player,0,1), 0, 1);
		level1.addRoomTo(RoomDesign.getBossRoomDesignOne(), 0, 1);
		//level1.addRoomTo(null, 0, 2);
		//level1.addRoomTo(null, 1, 0);
		//level1.addRoomTo(null, 1, 1);
		//level1.addRoomTo(null, 1, 2);
		level1.addRoomTo(RoomDesign.getRoomDesignTwo(), 0, 2);
		level1.addRoomTo(RoomDesign.getRoomDesignThree(), 1, 0);
		level1.addRoomTo(RoomDesign.getRoomDesignThree(), 1, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignThree(player,2,1), 2, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignThree(player,3,1), 3, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignThree(player,4,1), 4, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignThree(player,5,1), 5, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignThree(player,6,1), 6, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignThree(player,7,1), 7, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignThree(player,8,1), 8, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignThree(player,9,1), 9, 1);
		level1.addRoomTo(RoomDesign.getRoomDesignFive(), 1, 2);
//		level1.addRoomTo(RoomDesign.getRoomDesignFive(player,10,1), 10, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignFive(player,11,1), 11, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignFive(player,12,1), 12, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignFive(player,13,1), 13, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignFive(player,14,1), 14, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignFive(player,15,1), 15, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignFive(player,16,1), 16, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignFive(player,17,1), 17, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignFive(player,18,1), 18, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignFive(player,19,1), 19, 1);
		level1.setCurrentRoom(0, 0);
		
		level1.getCurrentRoom().setEnemySpawned(true);
		level1.getCurrentRoom().setAllEnemyDead(true);;
		level1.placeTeleportersInLevel();
		return level1;
	}
	
	public static Level getLevelDesignTwo()
	{
		Level level2 = new Level(3,3);
		level2.addRoomTo(RoomDesign.getRoomDesignFive(), 0, 0);	
		level2.setCurrentRoom(0, 0);
		return level2;
	}
	
	public static Level getRandomLevelDesign(int rows, int cols)
	{
		Level level = new Level(rows, cols);
		Room[][] map = level.getMap();
		
		List<Coord> openset = new ArrayList<Coord>();
		List<Coord> closedset = new ArrayList<Coord>();
		List<Coord> finalset = new ArrayList<Coord>();
		
		openset.add(new Coord(0, 0));
		
		while(openset.size() > 0)
		{
			Coord current = openset.get(0);
			
			List<Coord> neighbors = getNeighbors(map, current);
			for(int i = neighbors.size() - 1; i >= 0; i--)
			{
				if(openset.contains(neighbors.get(i)))
				{
					neighbors.remove(i);
				}
			}
			for(int i = neighbors.size() - 1; i >= 0; i--)
			{
				if(closedset.contains(neighbors.get(i)))
				{
					neighbors.remove(i);
				}
			}
			//not finished	
		}
		
		return null;
	}
	
	private static List<Coord> getNeighbors(Room[][] map, Coord current)
	{
		List<Coord> neighbors = new ArrayList<Coord>();
		if(current.getX() + 1 < map[0].length)
			neighbors.add(new Coord(current.getX() + 1, current.getY()));
		if(current.getX() - 1 >= 0)
			neighbors.add(new Coord(current.getX() - 1, current.getY()));
		if(current.getY() + 1 < map.length)
			neighbors.add(new Coord(current.getX(), current.getY() + 1));
		if(current.getY() - 1 >= 0)
			neighbors.add(new Coord(current.getX(), current.getY() - 1));
		return neighbors;
	}
}