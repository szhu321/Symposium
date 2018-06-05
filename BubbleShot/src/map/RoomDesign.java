package map;

import map.obstacle.Shop;
import map.obstacle.StoneWall;
import sprite.character.enemy.EnemyDesign;
import sprite.character.player.Player;
import sprite.item.ammo.AmmoDesign;
import sprite.item.armor.ArmorDesign;
import sprite.item.collectable.CoinDesign;
import sprite.item.potion.PotionDesign;
import sprite.item.shield.ShieldDesign;
import sprite.item.weapon.BossAttacks;
import sprite.item.weapon.WeaponDesign;

public class RoomDesign
{
	public static Room getRoomDesignOne()
	{
		Room room = new Room();
//		room.addObstacle(new StoneWall(50, 1000,0,0,0));
//		room.addObstacle(new StoneWall(50, 1000,950,0,0));
//		room.addObstacle(new StoneWall(1000, 50,0,0,0));
//		room.addObstacle(new StoneWall(1000, 50,0,950,0));
		room.addObstacle(new StoneWall(200,200,200,200,0));
		room.addObstacle(new StoneWall(200,200,200,600,0));
		room.addObstacle(new StoneWall(200,200,600,600,0));
		room.addObstacle(new StoneWall(200,200,600,200,0));
		//room.addCharacter(player);
		//room.addCharacter(EnemyDesign.getRegularDesignOne(500, 500, player));
		//room.addCharacter(EnemyDesign.getRegularDesignOne(800, 800, player));
	//	room.addCharacter(EnemyDesign.getRegularDesignOne(810, 200, player));
		room.addItem(PotionDesign.getHealthPotDesignOne(140, 120));
		room.addItem(PotionDesign.getHealthPotDesignOne(140, 200));
		room.addItem(PotionDesign.getHealthPotDesignOne(140, 280));
		room.addItem(PotionDesign.getSpeedPotDesignOne(140, 350));
		room.addItem(PotionDesign.getDamagePotDesignOne(140, 420));
		room.addItem(AmmoDesign.getAmmoDesignOne(500, 160));
		//room.addItem(PotionDesign.getSpeedPotDesignOne(900, 800));
		//room.addItem(PotionDesign.getSpeedPotDesignOne(300, 500));
		//room.addItem(PotionDesign.getSpeedPotDesignOne(500, 300));
		//room.addItem(PotionDesign.getSpeedPotDesignOne(100, 700));
		room.addItem(WeaponDesign.getSniperDesignOne(200, 500));
		room.addItem(WeaponDesign.getSniperDesignEPIC(400, 140));
		room.addItem(WeaponDesign.getShotgunDesignOne(100, 500));
		room.addItem(BossAttacks.getBossAtkThree(300, 140));
		room.addItem(WeaponDesign.getSwordDesignOne(500, 100));
		room.addItem(WeaponDesign.getAssaultRifleDesignOne(600, 140));
		
		room.addItem(CoinDesign.getCoinFive(700, 140));
		room.addItem(ArmorDesign.getHelmetDesignOne(820, 130));
		room.addItem(ArmorDesign.getBreastPlateDesignOne(820, 230));
		room.addItem(ArmorDesign.getLeggingDesignOne(820, 330));
		room.addItem(ArmorDesign.getBootsDesignOne(820, 430));
		room.addItem(ShieldDesign.getShieldDesignOne(820, 530));
		
		return room;
	}
	
	public static Room getRoomDesignTwo()
	{
		Room room = new Room();
//		room.addObstacle(new StoneWall(50, 1000,0,0,0));
//		room.addObstacle(new StoneWall(50, 1000,950,0,0));
//		room.addObstacle(new StoneWall(1000, 50,0,0,0));
//		room.addObstacle(new StoneWall(1000, 50,0,950,0));
		room.addObstacle(new StoneWall(600,100,200,450,0));
		room.addObstacle(new StoneWall(100,600,450,200,0));
		//room.addCharacter(EnemyDesign.getRegularDesignOne(500, 500, player));
		//room.addCharacter(EnemyDesign.getRegularDesignOne(800, 800, player));
		//room.addCharacter(EnemyDesign.getRegularDesignOne(800, 200, player));
		//room.addCharacter(player);
		//room.addCharacter(enemy);
		return room;
	}
	
	public static Room getShopRoomDesign()
	{
		Room room = new Room();
		room.setShopRoom(true);
//		room.addObstacle(new StoneWall(50, 1000,0,0,0));
//		room.addObstacle(new StoneWall(50, 1000,950,0,0));
//		room.addObstacle(new StoneWall(1000, 50,0,0,0));
//		room.addObstacle(new StoneWall(1000, 50,0,950,0));
		//room.addCharacter(EnemyDesign.getRegularDesignOne(500, 500, player));
		//room.addCharacter(EnemyDesign.getRegularDesignOne(800, 800, player));
		//room.addCharacter(EnemyDesign.getRegularDesignOne(800, 200, player));
		//room.addCharacter(player);
		//room.addCharacter(enemy);
		room.addObstacle(new Shop(100,100,200,100,0));
		room.addObstacle(new Shop(100,100,400,100,0));
		room.addObstacle(new Shop(100,100,600,100,0));
		room.addObstacle(new Shop(100,100,800,100,0));
		room.addObstacle(new Shop(100,100,200,300,0));
		return room;
	}
	
	public static Room getRoomDesignThree()
	{
		Room room = new Room();
//		room.addObstacle(new StoneWall(50, 1000,0,0,0));
//		room.addObstacle(new StoneWall(50, 1000,950,0,0));
//		room.addObstacle(new StoneWall(1000, 50,0,0,0));
//		room.addObstacle(new StoneWall(1000, 50,0,950,0));
		//room.addCharacter(EnemyDesign.getRegularDesignOne(500, 500, player));
		//room.addCharacter(EnemyDesign.getRegularDesignOne(800, 800, player));
		//room.addCharacter(EnemyDesign.getRegularDesignOne(800, 200, player));
		//room.addCharacter(player);
		//room.addCharacter(enemy);
		return room;
	}
	
	public static Room getRoomDesignFour()
	{
		Room room = new Room();
//		room.addObstacle(new StoneWall(50, 1000,0,0,0));
//		room.addObstacle(new StoneWall(50, 1000,950,0,0));
//		room.addObstacle(new StoneWall(1000, 50,0,0,0));
//		room.addObstacle(new StoneWall(1000, 50,0,950,0));
		room.addObstacle(new StoneWall(100,500,450,450,0));
		room.addObstacle(new StoneWall(100,500,200,50,0));
		room.addObstacle(new StoneWall(100,500,700,50,0));
		//room.addCharacter(EnemyDesign.getRegularDesignOne(500, 500, player));
		//room.addCharacter(EnemyDesign.getRegularDesignOne(800, 800, player));
		//room.addCharacter(EnemyDesign.getRegularDesignOne(800, 200, player));
		//room.addCharacter(player);
		return room;
	}
	
	public static Room getRoomDesignFive()
	{
		Room room = new Room();
//		room.addObstacle(new StoneWall(50, 1000,00,0,0));
//		room.addObstacle(new StoneWall(50, 1000,950,0,0));
//		room.addObstacle(new StoneWall(1000, 50,0,0,0));
//		room.addObstacle(new StoneWall(1000, 50,0,950,0));
//		room.addObstacle(new StoneWall(500,50,160,120,0));
		room.addObstacle(new StoneWall(500,50,160,520,0));
		room.addObstacle(new StoneWall(50,160,478,170,0));
		room.addObstacle(new StoneWall(50,90,478,431,0));
		//room.addCharacter(player);
		//room.addCharacter(enemy);
		return room;
	}
	
	
	public static Room getBossRoomDesignOne()
	{
		Room room = new Room();
		room.setBossRoom(true);
		//room.addObstacle(new StoneWall(50, 1000,00,0,0));
		//room.addObstacle(new StoneWall(50, 1000,950,0,0));
		//room.addObstacle(new StoneWall(1000, 50,0,0,0));
		//room.addObstacle(new StoneWall(1000, 50,0,950,0));
		//room.addObstacle(new StoneWall(500,50,160,120,0));
		//room.addObstacle(new StoneWall(500,50,160,520,0));
		//room.addObstacle(new StoneWall(50,160,478,170,0));
		//room.addObstacle(new StoneWall(50,90,478,431,0));
		//room.addCharacter(player);
		//room.addCharacter(enemy);
		return room;
	}
	
	public static Room getRoomDesignSix()
	{
		Room room = new Room();
//		room.addObstacle(new StoneWall(50, 1000,00,0,0));
//		room.addObstacle(new StoneWall(50, 1000,950,0,0));
//		room.addObstacle(new StoneWall(1000, 50,0,0,0));
//		room.addObstacle(new StoneWall(1000, 50,0,950,0));
		room.addObstacle(new StoneWall(500,50,160,120,0));
		room.addObstacle(new StoneWall(500,50,160,520,0));
		room.addObstacle(new StoneWall(50,160,478,170,0));
		room.addObstacle(new StoneWall(50,90,478,431,0));
		//room.addCharacter(player);
		//room.addCharacter(enemy);
		return room;
	}
	
	public static Room getRoomDesignSeven()
	{
		Room room = new Room();
		
		room.addObstacle(new StoneWall(50,50,700,200,0));
		room.addObstacle(new StoneWall(50,50,300,200,0));
		room.addObstacle(new StoneWall(50,50,700,800,0));
		room.addObstacle(new StoneWall(50,50,300,800,0));
		room.addObstacle(new StoneWall(50,50,500,500,0));
		return room;
	}
	
	public static Room getRoomDesignEight()
	{
		Room room = new Room();
		
		room.addObstacle(new StoneWall(600,400,200,300,0));
		return room;
	}
	
	public static Room getRoomDesignNine()
	{
		Room room = new Room();
		
		room.addObstacle(new StoneWall(600,100,200,300,0));
		room.addObstacle(new StoneWall(100,300,400,400,0));
		return room;
	}
	
	public static Room getRoomDesignTen()
	{
		Room room = new Room();
		
		room.addObstacle(new StoneWall(100,100,400,700,0));
		room.addObstacle(new StoneWall(0,500,600,100,0));
		room.addObstacle(new StoneWall(300,0,600,700,0));		
		return room;
	}
	
	public static Room getRoomDesignEleven()
	{
		Room room = new Room();
		return room;
	}
	
	public static Room getRoomDesignTwelve()
	{
		Room room = new Room();
		room.addObstacle(new StoneWall(0,300,300,100,0));
		room.addObstacle(new StoneWall(0,300,300,600,0));
		room.addObstacle(new StoneWall(0,300,700,100,0));
		room.addObstacle(new StoneWall(0,300,700,600,0));
		room.addObstacle(new StoneWall(100,100,500,500,0));
		return room;
	}
	
	public static Room getRoomDesignThirteen()
	{
		Room room = new Room();
		room.addObstacle(new StoneWall(0,300,400,100,0));
		room.addObstacle(new StoneWall(0,400,400,500,0));
		room.addObstacle(new StoneWall(500,0,400,400,0));
		room.addObstacle(new StoneWall(500,0,400,500,0));
		return room;
	}
	
	public static Room getRoomDesignFourteen()
	{
		Room room = new Room();
		room.addObstacle(new StoneWall(100,100,500,300,0));
		room.addObstacle(new StoneWall(300,300,300,600,0));
		room.addObstacle(new StoneWall(200,100,700,600,0));
		return room;
	}
	
	public static Room getRoomDesignFifteen()
	{
		Room room = new Room();
		room.addObstacle(new StoneWall(100,200,400,300,0));
		room.addObstacle(new StoneWall(100,200,400,600,0));
		return room;
	}
	
	public static Room getRoomDesignSixteen()
	{
		Room room = new Room();
		room.addObstacle(new StoneWall(100,100,200,500,0));
		room.addObstacle(new StoneWall(100,100,500,300,0));
		room.addObstacle(new StoneWall(100,100,500,500,0));
		room.addObstacle(new StoneWall(100,100,500,700,0));
		room.addObstacle(new StoneWall(100,100,800,500,0));
		return room;
	}
	
	public static Room getRoomDesignSeventeen()
	{
		Room room = new Room();
		room.addObstacle(new StoneWall(0,700,600,100,0));
		room.addObstacle(new StoneWall(100,100,700,500,0));
		return room;
	}
	
	public static Room getRoomDesignEighteen()
	{
		Room room = new Room();
		room.addObstacle(new StoneWall(300,500,400,200,0));
		room.addObstacle(new StoneWall(200,100,200,500,0));
		return room;
	}
	
	public static Room getRoomDesignNineteen()
	{
		Room room = new Room();
		room.addObstacle(new StoneWall(300,0,100,400,0));
		room.addObstacle(new StoneWall(300,0,100,700,0));
		room.addObstacle(new StoneWall(300,0,600,400,0));
		room.addObstacle(new StoneWall(300,0,600,700,0));
		return room;
	}
	
	public static Room getRoomDesignTwenty()
	{
		Room room = new Room();
		room.addObstacle(new StoneWall(100,500,300,200,0));
		room.addObstacle(new StoneWall(100,100,500,500,0));
		room.addObstacle(new StoneWall(100,500,700,200,0));
		return room;
	}
	
	public static Room getRoomDesignTwentyone()
	{
		Room room = new Room();
		room.addObstacle(new StoneWall(600,600,200,200,0));
		return room;
	}
	
	public static Room getRoomDesignTwentytwo()
	{
		Room room = new Room();
		room.addObstacle(new StoneWall(200,600,400,200,0));
		room.addObstacle(new StoneWall(600,200,200,400,0));
		return room;
	}
	
	public static Room getRoomDesignTwentythree()
	{
		Room room = new Room();
		room.addObstacle(new StoneWall(200,0,200,300,0));
		room.addObstacle(new StoneWall(200,0,600,300,0));
		room.addObstacle(new StoneWall(0,400,200,300,0));
		room.addObstacle(new StoneWall(0,400,800,300,0));
		room.addObstacle(new StoneWall(200,0,200,700,0));
		room.addObstacle(new StoneWall(200,0,600,700,0));
		return room;
	}
	
	public static Room getRoomDesignTwentyfour()
	{
		Room room = new Room();
		room.addObstacle(new StoneWall(100,100,500,500,0));
		return room;
	}
}