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
		return new Helmet("Helmet", "file:resources/armor/strawhelmet.png", x, y, width, height, maxHealthBoost, maxSpeedBoost, maxDamageBoost);
	}
	
	public static BreastPlate getBreastPlateDesignOne(double x, double y)
	{
		double width = 35;
		double height = 55;
		double maxHealthBoost = 100;
		double maxSpeedBoost = 1;
		double maxDamageBoost = 1.01;
		return new BreastPlate("Helmet", "file:resources/armor/woodbreastplate.png", x, y, width, height, maxHealthBoost, maxSpeedBoost, maxDamageBoost);
	}
}
