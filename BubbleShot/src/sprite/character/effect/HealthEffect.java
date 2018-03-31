package sprite.character.effect;

import sprite.character.Character;

public class HealthEffect extends Effect
{
	
	public static final HealthEffect HEALTH_POTION_EFFECT = new HealthEffect(0, 30, true);

	public static final HealthEffect POSION_SWAMP_EFFECT = new HealthEffect(2, -2, false);
	
	public static final HealthEffect SPIKE_TRAP_EFFECT = new HealthEffect(1, -5, false);
	
	public HealthEffect(double effectTime, int effectAmount, boolean instantaneous)
	{
		super(effectTime, effectAmount, instantaneous);
	}

	@Override
	public boolean applyEffect(Character character) 
	{
		character.setCurrentHealth(character.getCurrentHealth() + (int)getEffectAmount());
		setEffectTime(getEffectTime() - 1);
		return true;
	}
	
	public String toString()
	{
		return "Effect: HealthEffect, EffectTime: " + getEffectTime() + " sec. + EffectAmount: " + getEffectAmount() + "HP.";
	}
}
