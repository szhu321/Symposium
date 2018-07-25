package sprite.item.armor;

import sprite.character.player.Player;

public class ArmorDesign 
{
	public static Helmet getHelmetDesignOne(double x, double y,int levelNum)
	{
		//System.out.println(levelNum);
		//System.out.println("Player Level: " + Player.getCurrentLevel());
		int cost=20+(levelNum-1)*10;
		double width = 55;
		double height = 38;
		double maxHealthBoost = 0/*60+(levelNum-1)*10*/;
		double armorPoints = 10 + (levelNum - 1) * 5;
		double maxSpeedBoost = 1;
		double maxDamageBoost = 1.01;
		return new Helmet("Helmet", "file:resources/armor/strawhelmet.png", x, y, width, height, maxHealthBoost, maxSpeedBoost, maxDamageBoost, armorPoints,cost);
	}
	
	public static BreastPlate getBreastPlateDesignOne(double x, double y,int levelNum)
	{
		//System.out.println(levelNum);
		//System.out.println("Player Level: " + Player.getCurrentLevel());
		int cost=30+(levelNum-1)*10;
		double width = 35;
		double height = 55;
		double maxHealthBoost = 0/*100+(levelNum-1)*10*/;
		double armorPoints = 20 + (levelNum - 1) * 5;
		double maxSpeedBoost = 1;
		double maxDamageBoost = 1.01;
		return new BreastPlate("Breast Plate", "file:resources/armor/woodbreastplate.png", x, y, width, height, maxHealthBoost, maxSpeedBoost, maxDamageBoost, armorPoints,cost);
	}
	
	public static Legging getLeggingDesignOne(double x, double y,int levelNum)
	{
		//System.out.println(levelNum);
		//System.out.println("Player Level: " + Player.getCurrentLevel());
		int cost=25+(levelNum-1)*15;
		double width = 35;
		double height = 60;
		double maxHealthBoost = 0/*70+(levelNum-1)*10*/;
		double armorPoints = 15 + (levelNum - 1) * 5;
		double maxSpeedBoost = 1.05;
		double maxDamageBoost = 1;
		return new Legging("Legging", "file:resources/armor/leatherlegging.png", x, y, width, height, maxHealthBoost, maxSpeedBoost, maxDamageBoost, armorPoints,cost);
	}
	
	public static Boots getBootsDesignOne(double x, double y,int levelNum)
	{
		//System.out.println(levelNum);
		//System.out.println("Player Level: " + Player.getCurrentLevel());
		int cost=20+(levelNum-1)*10;
		double width = 60;
		double height = 37;
		double maxHealthBoost = 0/*40+(levelNum-1)*10*/;
		double armorPoints = 10 + (levelNum - 1) * 5;
		double maxSpeedBoost = 1.1;
		double maxDamageBoost = 1.1;
		return new Boots("Boots", "file:resources/armor/leatherboots.png", x, y, width, height, maxHealthBoost, maxSpeedBoost, maxDamageBoost, armorPoints,cost);
	}
}
