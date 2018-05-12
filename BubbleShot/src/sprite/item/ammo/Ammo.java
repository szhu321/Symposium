package sprite.item.ammo;

import sprite.item.Consumable;
import sprite.item.Item;
import sprite.character.Character;
import sprite.character.effect.Effect;
import sprite.character.player.Player;

public class Ammo extends Item implements Consumable
{
	private Effect ammoEffect;
	
	public Ammo(String spriteName, String fileName, double xLocation, double yLocation, 
			String itemType, boolean isCooledDown, double coolDownTime, double width, 
			double height, Effect ammoEffect) 
	{
		super(spriteName, fileName, xLocation, yLocation, itemType, isCooledDown, coolDownTime, 
				width, height);
		this.ammoEffect = ammoEffect;
	}

	public Effect getEffect()
	{
		return ammoEffect;
	}
	
	@Override
	public boolean useItem() 
	{
		Character character = this.getPossessor();
		return false;
	}
	
	public boolean useItemOnPlayer(Player player)
	{
		setCurrentCoolDownTime(getDefaultCoolDownTime());
		setCooledDown(false);
		player.getEffectManager().addEffect(this.getEffect());
		return true;
	}
	
}
