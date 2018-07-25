package sprite.character.effect;

import sprite.character.Character;

public class BlindEffect extends Effect
{
	public static final BlindEffect BLINDNESS_EFFECT = new BlindEffect(3, 0, false);
	
	public BlindEffect(double effectTime, double effectAmount, boolean instantaneous)
	{
		super(effectTime, effectAmount, instantaneous);
	}

	@Override
	public boolean applyEffect(Character character, double sec)
	{
		setEffectTime(getEffectTime() - sec);
		return true;
	}

}
