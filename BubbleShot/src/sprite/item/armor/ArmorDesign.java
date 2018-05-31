package sprite.item.armor;

public class ArmorDesign 
{
	public static Helmet getHelmetDesignOne(double x, double y)
	{
		double width = 55;
		double height = 38;
		double maxHealthBoost = 60;
		double maxSpeedBoost = 1;
		double maxDamageBoost = 1.01;
		return new Helmet("Helmet", "file:resources/armor/strawhelmet.png", x, y, width, height, maxHealthBoost, maxSpeedBoost, maxDamageBoost,5);
	}
	
	public static BreastPlate getBreastPlateDesignOne(double x, double y)
	{
		double width = 35;
		double height = 55;
		double maxHealthBoost = 100;
		double maxSpeedBoost = 1;
		double maxDamageBoost = 1.01;
		return new BreastPlate("Breast Plate", "file:resources/armor/woodbreastplate.png", x, y, width, height, maxHealthBoost, maxSpeedBoost, maxDamageBoost,5);
	}
	
	public static Legging getLeggingDesignOne(double x, double y)
	{
		double width = 35;
		double height = 60;
		double maxHealthBoost = 70;
		double maxSpeedBoost = 1.05;
		double maxDamageBoost = 1;
		return new Legging("Legging", "file:resources/armor/leatherlegging.png", x, y, width, height, maxHealthBoost, maxSpeedBoost, maxDamageBoost,5);
	}
	
	public static Boots getBootsDesignOne(double x, double y)
	{
		double width = 60;
		double height = 37;
		double maxHealthBoost = 40;
		double maxSpeedBoost = 1.1;
		double maxDamageBoost = 1.1;
		return new Boots("Boots", "file:resources/armor/leatherboots.png", x, y, width, height, maxHealthBoost, maxSpeedBoost, maxDamageBoost,5);
	}
}
