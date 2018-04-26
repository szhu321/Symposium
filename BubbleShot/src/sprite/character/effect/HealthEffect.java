package sprite.character.effect;

import sprite.character.Character;

public class HealthEffect extends Effect
{
	
	public static final HealthEffect HEALTH_POTION_EFFECT = new HealthEffect(0, 30, false);

	public static final HealthEffect POSION_SWAMP_EFFECT = new HealthEffect(2, -2, false);
	
	public static final HealthEffect SPIKE_TRAP_EFFECT = new HealthEffect(1, -5, false);
	
	public HealthEffect(double effectTime, double effectAmount, boolean instantaneous)
	{
		super(effectTime, effectAmount, instantaneous);
	}

	@Override
	public boolean applyEffect(Character character) 
	{
		if(isActive())
		{
			character.setCurrentHealth(character.getCurrentHealth() + (int)getEffectAmount());
			//System.out.println("IT TIME " + getEffectTime());
			setEffectTime(getEffectTime() - (1 / EffectManager.TIMES_RUN_PER_SEC));
			return true;
		}
		return false;
	}
	
}
