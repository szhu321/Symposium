package sprite.character.effect;

import sprite.character.Character;

public class HealthEffect extends Effect
{
	
	public static final HealthEffect HEALTH_POTION_EFFECT = new HealthEffect(0, 200, true);

	public static final HealthEffect LAVA_TILE_EFFECT = new HealthEffect(1, -2, false);
	
	public static final HealthEffect POSION_SWAMP_EFFECT = new HealthEffect(2, -2, false);
	
	public static final HealthEffect SPIKE_TRAP_EFFECT = new HealthEffect(1, -5, false);
	
	public HealthEffect(double effectTime, double effectAmount, boolean instantaneous)
	{
		super(effectTime, effectAmount, instantaneous);
	}

	@Override
	public boolean applyEffect(Character character, double sec) 
	{
		if(isActive())
		{
			//if the effect is instantaneous
			if(isInstantaneous())
			{
				character.setCurrentHealth(character.getCurrentHealth() + getEffectAmount());
				setActive(false);
			}
			else
			{
				character.setCurrentHealth(character.getCurrentHealth() + (getEffectAmount() * sec));
				//System.out.println("IT TIME " + getEffectTime());
				setEffectTime(getEffectTime() - sec);
			}
			return true;
		}
		return false;
	}
	
}
