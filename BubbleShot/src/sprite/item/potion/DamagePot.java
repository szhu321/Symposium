package sprite.item.potion;

import sprite.character.effect.Effect;

public class DamagePot extends Potion
{
	public DamagePot(String fileName, int xLocation, int yLocation, String itemType, String color, 
			Effect effect, boolean isCooledDown, double coolDownTime) 
	{
		super("","file:resource/potionPictures/damagePotion.png", xLocation, yLocation, 
				itemType, color, effect, isCooledDown, coolDownTime);
	}

}