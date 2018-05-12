package sprite.item.ammo;

import sprite.character.effect.AmmoEffect;
import sprite.character.effect.Effect;
import sprite.item.Item;

public class AmmoDesign 
{
	public static Ammo getAmmoDesignOne(double x, double y)
	{
		Effect effect = AmmoEffect.AMMO_MAGAZINE_EFFECT;
		Ammo potion = new Ammo("Ammo mag", "file:resources/ammo/ammomag.png", x, y, Item.POTION, true, 0, 35, 40, effect);
		return potion;
	}
}
