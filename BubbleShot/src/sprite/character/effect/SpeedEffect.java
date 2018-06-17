package sprite.character.effect;

import sprite.character.Character;

public class SpeedEffect extends Effect
{
	
	public static final SpeedEffect SPEED_POTION_EFFECT = new SpeedEffect(20, 1.5, false);
	
	public static final SpeedEffect MUD_TILE_EFFECT = new SpeedEffect(.2, .6, false);
	
	public static final SpeedEffect STONE_TILE_EFFECT = new SpeedEffect(.2, 1.5, false);
	
	public static final SpeedEffect FREEZE_EFFECT = new SpeedEffect(5, 0, false);
	
	public SpeedEffect(double effectTime, double effectAmount, boolean instantaneous)
	{
		super(effectTime, effectAmount, instantaneous);
	}

	@Override
	public boolean applyEffect(Character character, double sec)
	{
		//System.out.println(getEffectTime() - .1);
		setEffectTime(getEffectTime() - sec);
		//System.out.println(getEffectTime() - (1 / EffectManager.TIMES_RUN_PER_SEC));
		return true;
	}
	
}
