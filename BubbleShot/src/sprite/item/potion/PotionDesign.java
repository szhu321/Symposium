package sprite.item.potion;

public class PotionDesign
{
	public static DamagePot getDamagePotDesignOne()
	{
		return null;
	}
	
	public static HealthPot getHealthPotDesignOne()
	{
		return null;
	}
	
	public static SpeedPot getSpeedPotDesignOne(double x, double y)
	{
		SpeedPot potion = new SpeedPot("Speed Potion", x, y, "potion", "green", "speed", false);
		return potion;
	}
}
