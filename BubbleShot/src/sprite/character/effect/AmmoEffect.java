package sprite.character.effect;

import sprite.character.Character;
import sprite.character.player.Player;

public class AmmoEffect extends Effect
{
	public static final AmmoEffect AMMO_MAGAZINE_EFFECT = new AmmoEffect(0, 50, true);
	
	public static final AmmoEffect AMMO_BOX_EFFECT = new AmmoEffect(0, 200, true);
	
	public static final AmmoEffect AMMO_PACK_EFFECT = new AmmoEffect(0, 400, true);
	
	public AmmoEffect(double effectTime, double effectAmount, boolean instantaneous)
	{
		super(effectTime, effectAmount, instantaneous);
	}

	@Override
	public boolean applyEffect(Character character, double sec) 
	{
		if(isActive() && character instanceof Player)
		{
			if(isInstantaneous())
			{
				((Player)character).setCurrentAmmo(((Player) character).getCurrentAmmo() + (int)getEffectAmount());
				setEffectTime(getEffectTime() - sec);
				setActive(false);
			}
			return true;
		}
		return false;
	}
	
}
