package sprite.item.potion;

import sprite.character.effect.Effect;

public class SpeedPot extends Potion
{
	public SpeedPot(String fileName, double xLocation, double yLocation, String itemType, String color, 
			Effect effect,int cost) 
	{
		super("SpeedPot","file:resources/potionPictures/speedPotion.png", xLocation, yLocation, itemType, color, effect,cost);
	}
	
	public String description()
	{
		Effect potionEffect = getEffect();
		if(potionEffect.isInstantaneous())
		{
			return this.getSpriteName()+"\n"+"\n"
					+ "Speed Multiplier: " + "X" + potionEffect.getEffectAmount() + " Speed";
		}
		return this.getSpriteName()+"\n"+"\n"
				+ "Lasts " + potionEffect.getDefaultEffectTime() + " Secs" + "\n" 
				+ "Speed Multiplier: " + "X" + potionEffect.getEffectAmount() + " Speed";
	}
}
