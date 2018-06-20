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
		Level level1 = new Level(20,20,1);
		level1.addRoomTo(RoomDesign.getRoomDesignTest(), 0, 0);
		//level1.addRoomTo(RoomDesign.getRoomDesignThree(player,0,1), 0, 1);
		//level1.addRoomTo(RoomDesign.getBossRoomDesignOne(), 0, 1);
		//level1.addRoomTo(null, 0, 2);
		//level1.addRoomTo(null, 1, 0);
		//level1.addRoomTo(null, 1, 1);
		//level1.addRoomTo(null, 1, 2);
		level1.addRoomTo(RoomDesign.getRoomDesignTwo(), 0, 1);
		level1.addRoomTo(RoomDesign.getRoomDesignThree(), 0, 2);
		level1.addRoomTo(RoomDesign.getShopRoomDesign(), 1, 0);
		level1.addRoomTo(RoomDesign.getRoomDesignFive(), 1, 1);
		level1.addRoomTo(RoomDesign.getBossRoomDesignOne(), 1, 2);
		level1.setCurrentRoom(0, 0);
		
		level1.getCurrentRoom().setEnemySpawned(true);
		level1.getCurrentRoom().setAllEnemyDead(true);;
		level1.placeTeleportersInLevel();
		return level1;
	}
	
	public static Level getLevelDesignTwo()
	{
		Level level2 = new Level(3,3,1);
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
		Level level3 = new Level(4,4,1);
		level3.addRoomTo(RoomDesign.getRoomDesignThirteen(), 0, 0);
		level3.addRoomTo(RoomDesign.getRoomDesignThree(), 0, 1);
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
		Level level2 = new Level(1,2,1);
		level2.addRoomTo(RoomDesign.getRoomDesignTest(), 0, 0);	
		level2.addRoomTo(RoomDesign.getBossRoomDesignOne(), 1, 0);	
		level2.placeTeleportersInLevel();
		level2.setCurrentRoom(0, 0);
		return level2;
	}
	
	/**
	 * Makes a random Level with random Rooms
	 * @param rows amount of rows in the level
	 * @param cols amount of cols in the level
	 * @return randomly generated Level
	 */
	public static Level getRandomLevelDesign(int rows, int cols,int num)
	{
		Level newLevel = new Level(rows,cols,num);
		Room[][] map = newLevel.getMap();
		List<Coord> tilesCoords=new ArrayList<Coord>();
		//Sets the current room to the middle of the level
		map[rows/2][cols/2]=RoomDesign.getRoomDesignTest();
		map[rows/2][cols/2].setLevelRow(rows/2);
		map[rows/2][cols/2].setLevelCol(cols/2);
		newLevel.setCurrentRoom(rows/2,cols/2);
		newLevel.getCurrentRoom().setEnemySpawned(true);
		newLevel.getCurrentRoom().setAllEnemyDead(true);
		//Amount of rooms to be generated
//		int[][] testmap= new int[rows][cols];
//		map[rows/2][cols/2]=1;
//		for(int i=0;i<testmap.length;i++)
//		{
//			for(int s=0;s<testmap[0].length;s++)
//			{
//				if(testmap[i][s]!=1)
//					testmap[i][s]=0;
//			}
//		}
		int roomCounter=MyMath.getRandomInteger(5, rows*cols-1);
		int bossRoom=1;
		int shopRoom=roomCounter/7;
		while(roomCounter>0)
		{
			//System.out.println(roomCounter);
			//Goes through entire map array
			for(int i=0;i<rows;i++)
			{
				for(int s=0;s<cols;s++)
				{
					boolean up=true;
					boolean down=true;
					boolean left=true;
					boolean right=true;
					if(roomCounter==0)
						break;
					if(map[i][s]!=null)
					{
						//Chance of the current Room being a room
						
						//Checks neighbors if null
						if(i==0)
							up=false;
						if(s==0)
							left=false;
						if(i==rows-1)
							down=false;
						if(s==cols-1)
							right=false;;	
						int roomdirection=(int)(Math.random()*4);
						int roomType=(int)(Math.random()*20);
						if(roomdirection==0&&up&&map[i-1][s]==null)
						{
							newLevel.addRoomTo(RoomDesign.getRandomRoom(roomType),i-1,s);
							tilesCoords.add(new Coord(i-1,s));
//							testmap[i-1][s]=1;
							roomCounter--;
						}
						if(roomdirection==1&&right&&map[i][s+1]==null)
						{
							newLevel.addRoomTo(RoomDesign.getRandomRoom(roomType),i,s+1);
							tilesCoords.add(new Coord(i,s+1));
//							testmap[i][s+1]=1;
							roomCounter--;
						}
						if(roomdirection==2&&down&&map[i+1][s]==null)
						{
							newLevel.addRoomTo(RoomDesign.getRandomRoom(roomType),i+1,s);
							tilesCoords.add(new Coord(i+1,s));
//							testmap[i+1][s]=1;
							roomCounter--;
						}
						if(roomdirection==3&&left&&map[i][s-1]==null)
						{
							//testmap[i][s-1]=1;
							newLevel.addRoomTo(RoomDesign.getRandomRoom(roomType),i,s-1);
							tilesCoords.add(new Coord(i,s-1));
							roomCounter--;
						}						
					}
				}
				if(roomCounter==0)
					break;
			}
		}
//		for(int i=0;i<testmap.length;i++)
//		{
//			String halp="";
//			for(int s=0;s<testmap[0].length;s++)
//			{
//				halp+=testmap[i][s]+" ";
//			}
//			System.out.println(halp);
//		}
		for(int i=tilesCoords.size()-1;i>-1;i--)
		{
			if(bossRoom==0&&shopRoom==0)
				break;
			int randCoord=(int)(Math.random()*tilesCoords.size());
			Coord currentCord=tilesCoords.get(randCoord);
			tilesCoords.remove(randCoord);
			int roomType=0;
			if(bossRoom>0)
			{
				bossRoom--;
				roomType=21;
			}else if(shopRoom>0)
			{
				shopRoom--;
				roomType=20;
			}
			newLevel.addRoomTo(RoomDesign.getRandomRoom(roomType),currentCord.getX(),currentCord.getY());
		}
		newLevel.placeTeleportersInLevel();
//	newLevel=LevelDesign.getLevelDesignOne();
		return newLevel;
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