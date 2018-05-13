package sprite.item.potion;

import sprite.character.effect.Effect;

public class SpeedPot extends Potion
{
	public SpeedPot(String fileName, double xLocation, double yLocation, String itemType, String color, 
			Effect effect) 
	{
		super("SpeedPot","file:resources/potionPictures/speedPotion.png", xLocation, yLocation, itemType, color, effect);
	}
}
