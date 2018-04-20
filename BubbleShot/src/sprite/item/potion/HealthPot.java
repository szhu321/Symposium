package sprite.item.potion;

import sprite.character.effect.Effect;

public class HealthPot extends Potion
{
	public HealthPot(String fileName, int xLocation, int yLocation, String itemType, String color, 
			Effect effect, boolean isCooledDown, double coolDownTime) 
	{
		super("","file:resource/potionPictures/healthPotion.png", xLocation, yLocation, 
				itemType, color, effect, isCooledDown, coolDownTime);
	}

}
