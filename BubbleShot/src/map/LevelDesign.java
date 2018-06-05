package map;

import java.util.ArrayList;
import java.util.List;

import myutilities.MyMath;
import sprite.character.movement.Coord;
import sprite.character.player.Player;

public class LevelDesign
{
	public static Level getLevelDesignOne() 
	{
		Level level1 = new Level(20,20);
		level1.addRoomTo(RoomDesign.getRoomDesignOne(), 0, 0);
		//level1.addRoomTo(RoomDesign.getRoomDesignThree(player,0,1), 0, 1);
		//level1.addRoomTo(RoomDesign.getBossRoomDesignOne(), 0, 1);
		//level1.addRoomTo(null, 0, 2);
		//level1.addRoomTo(null, 1, 0);
		//level1.addRoomTo(null, 1, 1);
		//level1.addRoomTo(null, 1, 2);
		level1.addRoomTo(RoomDesign.getRoomDesignTwo(), 0, 1);
		level1.addRoomTo(RoomDesign.getRoomDesignThree(), 0, 2);
		level1.addRoomTo(RoomDesign.getShopRoomDesign(), 1, 0);
//		level1.addRoomTo(RoomDesign.getRoomDesignThree(player,2,1), 2, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignThree(player,3,1), 3, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignThree(player,4,1), 4, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignThree(player,5,1), 5, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignThree(player,6,1), 6, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignThree(player,7,1), 7, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignThree(player,8,1), 8, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignThree(player,9,1), 9, 1);
		level1.addRoomTo(RoomDesign.getRoomDesignFive(), 1, 1);
		level1.addRoomTo(RoomDesign.getBossRoomDesignOne(), 1, 2);
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
		level2.addRoomTo(RoomDesign.getRoomDesignSix(), 0, 0);	
		level2.addRoomTo(RoomDesign.getRoomDesignSeven(), 0, 2);	
		level2.addRoomTo(RoomDesign.getRoomDesignEight(), 1, 0);
		level2.addRoomTo(RoomDesign.getRoomDesignNine(), 1, 1);
		level2.addRoomTo(RoomDesign.getRoomDesignTen(), 1, 2);
		level2.addRoomTo(RoomDesign.getRoomDesignEleven(), 2, 0);
		level2.addRoomTo(RoomDesign.getRoomDesignTwelve(), 2, 2);
		level2.setCurrentRoom(2, 2);
		return level2;
	}
	
	public static Level getLevelDesignThree()
	{
		Level level3 = new Level(4,4);
		level3.addRoomTo(RoomDesign.getRoomDesignThirteen(), 0, 0);
		level3.addRoomTo(RoomDesign.getRoomDesignFourteen(), 0, 1);
		level3.addRoomTo(RoomDesign.getRoomDesignFifteen(), 0, 3);
		level3.addRoomTo(RoomDesign.getRoomDesignSixteen(), 1, 1);
		level3.addRoomTo(RoomDesign.getRoomDesignSeventeen(), 1, 2);
		level3.addRoomTo(RoomDesign.getRoomDesignEighteen(), 1, 3);
		level3.addRoomTo(RoomDesign.getRoomDesignNineteen(), 2, 0);
		level3.addRoomTo(RoomDesign.getRoomDesignTwenty(), 2, 1);
		level3.addRoomTo(RoomDesign.getRoomDesignTwentyone(), 2, 3);
		level3.addRoomTo(RoomDesign.getRoomDesignTwentytwo(), 3, 0);
		level3.addRoomTo(RoomDesign.getRoomDesignTwentythree(), 3, 2);
		level3.addRoomTo(RoomDesign.getRoomDesignTwentyfour(), 3, 3);
		level3.setCurrentRoom(3,3);
		return level3;
	}
	
	public static Level getLevelTestBoss()
	{
		Level level2 = new Level(1,2);
		level2.addRoomTo(RoomDesign.getRoomDesignOne(), 0, 0);	
		level2.addRoomTo(RoomDesign.getBossRoomDesignOne(), 1, 0);	
		level2.placeTeleportersInLevel();
		level2.setCurrentRoom(0, 0);
		return level2;
	}
	
	public static Level getRandomLevelDesign(int rows, int cols)
	{
		Level level = new Level(rows, cols);
		Room[][] map = level.getMap();
		Coord[][] coords = new Coord[rows][cols];
		for(int y = 0; y < rows; y++)
		{
			for(int x = 0; x < cols; x++)
			{
				coords[y][x] = new Coord(x, y);
			}
		}
		
		List<Coord> openset = new ArrayList<Coord>();
		List<Coord> closedset = new ArrayList<Coord>();
		List<Coord> finalset = new ArrayList<Coord>();
		
		//The map starts generating here
		openset.add(coords[0][0]);
		
		while(openset.size() > 0)
		{
			Coord current = openset.get(0);
			
			System.out.println("current:" + current);
			
			List<Coord> neighbors = getNeighbors(map, current, coords);
			
			for(Coord coor: neighbors)
				System.out.println("neighbor:" + coor);
			
			//if the openset or closedset contains the neighbor remove it.
			for(int i = neighbors.size() - 1; i >= 0; i--)
			{
				if(openset.contains(neighbors.get(i)))
					neighbors.remove(i);
				else if(closedset.contains(neighbors.get(i)))
					neighbors.remove(i);
			}
			
			
			//if there are multiple neighbors there is a chance of adding it to the openset.
			
//			List<Coord> shuffledNeighbors = new ArrayList<Coord>();
//			while(neighbors.size() > 0)
//			{
//				shuffledNeighbors.add(neighbors.remove(MyMath.getRandomInteger(0, neighbors.size() - 1)));
//			}
			if(neighbors.size() > 0)
			{
				int addAmount = MyMath.getRandomInteger(1, neighbors.size());
				for(int i = 0; i < addAmount; i++)
				{
					openset.add(neighbors.get(i));
				}
			}
			
			
			for(Coord coor: neighbors)
				System.out.println("non removed neighbor:" + coor);
			
			openset.remove(current);
			finalset.add(current);
			closedset.add(current);
			
			for(Coord coor: closedset)
				System.out.println("closed:" + coor);
			for(Coord coor: openset)
				System.out.println("openend:" + coor);
			System.out.println();
		}
		
		for(Coord coor: finalset)
			System.out.println(coor);
		return null;
	}
	
	private static List<Coord> getNeighbors(Room[][] map, Coord current, Coord[][] allCoords)
	{
		List<Coord> neighbors = new ArrayList<Coord>();
		if(current.getX() + 1 < map[0].length)
			neighbors.add(allCoords[current.getY()][current.getX() + 1]);
		if(current.getX() - 1 >= 0)
			neighbors.add(allCoords[current.getY()][current.getX() - 1]);
		if(current.getY() + 1 < map.length)
			neighbors.add(allCoords[current.getY() + 1][current.getX()]);
		if(current.getY() - 1 >= 0)
			neighbors.add(allCoords[current.getY() - 1][current.getX()]);
		return neighbors;
	}
}