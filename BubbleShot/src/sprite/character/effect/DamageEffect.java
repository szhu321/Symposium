package sprite.character.effect;

import sprite.character.Character;

public class DamageEffect extends Effect
{
	public static final DamageEffect DAMAGE_POTION_EFFECT = new DamageEffect(20, 1.5, false);
	
	public DamageEffect(double effectTime, double effectAmount, boolean instantaneous)
	{
		super(effectTime, effectAmount, instantaneous);
	}

	@Override
	public boolean applyEffect(Character character, double sec) 
	{
		setEffectTime(getEffectTime() - sec);
		return true;
	}
	
	public String toString()
	{
		return "Effect: DamageEffect, EffectTime: " + getEffectTime() + " sec. + EffectAmount: " + getEffectAmount() + "HP.";
	}
}
