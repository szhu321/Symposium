package sprite.item.armor;

public class ArmorDesign 
{
	public static Helmet getHelmetDesignOne(double x, double y)
	{
		double width = 50;
		double height = 50;
		double maxHealthBoost = 100;
		double maxSpeedBoost = 2;
		double maxDamageBoost = 2;
		return new Helmet("Helmet", "file:resources/player/player.png", x, y, width, height, maxHealthBoost, maxSpeedBoost, maxDamageBoost);
	}
}
