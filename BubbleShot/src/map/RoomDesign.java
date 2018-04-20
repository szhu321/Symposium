package map;

import map.obstacle.StoneWall;
import sprite.character.enemy.Enemy;
import sprite.character.enemy.EnemyDesign;
import sprite.character.player.Player;
import sprite.item.potion.PotionDesign;

public class RoomDesign
{
	public static Room getRoomDesignOne(Player player, Enemy enemy)
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
		room.addCharacter(enemy);
		room.addItem(PotionDesign.getSpeedPotDesignOne(420, 420));
		room.addItem(PotionDesign.getSpeedPotDesignOne(60, 60));
		room.addItem(PotionDesign.getSpeedPotDesignOne(700, 60));
		room.addItem(PotionDesign.getSpeedPotDesignOne(900, 800));
		room.addItem(PotionDesign.getSpeedPotDesignOne(300, 500));
		room.addItem(PotionDesign.getSpeedPotDesignOne(500, 300));
		room.addItem(PotionDesign.getSpeedPotDesignOne(100, 700));
		return room;
	}
	
	public static Room getRoomDesignTwo(Player player, Enemy enemy)
	{
		Room room = new Room();
		room.addObstacle(new StoneWall(50, 1000,0,0,0));
		room.addObstacle(new StoneWall(50, 1000,950,0,0));
		room.addObstacle(new StoneWall(1000, 50,0,0,0));
		room.addObstacle(new StoneWall(1000, 50,0,950,0));
		room.addObstacle(new StoneWall(600,100,200,450,0));
		room.addObstacle(new StoneWall(100,600,450,200,0));
		room.addCharacter(player);
		room.addCharacter(enemy);
		return room;
	}
	
	public static Room getRoomDesignThree(Player player, Enemy enemy)
	{
		Room room = new Room();
		room.addObstacle(new StoneWall(50, 1000,0,0,0));
		room.addObstacle(new StoneWall(50, 1000,950,0,0));
		room.addObstacle(new StoneWall(1000, 50,0,0,0));
		room.addObstacle(new StoneWall(1000, 50,0,950,0));
		room.addCharacter(player);
		room.addCharacter(enemy);
		return room;
	}
	
	public static Room getRoomDesignFour(Player player, Enemy enemy)
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
		room.addCharacter(enemy);
		return room;
	}
}