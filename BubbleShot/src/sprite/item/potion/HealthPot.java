package sprite.item.potion;

import sprite.character.effect.Effect;

public class HealthPot extends Potion
{
	public HealthPot(String fileName, double xLocation, double yLocation, String itemType, String color, 
			Effect effect,int cost) 
	{
		super("HealthPot","file:resources/potionPictures/healthPotion.png", xLocation, yLocation, 
				itemType, color, effect,cost);
	}

	public String description()
	{
		Effect potionEffect = getEffect();
		if(potionEffect.isInstantaneous())
		{
			return this.getSpriteName()+"\n"+"\n"
					+ "Heals: " + potionEffect.getEffectAmount() + " HP";
		}
		return this.getSpriteName()+"\n"+"\n"
				+ "Lasts: " + potionEffect.getDefaultEffectTime() + " Secs" + "\n" 
				+ "Heals: " + potionEffect.getEffectAmount() + " HP Per Second";
	}
}
