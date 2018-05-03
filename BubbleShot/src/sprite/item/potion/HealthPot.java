package sprite.item.potion;

import sprite.character.effect.Effect;

public class HealthPot extends Potion
{
	public HealthPot(String fileName, double xLocation, double yLocation, String itemType, String color, 
			Effect effect, boolean isCooledDown, double coolDownTime) 
	{
		super("HealthPot","file:resources/potionPictures/healthPotion.png", xLocation, yLocation, 
				itemType, color, effect, isCooledDown, coolDownTime);
	}

}
