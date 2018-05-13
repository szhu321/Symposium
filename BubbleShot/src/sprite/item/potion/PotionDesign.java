package sprite.item.potion;

import sprite.character.effect.DamageEffect;
import sprite.character.effect.Effect;
import sprite.character.effect.HealthEffect;
import sprite.character.effect.SpeedEffect;

public class PotionDesign
{
	public static DamagePot getDamagePotDesignOne(double x, double y)
	{
		Effect effect = DamageEffect.DAMAGE_POTION_EFFECT;
		DamagePot potion = new DamagePot("Damage Potion",x,y,"potion","pink",effect);
		return potion;
	}
	
	public static HealthPot getHealthPotDesignOne(double x, double y)
	{
		Effect effect = HealthEffect.HEALTH_POTION_EFFECT;
		HealthPot potion = new HealthPot("Health Potion",x,y,"potion","red",effect);
		return potion;
	}
	
	public static SpeedPot getSpeedPotDesignOne(double x, double y)
	{
		Effect effect = SpeedEffect.SPEED_POTION_EFFECT;
		SpeedPot potion = new SpeedPot("Speed Potion", x, y, "potion", "green", effect);
		return potion;
	}
}
