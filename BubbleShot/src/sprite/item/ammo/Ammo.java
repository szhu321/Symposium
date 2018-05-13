package sprite.item.ammo;

import sprite.item.Consumable;
import sprite.item.Item;
import sprite.character.Character;
import sprite.character.effect.Effect;
import sprite.character.player.Player;

public class Ammo extends Item implements Consumable
{
	private Effect ammoEffect;
	
	public Ammo(String spriteName, String fileName, double xLocation, double yLocation,  double width, double height, String itemType, Effect ammoEffect) 
	{
		super(spriteName, fileName, xLocation, yLocation, width, height,itemType);
		this.ammoEffect = ammoEffect;
	}

	public Effect getEffect()
	{
		return ammoEffect;
	}
	
	@Override
	public boolean useItemOnPlayer(Player player)
	{
		player.getEffectManager().addEffect(this.getEffect());
		return true;
	}
}
