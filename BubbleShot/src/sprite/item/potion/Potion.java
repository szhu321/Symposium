package sprite.item.potion;

import sprite.character.effect.Effect;
import sprite.character.player.Player;
import sprite.item.Item;

public class Potion extends Item
{
	private String potionColor;
	private Effect potionEffect;
	
	public Potion(String spriteName,String fileName, double xLocation, double yLocation, String itemType, String color, 
			Effect effect, boolean isCooledDown, double coolDownTime) 
	{
		super(spriteName , fileName, xLocation, yLocation, itemType, isCooledDown, coolDownTime, 50, 50);
		potionColor = color;
		potionEffect = effect;
	}
	
	public String getColor()
	{
		return potionColor;
	}
	
	public Effect getEffect()
	{
		return potionEffect;
	}
	
	public String toString()
	{
		String output = "";
		output += "Potion effect: " + potionEffect + "\n";
		return output;
	}

	@Override
	public void useItem()
	{
		setCurrentCoolDownTime(getDefaultCoolDownTime());
		setCooledDown(false);
	}
	
	public boolean useItemOnPlayer(Player player)
	{
		setCurrentCoolDownTime(getDefaultCoolDownTime());
		setCooledDown(false);
		player.getEffectManager().addEffect(this.getEffect());
		return true;
	}
}
