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
	public static Room getRoomDesignTest(Level ownerLevel)
	{
		Room room = new Room(ownerLevel);
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
		room.addItem(PotionDesign.getHealthPotDesignOne(140, 120,ownerLevel.getLevelNum()));
		room.addItem(PotionDesign.getHealthPotDesignOne(140, 200,ownerLevel.getLevelNum()));
		room.addItem(PotionDesign.getHealthPotDesignOne(140, 280,ownerLevel.getLevelNum()));
		room.addItem(PotionDesign.getSpeedPotDesignOne(140, 350,ownerLevel.getLevelNum()));
		room.addItem(PotionDesign.getDamagePotDesignOne(140, 420,ownerLevel.getLevelNum()));
		room.addItem(AmmoDesign.getAmmoDesignOne(500, 160));
		//room.addItem(PotionDesign.getSpeedPotDesignOne(900, 800));
		//room.addItem(PotionDesign.getSpeedPotDesignOne(300, 500));
		//room.addItem(PotionDesign.getSpeedPotDesignOne(500, 300));
		//room.addItem(PotionDesign.getSpeedPotDesignOne(100, 700));
		room.addItem(WeaponDesign.getSniperDesignOne(200, 500,ownerLevel.getLevelNum()));
		room.addItem(WeaponDesign.getSniperDesignEPIC(400, 140,ownerLevel.getLevelNum()));
		room.addItem(WeaponDesign.getShotgunDesignOne(100, 500,ownerLevel.getLevelNum()));
		room.addItem(BossAttacks.getBossAtkNine(300, 140,5,-5,ownerLevel.getLevelNum()));
		room.addItem(WeaponDesign.getSwordDesignOne(500, 100,ownerLevel.getLevelNum()));
		room.addItem(WeaponDesign.getAssaultRifleDesignOne(600, 140,ownerLevel.getLevelNum()));
		
		room.addItem(CoinDesign.getCoinFive(700, 140));
		room.addItem(ArmorDesign.getHelmetDesignOne(820, 130,ownerLevel.getLevelNum()));
		room.addItem(ArmorDesign.getBreastPlateDesignOne(820, 230,ownerLevel.getLevelNum()));
		room.addItem(ArmorDesign.getLeggingDesignOne(820, 330,ownerLevel.getLevelNum()));
		room.addItem(ArmorDesign.getBootsDesignOne(820, 430,ownerLevel.getLevelNum()));
		room.addItem(ShieldDesign.getShieldDesignOne(820, 530,ownerLevel.getLevelNum()));
		room.setBossRoom(false);
		room.setAllEnemyDead(true);
		room.setEnemySpawned(true);
		return room;
	}
	
	public static Room getRoomDesignOne(Level ownerLevel)
	{
		Room room = new Room(ownerLevel);
		room.addObstacle(new StoneWall(200,200,200,200,0));
		room.addObstacle(new StoneWall(200,200,200,600,0));
		room.addObstacle(new StoneWall(200,200,600,600,0));
		room.addObstacle(new StoneWall(200,200,600,200,0));
		room.setBossRoom(false);
		room.setAllEnemyDead(true);
		room.setEnemySpawned(true);
		return room;
	}
	
	public static Room getRoomDesignTwo(Level ownerLevel)
	{
		Room room = new Room(ownerLevel);
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
	
	public static Room getShopRoomDesign(Level ownerLevel)
	{
		Room room = new Room(10,11,ownerLevel);
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
		room.addObstacle(new Shop(100,100,200,100,0,ownerLevel.getLevelNum()));
		room.addObstacle(new Shop(100,100,400,100,0,ownerLevel.getLevelNum()));
		room.addObstacle(new Shop(100,100,600,100,0,ownerLevel.getLevelNum()));
		room.addObstacle(new Shop(100,100,800,100,0,ownerLevel.getLevelNum()));
		room.addObstacle(new Shop(100,100,200,300,0,ownerLevel.getLevelNum()));
		room.addObstacle(new Shop(100,100,800,300,0,ownerLevel.getLevelNum()));
		room.setBossRoom(false);
		room.setAllEnemyDead(true);
		room.setEnemySpawned(true);
		return room;
	}
	
	public static Room getRoomDesignThree(Level ownerLevel)
	{
		Room room = new Room(ownerLevel);
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
	
	public static Room getRoomDesignFour(Level ownerLevel)
	{
		Room room = new Room(10,11,ownerLevel);
//		room.addObstacle(new StoneWall(50, 1000,0,0,0));
//		room.addObstacle(new StoneWall(50, 1000,950,0,0));
//		room.addObstacle(new StoneWall(1000, 50,0,0,0));
//		room.addObstacle(new StoneWall(1000, 50,0,950,0));
		//room.addObstacle(new StoneWall(100,500,450,450,0));
		room.addObstacle(new StoneWall(100,500,200,50,0));
		room.addObstacle(new StoneWall(100,500,800,50,0));
		//room.addCharacter(EnemyDesign.getRegularDesignOne(500, 500, player));
		//room.addCharacter(EnemyDesign.getRegularDesignOne(800, 800, player));
		//room.addCharacter(EnemyDesign.getRegularDesignOne(800, 200, player));
		//room.addCharacter(player);
		return room;
	}
	
	public static Room getRoomDesignFive(Level ownerLevel)
	{
		Room room = new Room(ownerLevel);
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
	
	
	public static Room getBossRoomDesignOne(Level ownerLevel)
	{
		Room room = new Room(11,11,ownerLevel);
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
	
	public static Room getRoomDesignSix(Level ownerLevel)
	{
		Room room = new Room(ownerLevel);
//		room.addObstacle(new StoneWall(50, 1000,00,0,0));
//		room.addObstacle(new StoneWall(50, 1000,950,0,0));
//		room.addObstacle(new StoneWall(1000, 50,0,0,0));
//		room.addObstacle(new StoneWall(1000, 50,0,950,0));
		room.addObstacle(new StoneWall(500,50,160,500,0));
		room.addObstacle(new StoneWall(500,50,160,520,0));
		room.addObstacle(new StoneWall(50,160,478,170,0));
		room.addObstacle(new StoneWall(50,90,478,431,0));
		//room.addCharacter(player);
		//room.addCharacter(enemy);
		return room;
	}
	
	public static Room getRoomDesignSeven(Level ownerLevel)
	{
		Room room = new Room(ownerLevel);
		
		room.addObstacle(new StoneWall(50,50,700,200,0));
		room.addObstacle(new StoneWall(50,50,300,200,0));
		room.addObstacle(new StoneWall(50,50,700,800,0));
		room.addObstacle(new StoneWall(50,50,300,800,0));
		room.addObstacle(new StoneWall(50,50,500,500,0));
		return room;
	}
	
	public static Room getRoomDesignEight(Level ownerLevel)
	{
		Room room = new Room(ownerLevel);
		
		room.addObstacle(new StoneWall(600,400,200,300,0));
		return room;
	}
	
	public static Room getRoomDesignNine(Level ownerLevel)
	{
		Room room = new Room(ownerLevel);
		
		room.addObstacle(new StoneWall(600,100,200,300,0));
		room.addObstacle(new StoneWall(100,300,400,400,0));
		return room;
	}
	
	public static Room getRoomDesignTen(Level ownerLevel)
	{
		Room room = new Room(ownerLevel);
		
		room.addObstacle(new StoneWall(300,100,100,700,0));
		room.addObstacle(new StoneWall(100,500,600,100,0));
		room.addObstacle(new StoneWall(300,100,600,700,0));		
		return room;
	}
	
	public static Room getRoomDesignEleven(Level ownerLevel)
	{
		Room room = new Room(ownerLevel);
		return room;
	}
	
	public static Room getRoomDesignTwelve(Level ownerLevel)
	{
		Room room = new Room(ownerLevel);
		room.addObstacle(new StoneWall(100,300,300,100,0));
		room.addObstacle(new StoneWall(100,300,300,600,0));
		room.addObstacle(new StoneWall(100,300,700,100,0));
		room.addObstacle(new StoneWall(100,300,700,600,0));
		room.addObstacle(new StoneWall(100,100,500,500,0));
		return room;
	}
	
	public static Room getRoomDesignThirteen(Level ownerLevel)
	{
		Room room = new Room(ownerLevel);
		room.addObstacle(new StoneWall(100,300,400,100,0));
		room.addObstacle(new StoneWall(100,400,400,500,0));
		//room.addObstacle(new StoneWall(500,100,400,400,0));
		//room.addObstacle(new StoneWall(500,100,400,500,0));
		return room;
	}
	
	public static Room getRoomDesignFourteen(Level ownerLevel)
	{
		Room room = new Room(ownerLevel);
		room.addObstacle(new StoneWall(100,100,500,300,0));
		room.addObstacle(new StoneWall(300,300,300,600,0));
		room.addObstacle(new StoneWall(200,100,700,600,0));
		return room;
	}
	
	public static Room getRoomDesignFifteen(Level ownerLevel)
	{
		Room room = new Room(ownerLevel);
		room.addObstacle(new StoneWall(100,200,400,300,0));
		room.addObstacle(new StoneWall(100,200,400,600,0));
		return room;
	}
	
	public static Room getRoomDesignSixteen(Level ownerLevel)
	{
		Room room = new Room(12,12,ownerLevel);
		room.addObstacle(new StoneWall(100,100,200,500,0));
		room.addObstacle(new StoneWall(100,100,500,300,0));
		room.addObstacle(new StoneWall(100,100,500,500,0));
		room.addObstacle(new StoneWall(100,100,500,700,0));
		room.addObstacle(new StoneWall(100,100,800,500,0));
		return room;
	}
	
	public static Room getRoomDesignSeventeen(Level ownerLevel)
	{
		Room room = new Room(ownerLevel);
		room.addObstacle(new StoneWall(100,700,600,100,0));
		room.addObstacle(new StoneWall(100,100,700,500,0));
		return room;
	}
	
	public static Room getRoomDesignEighteen(Level ownerLevel)
	{
		Room room = new Room(ownerLevel);
		room.addObstacle(new StoneWall(300,500,400,200,0));
		room.addObstacle(new StoneWall(200,100,200,500,0));
		return room;
	}
	
	public static Room getRoomDesignNineteen(Level ownerLevel)
	{
		Room room = new Room(ownerLevel);
		room.addObstacle(new StoneWall(300,100,100,400,0));
		room.addObstacle(new StoneWall(300,100,100,700,0));
		room.addObstacle(new StoneWall(300,100,600,400,0));
		room.addObstacle(new StoneWall(300,100,600,700,0));
		return room;
	}
	
	public static Room getRoomDesignTwenty(Level ownerLevel)
	{
		Room room = new Room(ownerLevel);
		room.addObstacle(new StoneWall(100,500,300,200,0));
		room.addObstacle(new StoneWall(100,100,500,500,0));
		room.addObstacle(new StoneWall(100,500,700,200,0));
		return room;
	}
	
	public static Room getRoomDesignTwentyone(Level ownerLevel)
	{
		Room room = new Room(ownerLevel);
		room.addObstacle(new StoneWall(600,600,200,200,0));
		return room;
	}
	
	public static Room getRoomDesignTwentytwo(Level ownerLevel)
	{
		Room room = new Room(ownerLevel);
		room.addObstacle(new StoneWall(200,600,400,200,0));
		room.addObstacle(new StoneWall(600,200,200,400,0));
		return room;
	}
	
	public static Room getRoomDesignTwentythree(Level ownerLevel)
	{
		Room room = new Room(10,11,ownerLevel);
		room.addObstacle(new StoneWall(200,100,200,300,0));
		room.addObstacle(new StoneWall(200,100,700,300,0));
		room.addObstacle(new StoneWall(100,400,200,400,0));
		room.addObstacle(new StoneWall(100,400,800,300,0));
		room.addObstacle(new StoneWall(200,100,200,700,0));
		room.addObstacle(new StoneWall(200,100,700,700,0));
		return room;
	}
	
	public static Room getRoomDesignTwentyfour(Level ownerLevel)
	{
		Room room = new Room(ownerLevel);
		room.addObstacle(new StoneWall(100,100,500,500,0));
		return room;
	}
	public static Room getRandomRoom(int num,Level ownerLevel)
	{	
		if(num==0)
			return RoomDesign.getRoomDesignOne(ownerLevel);
		if(num==1)
			return RoomDesign.getRoomDesignTwo(ownerLevel);
		if(num==2)
			return RoomDesign.getRoomDesignThree(ownerLevel);
		if(num==3)
			return RoomDesign.getRoomDesignFour(ownerLevel);
		if(num==4)
			return RoomDesign.getRoomDesignFive(ownerLevel);
		if(num==5)
			return RoomDesign.getRoomDesignSeven(ownerLevel);
		if(num==6)
			return RoomDesign.getRoomDesignEight(ownerLevel);
		if(num==7)
			return RoomDesign.getRoomDesignNine(ownerLevel);
		if(num==8)
			return RoomDesign.getRoomDesignTen(ownerLevel);
		if(num==9)
			return RoomDesign.getRoomDesignTwelve(ownerLevel);
		if(num==10)
			return RoomDesign.getRoomDesignThirteen(ownerLevel);
		if(num==11)
			return RoomDesign.getRoomDesignFourteen(ownerLevel);
		if(num==12)
			return RoomDesign.getRoomDesignSixteen(ownerLevel);
		if(num==13)
			return RoomDesign.getRoomDesignSeventeen(ownerLevel);
		if(num==14)
			return RoomDesign.getRoomDesignEighteen(ownerLevel);
		if(num==15)
			return RoomDesign.getRoomDesignNineteen(ownerLevel);
		if(num==16)
			return RoomDesign.getRoomDesignTwenty(ownerLevel);
		if(num==17)
			return RoomDesign.getRoomDesignTwentyone(ownerLevel);
		if(num==18)
			return RoomDesign.getRoomDesignTwentytwo(ownerLevel);
		if(num==19)
			return RoomDesign.getRoomDesignTwentythree(ownerLevel);
		if(num==20)
			return RoomDesign.getShopRoomDesign(ownerLevel);	
		if(num==21)
			return RoomDesign.getBossRoomDesignOne(ownerLevel);	
		return null;
	}
}