package sprite.item.potion;

import sprite.character.effect.Effect;
import sprite.character.player.Player;
import sprite.item.Consumable;
import sprite.item.Item;

public abstract class Potion extends Item implements Consumable
{
	private String potionColor;
	private Effect potionEffect;
	
	public Potion(String spriteName,String fileName, double xLocation, double yLocation, String itemType, String color, 
			Effect effect,int cost) 
	{
		super(spriteName, fileName, xLocation, yLocation, 50, 50, itemType,cost);
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
	public boolean useItemOnPlayer(Player player)
	{
		player.getEffectManager().addEffect(this.getEffect());
		return true;
	}
	
	@Override
	public abstract String description();
}
