package sprite.item.potion;

import sprite.character.effect.Effect;

public class DamagePot extends Potion
{
	public DamagePot(String fileName, double xLocation, double yLocation, String itemType, String color, 
			Effect effect, boolean isCooledDown, double coolDownTime) 
	{
		super("AttackPot","file:resources/potionPictures/damagePotion.png", xLocation, yLocation, 
				itemType, color, effect, isCooledDown, coolDownTime);
	}

}