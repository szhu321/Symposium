package sprite.character.effect;

import sprite.character.Character;

public class SpeedEffect extends Effect
{
	
	public static final SpeedEffect SPEED_POTION_EFFECT = new SpeedEffect(10, 1.5, false);
	
	public static final SpeedEffect MUD_TILE_EFFECT = new SpeedEffect(2, .75, false);
	
	public SpeedEffect(double effectTime, double effectAmount, boolean instantaneous)
	{
		super(effectTime, effectAmount, instantaneous);
	}

	@Override
	public boolean applyEffect(Character character)
	{
		//character.setCurrentSpeed(character.getCurrentSpeed() * getEffectAmount());
		setEffectTime(getEffectTime() - .1);
		return true;
	}
	
	@Override
	public void removeEffect()
	{
		getThisManager().removeEffect(this);
	}
	
	public String toString()
	{
		return "Effect: SpeedEffect, EffectTime: " + getEffectTime() + " sec. + EffectAmount: " + getEffectAmount() + "(SpeedMultiplier).";
	}
}
