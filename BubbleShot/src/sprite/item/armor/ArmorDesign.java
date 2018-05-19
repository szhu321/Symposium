package sprite.item.armor;

public class ArmorDesign 
{
	public static Helmet getHelmetDesignOne(double x, double y)
	{
		double width = 55;
		double height = 38;
		double maxHealthBoost = 100;
		double maxSpeedBoost = 2;
		double maxDamageBoost = 2;
		return new Helmet("Helmet", "file:resources/armor/strawhelmet.png", x, y, width, height, maxHealthBoost, maxSpeedBoost, maxDamageBoost);
	}
}
