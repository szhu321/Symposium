package sprite.character.effect;

import sprite.character.Character;
import sprite.character.player.Player;

public class AmmoEffect extends Effect
{
	public static final AmmoEffect AMMO_MAGAZINE_EFFECT = new AmmoEffect(0, 15, false);
	
	public static final AmmoEffect AMMO_BOX_EFFECT = new AmmoEffect(0, 50, false);
	
	public static final AmmoEffect AMMO_PACK_EFFECT = new AmmoEffect(0, 150, false);
	
	public AmmoEffect(double effectTime, double effectAmount, boolean instantaneous)
	{
		super(effectTime, effectAmount, instantaneous);
	}

	@Override
	public boolean applyEffect(Character character) 
	{
		if(isActive() && character instanceof Player)
		{
			((Player)character).setCurrentAmmo(((Player) character).getCurrentAmmo() + (int)getEffectAmount());
			setEffectTime(getEffectTime() - (1 / EffectManager.TIMES_RUN_PER_SEC));
			return true;
		}
		return false;
	}
	
}
