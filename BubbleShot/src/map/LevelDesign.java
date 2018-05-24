package map;

import sprite.character.player.Player;

public class LevelDesign
{
	public static Level getLevelDesignOne() 
	{
		Level level1 = new Level(20,20);
		level1.addRoomTo(RoomDesign.getRoomDesignOne(0,0), 0, 0);
		//level1.addRoomTo(RoomDesign.getRoomDesignThree(player,0,1), 0, 1);
		level1.addRoomTo(RoomDesign.getBossRoomDesignOne( 0, 1), 0, 1);
		//level1.addRoomTo(null, 0, 2);
		//level1.addRoomTo(null, 1, 0);
		//level1.addRoomTo(null, 1, 1);
		//level1.addRoomTo(null, 1, 2);
		level1.addRoomTo(RoomDesign.getRoomDesignTwo(0,2), 0, 2);
		level1.addRoomTo(RoomDesign.getRoomDesignThree(1,0), 1, 0);
		level1.addRoomTo(RoomDesign.getRoomDesignThree(1,1), 1, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignThree(player,2,1), 2, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignThree(player,3,1), 3, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignThree(player,4,1), 4, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignThree(player,5,1), 5, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignThree(player,6,1), 6, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignThree(player,7,1), 7, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignThree(player,8,1), 8, 1);
//		level1.addRoomTo(RoomDesign.getRoomDesignThree(player,9,1), 9, 1);
		level1.addRoomTo(RoomDesign.getRoomDesignFive(1,2), 1, 2);
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
		level2.addRoomTo(RoomDesign.getRoomDesignFive(0,0), 0, 0);	
		level2.setCurrentRoom(0, 0);
		return level2;
	}
	
	public static Level getRandomLevelDesign()
	{
		return null;
	}
}