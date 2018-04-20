package sprite.item.potion;

import sprite.character.effect.Effect;
import sprite.character.effect.SpeedEffect;

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
		Effect effect = SpeedEffect.SPEED_POTION_EFFECT;
		SpeedPot potion = new SpeedPot("Speed Potion", x, y, "potion", "green", effect, true, 0);
		return potion;
	}
}
