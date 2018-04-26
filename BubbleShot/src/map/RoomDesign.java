package map;

import map.Tile.teleporter.Teleporter;
import map.obstacle.StoneWall;
import sprite.character.enemy.Enemy;
import sprite.character.enemy.EnemyDesign;
import sprite.character.player.Player;
import sprite.item.potion.PotionDesign;
import sprite.item.weapon.WeaponDesign;

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
		room.addCharacter(EnemyDesign.getRegularDesignOne(500, 500, player));
		room.addCharacter(EnemyDesign.getRegularDesignOne(800, 800, player));
		room.addCharacter(EnemyDesign.getRegularDesignOne(800, 200, player));
		room.addItem(PotionDesign.getHealthPotDesignOne(60, 120));
		room.addItem(PotionDesign.getHealthPotDesignOne(60, 180));
		room.addItem(PotionDesign.getHealthPotDesignOne(60, 60));
		room.addItem(PotionDesign.getSpeedPotDesignOne(120, 60));
		room.addItem(PotionDesign.getDamagePotDesignOne(180, 60));
		//room.addItem(PotionDesign.getSpeedPotDesignOne(900, 800));
		//room.addItem(PotionDesign.getSpeedPotDesignOne(300, 500));
		//room.addItem(PotionDesign.getSpeedPotDesignOne(500, 300));
		//room.addItem(PotionDesign.getSpeedPotDesignOne(100, 700));
		room.addItem(WeaponDesign.getSniperDesignOne(200, 500));
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
		//room.addCharacter(enemy);
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
		//room.addCharacter(enemy);
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
	
	public static Room getRoomDesignFive(Player player)
	{
		Room room = new Room();
		room.addObstacle(new StoneWall(50, 1000,00,0,0));
		room.addObstacle(new StoneWall(50, 1000,950,0,0));
		room.addObstacle(new StoneWall(1000, 50,0,0,0));
		room.addObstacle(new StoneWall(1000, 50,0,950,0));
		room.addObstacle(new StoneWall(500,50,160,120,0));
		room.addObstacle(new StoneWall(500,50,160,520,0));
		room.addObstacle(new StoneWall(50,160,478,170,0));
		room.addObstacle(new StoneWall(50,90,478,431,0));
		room.addCharacter(player);
		//room.addCharacter(enemy);
		return room;
	}
	
	public static Room getRoomDesignSix(Player player)
	{
		Room room = new Room();
		room.addObstacle(new StoneWall(50, 1000,00,0,0));
		room.addObstacle(new StoneWall(50, 1000,950,0,0));
		room.addObstacle(new StoneWall(1000, 50,0,0,0));
		room.addObstacle(new StoneWall(1000, 50,0,950,0));
		room.addObstacle(new StoneWall(500,50,160,120,0));
		room.addObstacle(new StoneWall(500,50,160,520,0));
		room.addObstacle(new StoneWall(50,160,478,170,0));
		room.addObstacle(new StoneWall(50,90,478,431,0));
		room.addCharacter(player);
		//room.addCharacter(enemy);
		return room;
	}
}